package com.example

import com.example.dto.LoanRequestMessagingDto
import com.example.enumulation.KafkaTopic

interface SendMessagePort {
    fun sendMessage(kafkaTopic: KafkaTopic, loanRequestMessagingDto: LoanRequestMessagingDto)
}