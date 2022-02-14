package com.github.anddd7.dci.context

import com.github.anddd7.ddd.valueobject.BankAccount
import com.github.anddd7.ddd.valueobject.IdentityCard
import com.github.anddd7.ddd.valueobject.WorkCard

/**
 * context, business logic for a specific role
 */
data class Company(
    val name: String,
    val employees: MutableList<Employee> = mutableListOf(),
) {
    fun onboard(employee: Employee) {
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

/**
 * role, required data and how to interact with the context
 *
 * ps: 这里用类继承也没是可以的, 角色的继承关系会相对明确, 没有歧义
 */
interface Employee : Human {
    val human: Human
    val workCard: WorkCard

    override val identityCard: IdentityCard get() = human.identityCard
    override val account: BankAccount get() = human.account

    fun work() {
        println("$identityCard is working")
        account.run { balance++ }
    }

    fun offline() {
        println("$identityCard is offline")
    }
}

/**
 * trait, role casting
 */
interface EmployeeTrait {
    fun asEmployee(): Employee
}
