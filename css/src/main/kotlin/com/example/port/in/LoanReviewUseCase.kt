package com.example.port.`in`

import com.example.adapter.`in`.web.LoanReviewResponse

interface LoanReviewUseCase {

    fun loanReview(
        userKey: String,
        userName: String,
        userRegisterNumber: String,
        userIncomeAmount: Long
    ) : LoanReviewResponse
}