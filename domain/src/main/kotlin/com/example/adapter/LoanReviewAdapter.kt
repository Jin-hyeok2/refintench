package com.example.adapter

import com.example.LoanReviewPort
import com.example.LoanReviewRepository
import com.example.dto.LoanReviewDto
import com.example.dto.LoanReviewMapper
import org.springframework.stereotype.Service

@Service
class LoanReviewAdapter(
    private val loanReviewRepository: LoanReviewRepository,
    private val loanReviewMapper: LoanReviewMapper,
): LoanReviewPort {
    override fun loadLoanReview(userKey: String): LoanReviewDto? =
        loanReviewMapper.toDto(loanReviewRepository.findByUserKey(userKey))
}