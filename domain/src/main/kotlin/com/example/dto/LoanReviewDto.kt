package com.example.dto

import com.example.entity.LoanReview
import org.springframework.stereotype.Component

@Component
class LoanReviewMapper {
    fun toEntity(loanReviewDto: LoanReviewDto) = LoanReview(
        userKey = loanReviewDto.userKey,
        loanLimitedAmount = loanReviewDto.loanLimitedAmount,
        loanInterest = loanReviewDto.loanInterest
    )

    fun toDto(loanReview: LoanReview?): LoanReviewDto? {
        loanReview ?: return null
        return LoanReviewDto(
            userKey = loanReview.userKey,
            loanLimitedAmount = loanReview.loanLimitedAmount,
            loanInterest = loanReview.loanInterest
        )
    }
}

data class LoanReviewDto(
    val userKey: String,
    val loanLimitedAmount: Long,
    val loanInterest: Double
)