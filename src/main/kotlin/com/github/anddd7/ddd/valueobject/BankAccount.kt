package com.github.anddd7.ddd.valueobject

data class BankAccount(
    val accountNo: String,
    val bankName: String,
    var balance: Int,
)
