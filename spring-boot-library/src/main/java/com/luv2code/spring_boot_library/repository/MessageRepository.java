package com.luv2code.spring_boot_library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.spring_boot_library.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findByUserEmail(String userEmail,
            PageRequest pageable);

    Page<Message> findByClosed(boolean blosed, Pageable pageable);

}
