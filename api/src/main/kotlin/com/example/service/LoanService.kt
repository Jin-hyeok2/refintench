package com.example.service

import com.example.LoanReviewPort
import com.example.UserInfoPort
import com.example.adapter.`in`.web.LoanInputRequest
import com.example.adapter.`in`.web.LoanRequestResponse
import com.example.adapter.`in`.web.LoanResult
import com.example.adapter.`in`.web.LoanReviewResponse
import com.example.exception.CustomErrorCode
import com.example.exception.CustomException
import com.example.port.LoanRequestUseCase
import com.example.port.LoanReviewUseCase
import com.example.utility.EncryptEncoder
import com.example.utility.KeyGenerator
import org.springframework.stereotype.Service

@Service
class LoanService(
    private val keyGenerator: KeyGenerator,
    private val userInfoPort: UserInfoPort,
    private val loanReviewPort: LoanReviewPort,
    private val encryptEncoder: EncryptEncoder,
) : LoanRequestUseCase, LoanReviewUseCase {

    override fun loanRequest(loanInputRequest: LoanInputRequest): LoanRequestResponse {
        val userKey = keyGenerator.generateUserKey()
        loanInputRequest.userRegisterNumber =
            encryptEncoder.encryptString(loanInputRequest.userRegisterNumber)
        userInfoPort.saveUserInfo(loanInputRequest.toUserInfoDto(userKey))

        return LoanRequestResponse(userKey)
    }

    override fun loanRequestReview() {
        TODO("Not yet implemented")
    }

    override fun loanReview(userKey: String): LoanReviewResponse {
        val loanReview = loanReviewPort.loadLoanReview(userKey)
            ?: throw CustomException(CustomErrorCode.RESULT_NOT_FOUND)

        return LoanReviewResponse(
            userKey = userKey,
            loanResult = LoanResult(
                userLimitAmount = loanReview.loanLimitedAmount,
                userLoanInterest = loanReview.loanInterest
            )
        )
    }
}