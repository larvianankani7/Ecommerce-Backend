package com.syssian.ecommerce.controller;

import com.syssian.ecommerce.model.ContactMessage;
import com.syssian.ecommerce.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @PostMapping
    public ResponseEntity<?> submitContactForm(@RequestBody ContactMessage message) {
        // Save the received message into the database
        ContactMessage savedMessage = contactMessageRepository.save(message);
        
        // Return a JSON response confirming successful submission
        return ResponseEntity.ok(Map.of(
            "success", true,
            "message", "Thank you, " + savedMessage.getName() + "! Your message has been received.",
            "id", savedMessage.getId()
        ));
    }
}