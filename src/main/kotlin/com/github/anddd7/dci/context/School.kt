package com.github.anddd7.dci.context

import com.github.anddd7.ddd.valueobject.BankAccount
import com.github.anddd7.ddd.valueobject.IdentityCard
import com.github.anddd7.ddd.valueobject.StudentCard

data class School(
    val name: String,
    val students: MutableList<Student> = mutableListOf(),
) {
    fun onboard(student: Student) {
        students.add(student)
        println("$student is onboarded to school")
    }

    fun run() {
        for (student in students) student.study()
        for (student in students) student.eat()
        for (student in students) student.exam()
        println("finish studying in $name")
    }
}

interface Student : Human {
    val human: Human
    val studentCard: StudentCard

    override val identityCard: IdentityCard get() = human.identityCard
    override val account: BankAccount get() = human.account

    fun study() {
        println("$studentCard is studying")
    }

    fun exam() {
        println("$studentCard is doing exam")
    }
}

// 特性扮演
interface StudentTrait {
    fun asStudent(): Student
}
