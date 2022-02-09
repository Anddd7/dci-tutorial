package com.github.anddd7.ddd.aggregate

import com.github.anddd7.ddd.entity.People

data class Park(
    val name: String,
    val visitors: MutableList<People> = mutableListOf(),
) {
    fun enter(visitor: People) {
        visitors.add(visitor)
        println("$visitor is onboarded to park")
    }

    fun leave(visitor: People) {
        visitors.remove(visitor)
        println("$visitor is leaving park")
    }

    fun run() {
        for (visitor in visitors) visitor.buyTicket()
        for (visitor in visitors) visitor.enjoy()
        println("finish playing in $name")
    }
}
