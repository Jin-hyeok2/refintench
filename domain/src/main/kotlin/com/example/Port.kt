package com.example

import com.example.dto.LoanReviewDto
import com.example.dto.UserInfoDto

interface LoanReviewPort {
    fun loadLoanReview(userKey: String): LoanReviewDto?
}

interface UserInfoPort {
    fun saveUserInfo(userInfoDto: UserInfoDto): UserInfoDto
}
