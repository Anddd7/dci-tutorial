package com.github.anddd7.dci.objects

import com.github.anddd7.dci.context.Employee
import com.github.anddd7.dci.context.EmployeeTrait
import com.github.anddd7.dci.context.Human
import com.github.anddd7.dci.context.HumanTrait
import com.github.anddd7.dci.context.Student
import com.github.anddd7.dci.context.StudentTrait
import com.github.anddd7.dci.context.Visitor
import com.github.anddd7.dci.context.VisitorTrait
import com.github.anddd7.ddd.valueobject.BankAccount
import com.github.anddd7.ddd.valueobject.IdentityCard
import com.github.anddd7.ddd.valueobject.StudentCard
import com.github.anddd7.ddd.valueobject.WorkCard

/**
 * object, compose roles and implement traits
 * |    constructor         =>  聚合数据
 * |    create roles        =>  组合行为
 * |    implement traits    =>  角色转换
 */
data class People(
    private val _identityCard: IdentityCard,
    private val _studentCard: StudentCard,
    private val _workCard: WorkCard,
    private val _account: BankAccount,
) : HumanTrait, StudentTrait, EmployeeTrait, VisitorTrait {

    private val _human: Human = object : Human {
        override val identityCard: IdentityCard = _identityCard
        override val account: BankAccount = _account
    }
    private val student: Student = object : Student {
        override val human: Human = _human
        override val studentCard: StudentCard = _studentCard
    }
    private val employee: Employee = object : Employee {
        override val human: Human = _human
        override val workCard: WorkCard = _workCard
    }
    private val visitor: Visitor = object : Visitor {
        override val human: Human = _human
    }

    override fun asHuman() = _human
    override fun asEmployee() = employee
    override fun asVisitor() = visitor
    override fun asStudent() = student
}
