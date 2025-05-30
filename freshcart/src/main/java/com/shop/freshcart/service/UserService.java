package com.shop.freshcart.service;

import com.shop.freshcart.config.CustomUserDetails;
import com.shop.freshcart.config.JwtUtil;
import com.shop.freshcart.dto.ChangePasswordDTO;
import com.shop.freshcart.dto.LoginRequestDTO;
import com.shop.freshcart.dto.SignupRequestDTO;
import com.shop.freshcart.dto.UserDTO;
import com.shop.freshcart.entities.AccountType;
import com.shop.freshcart.entities.User;
import com.shop.freshcart.exception.EmptyFieldException;
import com.shop.freshcart.exception.InvalidCredentialsException;
import com.shop.freshcart.exception.ResourceNotFoundException;
import com.shop.freshcart.exception.UserAlreadyExistsException;
import com.shop.freshcart.mapper.SignupRequestMapper;
import com.shop.freshcart.mapper.UserMapper;
import com.shop.freshcart.mapper.UserUpdateMapper;
import com.shop.freshcart.repository.AccountTypeRepository;
import com.shop.freshcart.repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final SignupRequestMapper signupRequestMapper;
    private final UserUpdateMapper userUpdateMapper;
    private final AccountTypeRepository accountTypeRepository;
    private final JwtUtil jwtUtil;

    @CacheEvict(value = "allUsers", allEntries = true)
    public Map<String, Object> signup(SignupRequestDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("Email already registered.");
        }

        User user = signupRequestMapper.toEntity(dto);
        AccountType defaultAccountType = accountTypeRepository.findByName("USER")
                .orElseThrow(() -> new ResourceNotFoundException("Default USER role not found"));

        user.setAccountType(defaultAccountType);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        SignupRequestDTO responseDto = signupRequestMapper.toDto(user);
        responseDto.setPassword(null); // Ensure password is not exposed

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Sign-up successful");
        response.put("user", responseDto);

        return response;
    }


    public Map<String, Object> login(LoginRequestDTO loginRequestDTO) {
        if (loginRequestDTO.getEmail() == null || loginRequestDTO.getPassword() == null ||
                loginRequestDTO.getEmail().trim().isEmpty() || loginRequestDTO.getPassword().trim().isEmpty()) {
            throw new EmptyFieldException("Email and password must not be empty");
        }

        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email not found"));

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(new CustomUserDetails(user));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("token", token);
        response.put("user", new UserDTO(user));

        return response;
    }

    @Cacheable(value = "allUsers")
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "users", key = "#id")
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
        return userMapper.toDto(user);
    }

    @Caching(evict = {
            @CacheEvict(value = "users", key = "#userId"),
            @CacheEvict(value = "allUsers", allEntries = true)
    })
    public String updateUser(Long userId, UserDTO dto) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        userUpdateMapper.updateUserFromDto(dto, existingUser);
        userRepository.save(existingUser);
        return "Update Successful";
    }

    @CacheEvict(value = "users", key = "#userId")
    public String changePassword(Long userId, ChangePasswordDTO dto) {
        if (dto.getNewPassword() == null || dto.getNewPassword().isEmpty()) {
            throw new EmptyFieldException("Password cannot be empty.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));

        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Entered old password is incorrect.");
        }

        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
        return "Password updated successfully.";
    }

    @Caching(evict = {
            @CacheEvict(value = "users", key = "#userId"),
            @CacheEvict(value = "allUsers", allEntries = true)
    })
    public String deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        userRepository.delete(user);
        return "User deleted Successfully";
    }

    @CacheEvict(value = "users", key = "#userId")
    public String changeUserAccountType(Long userId, String newAccountTypeName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        AccountType accountType = accountTypeRepository.findByName(newAccountTypeName)
                .orElseThrow(() -> new ResourceNotFoundException("Account type not found: " + newAccountTypeName));

        user.setAccountType(accountType);
        userRepository.save(user);
        return "Account type updated successfully.";
    }
}

