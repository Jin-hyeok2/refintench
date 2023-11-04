package com.example.service

import com.example.adapter.`in`.web.LoanReviewResponse
import com.example.port.`in`.LoanReviewUseCase
import org.springframework.stereotype.Service

@Service
class LoanReviewService: LoanReviewUseCase {
    override fun loanReview(
        userKey: String,
        userName: String,
        userRegisterNumber: String,
        userIncomeAmount: Long
    ): LoanReviewResponse {
        if (userIncomeAmount < 0) throw RuntimeException("Invalid userIncomeAmount Param")
        TODO("Not yet implemented")
    }
}