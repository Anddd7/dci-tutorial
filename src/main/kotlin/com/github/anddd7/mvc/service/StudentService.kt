package com.github.anddd7.mvc.service

import com.github.anddd7.mvc.model.People

class StudentService {
    fun study(people: People) = people.run {
        println("$people.studentCard is studying")
    }

    fun exam(people: People) = people.run {
        println("$studentCard is doing exam")
    }
}
