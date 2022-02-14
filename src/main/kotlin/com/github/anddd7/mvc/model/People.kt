package com.github.anddd7.mvc.model

import com.github.anddd7.ddd.valueobject.BankAccount
import com.github.anddd7.ddd.valueobject.IdentityCard
import com.github.anddd7.ddd.valueobject.StudentCard
import com.github.anddd7.ddd.valueobject.WorkCard

data class People(
    val identityCard: IdentityCard,
    val studentCard: StudentCard,
    val workCard: WorkCard,
    val account: BankAccount,
    val id: String = identityCard.id,
)
