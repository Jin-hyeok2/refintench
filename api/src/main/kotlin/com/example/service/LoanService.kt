package com.example.service

import com.example.LoanReviewPort
import com.example.SendMessagePort
import com.example.UserInfoPort
import com.example.adapter.`in`.web.LoanInputRequest
import com.example.adapter.`in`.web.LoanRequestResponse
import com.example.adapter.`in`.web.LoanResult
import com.example.adapter.`in`.web.LoanReviewResponse
import com.example.dto.LoanRequestMessagingDto
import com.example.dto.UserInfoDto
import com.example.enumulation.KafkaTopic
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
    private val sendMessagePort: SendMessagePort,
    private val encryptEncoder: EncryptEncoder,
) : LoanRequestUseCase, LoanReviewUseCase {

    override fun loanRequest(loanInputRequest: LoanInputRequest): LoanRequestResponse {
        val userKey = keyGenerator.generateUserKey()
        loanInputRequest.userRegisterNumber =
            encryptEncoder.encryptString(loanInputRequest.userRegisterNumber)
        val userInfo = userInfoPort.saveUserInfo(loanInputRequest.toUserInfoDto(userKey))

        sendMessagePort.sendMessage(KafkaTopic.LOAN_REQUEST, userInfo.toLoanRequestKafkaDto())

        return LoanRequestResponse(userKey)
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

    private fun UserInfoDto.toLoanRequestKafkaDto() = LoanRequestMessagingDto(
        userKey = userKey,
        userName = userName,
        userIncomeAmount = userIncomeAmount,
        userRegisterNumber = userRegisterNumber
    )
}
