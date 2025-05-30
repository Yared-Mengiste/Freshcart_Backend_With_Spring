package com.shop.freshcart.controller;

import com.shop.freshcart.dto.ContactSubmissionDTO;
import com.shop.freshcart.exception.InvalidRequestException;
import com.shop.freshcart.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    // Submit new contact message
    @PostMapping
    public ResponseEntity<?> submitContact(@RequestBody ContactSubmissionDTO dto) {
        try {
            ContactSubmissionDTO responseDto = contactService.submitContact(dto);
            return ResponseEntity.ok(responseDto);
        } catch (InvalidRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An unexpected error occurred while submitting the contact.");
        }
    }

    // Get all contact submissions (admin)
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllContacts() {
//        return contactService.getAllContacts();
//    }
//
//    // Get contact by ID (optional)
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getContactById(@PathVariable Long id) {
//        return contactService.getContactById(id);
//    }
}

