package com.example.producer

import com.example.dto.LoanRequestMessagingDto
import com.example.enumulation.KafkaTopic
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class LoanRequestSender(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {
    fun sendMessage(topic: KafkaTopic, loanRequestMessagingDto: LoanRequestMessagingDto) {
        kafkaTemplate.send(topic.topicName, objectMapper.writeValueAsString(loanRequestMessagingDto))
    }
}