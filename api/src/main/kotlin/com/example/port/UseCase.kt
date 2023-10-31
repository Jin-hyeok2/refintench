package com.example.port

import com.example.adapter.`in`.web.LoanInputRequest
import com.example.adapter.`in`.web.LoanRequestResponse
import com.example.adapter.`in`.web.LoanReviewResponse

interface LoanRequestUseCase {
    fun loanRequest(loanInputRequest: LoanInputRequest): LoanRequestResponse
}

interface LoanReviewUseCase {
    fun loanReview(userKey: String): LoanReviewResponse
}