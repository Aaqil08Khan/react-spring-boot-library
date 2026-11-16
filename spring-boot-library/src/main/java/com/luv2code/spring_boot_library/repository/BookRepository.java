package com.luv2code.spring_boot_library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.spring_boot_library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByTitleContaining(String title, Pageable pageable);

    Page<Book> findByCategory(String category, Pageable pageable);
}
