package com.syssian.ecommerce.repository;

import com.syssian.ecommerce.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    // Basic CRUD capabilities (like saving) are inherited automatically!
}