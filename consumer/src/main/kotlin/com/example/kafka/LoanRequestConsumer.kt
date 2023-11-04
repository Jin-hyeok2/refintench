package com.example.kafka

import com.example.dto.LoanRequestMessagingDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class LoanRequestConsumer(
    private val objectMapper: ObjectMapper
) {
    @KafkaListener(topics = ["loan_request"], groupId = "fintech")
    fun loanRequestTopicConsumer(message: String) {
        val loanRequestMessagingDto = objectMapper.readValue(message, LoanRequestMessagingDto::class.java)
        println(loanRequestMessagingDto)
    }
}