package com.example.adapter.`in`.web

import com.example.port.LoanRequestUseCase
import com.example.port.LoanReviewUseCase
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@WebMvcTest(LoanController::class)
class LoanControllerTest {

    private lateinit var mockMvc: MockMvc

    private lateinit var loanController: LoanController

    @MockBean
    private lateinit var loanRequestUseCase: LoanRequestUseCase

    @MockBean
    private lateinit var loanReviewUseCase: LoanReviewUseCase

    private lateinit var mapper: ObjectMapper

    companion object {
        private const val baseUrl = "/fintech/api/v1"
    }

    @BeforeEach
    fun init() {
        loanController = LoanController(loanRequestUseCase, loanReviewUseCase)
        mockMvc = MockMvcBuilders.standaloneSetup(loanController).build()
        mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }

    @Test
    @DisplayName("유저 요청이 들어오면 정상 응답을 주어야 한다")
    fun loanRequestNormalCase() {
        val loanInputRequest = LoanInputRequest(
            userName = "Test",
            userIncomeAmount = 10000,
            userRegisterNumber = "000100-1001010"
        )

        mockMvc.post("$baseUrl/request") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(loanInputRequest)
        }.andExpect {
            status { isOk() }
        }
    }
}