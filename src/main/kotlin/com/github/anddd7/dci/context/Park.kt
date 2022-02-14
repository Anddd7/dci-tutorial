package com.github.anddd7.dci.context

import com.github.anddd7.ddd.valueobject.BankAccount
import com.github.anddd7.ddd.valueobject.IdentityCard

data class Park(
    val name: String,
    val visitors: MutableList<Visitor> = mutableListOf(),
) {
    fun enter(visitor: Visitor) {
        visitors.add(visitor)
        println("$visitor is onboarded to park")
    }

    fun leave(visitor: Visitor) {
        visitors.remove(visitor)
        println("$visitor is leaving park")
    }

    fun run() {
        for (visitor in visitors) visitor.buyTicket()
        for (visitor in visitors) visitor.enjoy()
        println("finish playing in $name")
    }
}

interface Visitor : Human {
    val human: Human

    override val identityCard: IdentityCard get() = human.identityCard
    override val account: BankAccount get() = human.account

    fun buyTicket() {
        println("$identityCard is buying ticket")
        account.run { balance-- }
    }

    fun enjoy() {
        println("$identityCard is enjoying")
    }
}

interface VisitorTrait {
    fun asVisitor(): Visitor
}
