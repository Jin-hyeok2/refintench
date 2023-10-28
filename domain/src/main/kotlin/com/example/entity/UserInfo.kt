package com.example.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "USR_INFO")
class UserInfo(
    @Column(name = "usr_key")
    val userKey: String,
    @Column(name = "usr_reg_num")
    val userRegisterNumber: String,
    @Column(name = "usr_nm")
    val userName: String,
    @Column(name = "usr_icn_amt")
    val userIncomeAmount: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}