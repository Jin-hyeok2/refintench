package com.example.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class LoanControllerAdvice {

    @ExceptionHandler(CustomException::class)
    fun handleException(customException: CustomException): ResponseEntity<ErrorResponseDto> =
        ErrorResponse(customException).toResponseEntity()
}