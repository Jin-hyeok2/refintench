package com.example.adapter.`in`.web

import com.example.dto.UserInfoDto
import com.example.port.LoanRequestUseCase
import com.example.port.LoanReviewUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/api/v1")
class LoanController(
    private val loanRequestUseCase: LoanRequestUseCase,
    private val loanReviewUseCase: LoanReviewUseCase,
) {

    @PostMapping("/request")
    fun loanRequest(@RequestBody loanInputRequest: LoanInputRequest): ResponseEntity<LoanRequestResponse> {
        return ResponseEntity.ok(loanRequestUseCase.loanRequest(loanInputRequest))
    }

    @GetMapping("/review/{userKey}")
    fun getReviewData(@PathVariable userKey: String): ResponseEntity<LoanReviewResponse> {
        return ResponseEntity.ok(loanReviewUseCase.loanReview(userKey))
    }
}

data class LoanInputRequest(
    val userName: String,
    val userIncomeAmount: Long,
    var userRegisterNumber: String,
) {
    fun toUserInfoDto(userKey: String) = UserInfoDto(
        userKey = userKey,
        userRegisterNumber = userRegisterNumber,
        userName = userName,
        userIncomeAmount = userIncomeAmount
    )
}

data class LoanRequestResponse(
    var userKey: String,
)

data class LoanReviewResponse(
    val userKey: String,
    val loanResult: LoanResult,
)

data class LoanResult(
    val userLimitAmount: Long,
    val userLoanInterest: Double,
)