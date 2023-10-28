package com.example.dto

import com.example.entity.UserInfo
import org.springframework.stereotype.Component

@Component
class UserInfoMapper {

    fun toEntity(userInfoDto: UserInfoDto): UserInfo = UserInfo(
        userKey = userInfoDto.userKey,
        userRegisterNumber = userInfoDto.userRegisterNumber,
        userName = userInfoDto.userName,
        userIncomeAmount = userInfoDto.userIncomeAmount
    )

    fun toDto(userInfo: UserInfo): UserInfoDto = UserInfoDto(
        userKey = userInfo.userKey,
        userName = userInfo.userName,
        userRegisterNumber = userInfo.userRegisterNumber,
        userIncomeAmount = userInfo.userIncomeAmount
    )
}

data class UserInfoDto(
    val userKey: String,
    val userName: String,
    val userRegisterNumber: String,
    val userIncomeAmount: Long,
)
