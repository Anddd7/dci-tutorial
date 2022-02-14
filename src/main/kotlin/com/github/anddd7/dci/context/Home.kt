package com.github.anddd7.dci.context

import com.github.anddd7.ddd.valueobject.BankAccount
import com.github.anddd7.ddd.valueobject.IdentityCard

data class Home(
    val address: String,
    var host: Human? = null,
) {

    fun back(host: Human) {
        println("$host is arriving home at $address")
        this.host = host
    }

    fun run() {
        host?.eat()
        host?.playGame()
        host?.sleep()
    }
}

interface Human {
    val identityCard: IdentityCard
    val account: BankAccount
    val id: String get() = identityCard.id

    fun eat() {
        println("$identityCard is eating")
        account.run { balance-- }
    }

    fun sleep() {
        println("$identityCard is sleeping")
    }

    fun playGame() {
        println("$identityCard is playing game")
    }
}

interface HumanTrait {
    fun asHuman(): Human
}
