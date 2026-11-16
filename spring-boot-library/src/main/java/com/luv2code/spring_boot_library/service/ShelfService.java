package com.luv2code.spring_boot_library.service;

import org.springframework.data.domain.Page;

import com.luv2code.spring_boot_library.responsemodels.ShelfCurrentLoansResponse;
import com.luv2code.spring_boot_library.responsemodels.ShelfHistoryResponse;

public interface ShelfService {
    Page<ShelfCurrentLoansResponse> currentLoans(String userEmail, int pageNo, int pageSize) throws Exception;

    void returnBook(String userEmail, Long bookId) throws Exception;

    Page<ShelfHistoryResponse> loansHistory(String userEmail, int pageNo, int pageSize) throws Exception;
}
