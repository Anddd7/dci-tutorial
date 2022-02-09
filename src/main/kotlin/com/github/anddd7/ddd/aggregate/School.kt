package com.github.anddd7.ddd.aggregate

import com.github.anddd7.ddd.entity.People

data class School(
    val name: String,
    val students: MutableList<People> = mutableListOf(),
) {
    fun onboard(student: People) {
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
