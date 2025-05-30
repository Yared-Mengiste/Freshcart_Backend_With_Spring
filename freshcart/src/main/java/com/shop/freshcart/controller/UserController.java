package com.shop.freshcart.controller;

import com.shop.freshcart.dto.*;
import com.shop.freshcart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDTO signupRequestDTO) {
        Map<String, Object> result = userService.signup(signupRequestDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Map<String, Object> response = userService.login(loginRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody UserDTO dto) {
        String result = userService.updateUser(id, dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update_password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable Long id, @RequestBody ChangePasswordDTO dto) {
        String result = userService.changePassword(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        String result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}/account-type")
    public ResponseEntity<?> updateAccountType(
            @PathVariable Long id,
            @RequestBody ChangeAccountTypeRequestDTO request) {

        String result = userService.changeUserAccountType(id, request.getAccountTypeName());
        return ResponseEntity.ok(result);
    }
}

