package com.luv2code.spring_boot_library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.spring_boot_library.entity.Book;
import com.luv2code.spring_boot_library.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Page<Book> getAllBooks(
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "pageSize", required = false) Integer pageSize,
            @RequestParam(name = "size", required = false) Integer size) {

        int currentPage = pageNo != null ? pageNo : (page != null ? page : 0);
        int currentSize = pageSize != null ? pageSize : (size != null ? size : 3);

        if (currentPage < 0) {
            currentPage = 0;
        }
        if (currentSize <= 0) {
            currentSize = 3;
        }

        return bookService.getAllBooks(currentPage, currentSize);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search/title")
    public Page<Book> findByTitleContaining(
            @RequestParam String title,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {

        int currentPage = pageNo != null ? pageNo : 0;
        int currentSize = pageSize != null ? pageSize : 3;

        if (currentPage < 0) {
            currentPage = 0;
        }
        if (currentSize <= 0) {
            currentSize = 3;
        }

        return bookService.findByTitleContaining(title, currentPage, currentSize);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search/category")
    public Page<Book> findByCategory(
            @RequestParam String category,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {

        int currentPage = pageNo != null ? pageNo : 0;
        int currentSize = pageSize != null ? pageSize : 3;

        if (currentPage < 0) {
            currentPage = 0;
        }
        if (currentSize <= 0) {
            currentSize = 3;
        }

        return bookService.findByCategory(category, currentPage, currentSize);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
}
