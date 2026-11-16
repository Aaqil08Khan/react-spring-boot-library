package com.luv2code.spring_boot_library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.spring_boot_library.entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

    Page<Checkout> findByUserEmail(String userEmail, Pageable pageable);
}
