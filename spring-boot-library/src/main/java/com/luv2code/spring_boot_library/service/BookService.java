package com.luv2code.spring_boot_library.service;

import org.springframework.data.domain.Page;

import com.luv2code.spring_boot_library.entity.Book;

public interface BookService {
    Page<Book> getAllBooks(int pageNo, int pageSize);

    Page<Book> findByTitleContaining(String title, int pageNo, int pageSize);

    Page<Book> findByCategory(String category, int PageNo, int pageSize);

    Book getBookById(Long id);
}
