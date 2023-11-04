package com.example.adapter.`in`.web

import com.example.port.`in`.LoanReviewUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/css/api/v1")
class LoanReceiveController(
    private val loanReviewUseCase: LoanReviewUseCase
) {

    @PostMapping("/request")
    fun loanReceive(@RequestBody loanReceiveRequest: LoanReceiveRequest): LoanReviewResponse =
        loanReviewUseCase.loanReview(
            loanReceiveRequest.userKey,
            loanReceiveRequest.userName,
            loanReceiveRequest.userRegisterNumber,
            loanReceiveRequest.userIncomeAmount
        )
}

data class LoanReceiveRequest(
    val userKey: String,
    val userName: String,
    val userRegisterNumber: String,
    val userIncomeAmount: Long,
)

data class LoanReviewResponse(
    val userKey: String,
    val limitAmount: Long,
    val interest: Double,
)