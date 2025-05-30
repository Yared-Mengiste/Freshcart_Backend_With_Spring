package com.shop.freshcart.service;

import com.shop.freshcart.dto.ContactSubmissionDTO;
import com.shop.freshcart.entities.ContactSubmissions;
import com.shop.freshcart.exception.InvalidRequestException;
import com.shop.freshcart.mapper.ContactMapper;
import com.shop.freshcart.repository.ContactSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactSubmissionRepository contactRepository;
    private final ContactMapper contactMapper;

    // 1. Submit a new contact message
    public ContactSubmissionDTO submitContact(ContactSubmissionDTO dto) {
        if (dto.getName() == null || dto.getEmail() == null || dto.getMessage() == null) {
            throw new InvalidRequestException("Name, Email, and Message are required.");
        }

        ContactSubmissions contact = contactMapper.toEntity(dto);
        contact.setCreatedAt(Instant.now());

        ContactSubmissions saved = contactRepository.save(contact);
        return contactMapper.toDto(saved);
    }

//    // 2. Get all contact submissions (admin usage)
//    public ResponseEntity<?> getAllContacts() {
//        List<ContactSubmissions> submissions = contactRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
//        List<ContactSubmissionDTO> dtos = submissions.stream()
//                .map(contactMapper::toDto)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(dtos);
//    }
//
//    // 3. Get a specific contact submission by ID (optional)
//    public ResponseEntity<?> getContactById(Long id) {
//        ContactSubmissions contact = contactRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Contact message not found"));
//        return ResponseEntity.ok(contactMapper.toDto(contact));
//    }
}
