package com.example.dto

data class LoanRequestMessagingDto(
    val userKey: String,
    val userName: String,
    val userIncomeAmount: Long,
    val userRegisterNumber: String,
) {
}