package com.github.anddd7.mvc.service

import com.github.anddd7.mvc.model.People

class CompanyService {
    fun work(people: People) = people.run {
        println("$identityCard is working")
        account.run { balance++ }
    }

    fun offline(people: People) = people.run {
        println("$identityCard is offline")
    }
}
