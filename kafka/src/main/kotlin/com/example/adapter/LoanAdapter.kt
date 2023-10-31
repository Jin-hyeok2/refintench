package com.example.adapter

import com.example.SendMessagePort
import com.example.dto.LoanRequestMessagingDto
import com.example.enumulation.KafkaTopic
import com.example.producer.LoanRequestSender
import org.springframework.stereotype.Component

@Component
class LoanAdapter(private val loanRequestSender: LoanRequestSender) : SendMessagePort {
    override fun sendMessage(kafkaTopic: KafkaTopic, loanRequestMessagingDto: LoanRequestMessagingDto) {
        loanRequestSender.sendMessage(kafkaTopic, loanRequestMessagingDto)
    }
}