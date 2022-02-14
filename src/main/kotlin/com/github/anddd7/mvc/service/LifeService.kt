package com.github.anddd7.mvc.service

import com.github.anddd7.mvc.model.People

class LifeService(
    private val studentService: StudentService,
    private val companyService: CompanyService,
) {
    fun aNiceDay(people: People) {
        studentService.study(people)
        this.eat(people)
        studentService.exam(people)

        companyService.work(people)
        this.eat(people)
        companyService.offline(people)

        // ...
    }

    fun eat(people: People) {
        people.run {
            println("$identityCard is eating")
            account.run { balance-- }
        }
    }
}

