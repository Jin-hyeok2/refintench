package com.example.service

import com.example.LoanReviewPort
import com.example.port.`in`.LoanUseCase
import org.springframework.stereotype.Service

@Service
class LoanRequestService(
    private val loanReviewPort: LoanReviewPort
): LoanUseCase {
    override fun loanRequest() {
        TODO("Not yet implemented")
    }
}