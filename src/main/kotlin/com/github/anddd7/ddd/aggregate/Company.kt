package com.github.anddd7.ddd.aggregate

import com.github.anddd7.ddd.entity.People

data class Company(
    val name: String,
    val employees: MutableList<People> = mutableListOf(),
) {
    fun onboard(employee: People) {
        employees.add(employee)
        println("$employee is onboarded to company")
    }

    fun run() {
        for (employee in employees) employee.work()
        for (employee in employees) employee.eat()
        for (employee in employees) employee.offline()
        println("finish working in $name")
    }
}
