package com.github.anddd7.ddd.aggregate

import com.github.anddd7.ddd.entity.People

data class Home(
    val address: String,
    var host: People? = null,
) {

    fun back(host: People) {
        println("$host is arriving home at $address")
        this.host = host
    }

    fun run() {
        host?.eat()
        host?.playGame()
        host?.sleep()
    }
}
