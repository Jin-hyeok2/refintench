package com.example

import com.example.entity.LoanReview
import com.example.entity.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoRepository: JpaRepository<UserInfo, Long> {
    fun findByUserKey(userKey: String) : UserInfo?
}

interface LoanReviewRepository: JpaRepository<LoanReview, Long> {
    fun findByUserKey(userKey: String) : LoanReview?
}