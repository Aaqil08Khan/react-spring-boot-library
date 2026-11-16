package com.luv2code.spring_boot_library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.luv2code.spring_boot_library.controller.BookController;
import com.luv2code.spring_boot_library.entity.Book;

@SpringBootTest
class BookPaginationIntegrationTest {

    @Autowired
    private BookController bookController;

    @Test
    void testGetAllBooks_fetchesExactly3Books() {
        Page<Book> result = bookController.getAllBooks(0, null, 3, null);

        assertNotNull(result);
        assertEquals(3, result.getNumberOfElements());
        assertEquals(22, result.getTotalElements());
        assertEquals(8, result.getTotalPages());
    }
}

