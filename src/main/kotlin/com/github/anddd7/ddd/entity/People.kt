package com.github.anddd7.ddd.entity

import com.github.anddd7.ddd.valueobject.BankAccount
import com.github.anddd7.ddd.valueobject.IdentityCard
import com.github.anddd7.ddd.valueobject.StudentCard
import com.github.anddd7.ddd.valueobject.WorkCard

data class People(
    val identityCard: IdentityCard,
    val studentCard: StudentCard,
    val workCard: WorkCard,
    val account: BankAccount,
    val id: String = identityCard.id,
) {

    fun study() {
        println("$studentCard is studying")
    }

    fun exam() {
        println("$studentCard is doing exam")
    }

    fun eat() {
        println("$identityCard is eating")
        account?.run { balance-- }
    }

    fun sleep() {
        println("$identityCard is sleeping")
    }

    fun playGame() {
        println("$identityCard is playing game")
    }

    fun work() {
        println("$identityCard is working")
        account?.run { balance++ }
    }

    fun offline() {
        println("$identityCard is offline")
    }

    fun buyTicket() {
        println("$identityCard is buying ticket")
        account?.run { balance-- }
    }

    fun enjoy() {
        println("$identityCard is enjoying")
    }
}

