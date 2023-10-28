package com.example.exception

class CustomException(
    val customErrorCode: CustomErrorCode,
) : RuntimeException()