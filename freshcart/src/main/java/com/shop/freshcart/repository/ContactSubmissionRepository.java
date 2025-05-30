package com.shop.freshcart.repository;

import com.shop.freshcart.entities.ContactSubmissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactSubmissionRepository extends JpaRepository<ContactSubmissions, Long> {
}
