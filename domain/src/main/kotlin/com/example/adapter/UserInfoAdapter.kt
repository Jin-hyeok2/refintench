package com.example.adapter

import com.example.UserInfoPort
import com.example.UserInfoRepository
import com.example.dto.UserInfoDto
import com.example.dto.UserInfoMapper
import org.springframework.stereotype.Repository

@Repository
class UserInfoAdapter(
    private val userInfoRepository: UserInfoRepository,
    private val userInfoMapper: UserInfoMapper
) : UserInfoPort {
    override fun saveUserInfo(userInfoDto: UserInfoDto): UserInfoDto =
        userInfoMapper.toDto(userInfoRepository.save(userInfoMapper.toEntity(userInfoDto)))

}