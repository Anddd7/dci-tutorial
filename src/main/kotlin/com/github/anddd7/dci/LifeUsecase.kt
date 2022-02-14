package com.github.anddd7.dci

import com.github.anddd7.dci.context.Company
import com.github.anddd7.dci.context.Home
import com.github.anddd7.dci.context.Park
import com.github.anddd7.dci.context.School
import com.github.anddd7.dci.objects.People

import com.github.anddd7.ddd.valueobject.BankAccount
import com.github.anddd7.ddd.valueobject.IdentityCard
import com.github.anddd7.ddd.valueobject.StudentCard
import com.github.anddd7.ddd.valueobject.WorkCard

class LifeUsecase {
    fun aNiceDay(people: People) {
        val school = School("mit")              // get by name
        val company = Company("google")         // get by name
        val home = Home("Yuling Road")        // get by people id
        val park = Park("Queens Park")          // static

        school.run {
            onboard(people.asStudent())
            run()
        }
        company.run {
            onboard(people.asEmployee())
            run()
        }
        home.run {
            back(people.asHuman())
            run()
        }
        park.run {
            enter(people.asVisitor())
            run()
            leave(people.asVisitor())
        }
    }
}

fun main() {
    val name = "anddd7"
    val people = People(
        IdentityCard("123456789", name, 18, "Man"),
        StudentCard("10001", name, "mit"),
        WorkCard("888", name, "Developer", "google"),
        BankAccount("5000**********0001", "visa", 10)
    )
    LifeUsecase().aNiceDay(people)
}
