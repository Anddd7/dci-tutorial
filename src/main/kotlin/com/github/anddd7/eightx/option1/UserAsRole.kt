package com.github.anddd7.eightx.option1

import com.github.anddd7.eightx.Column
import com.github.anddd7.eightx.Context
import com.github.anddd7.eightx.Friendship
import com.github.anddd7.eightx.Moments
import com.github.anddd7.eightx.Order
import com.github.anddd7.eightx.Payment
import com.github.anddd7.eightx.Subscription
import com.github.anddd7.eightx.User

data class Reader(
    private val user: User,
) {
    private val subscriptions: List<Subscription> = emptyList()

    fun canView(context: Context): Boolean = TODO()
}

data class Buyer(
    private val user: User,
) {
    private val orders: List<Order> = emptyList()
    private val payments: List<Payment> = emptyList()

    fun placeOrder(column: Column): Unit = TODO()
}

data class Contact(
    private val user: User,
) {
    private val friendships: List<Friendship> = emptyList()
    private val moments: List<Moments> = emptyList()

    fun make(friendship: Friendship): Unit = TODO()
    fun cancel(friendship: Friendship): Unit = TODO()
}

interface UserRepository {
    fun findById(id: Long): User?
    fun asBuyer(user: User): Buyer
    fun asReader(user: User): Reader
    fun asContact(user: User): Contact
}

fun flow(
    repo: UserRepository,   // injected
    context: Context,       // method parameter
    column: Column,         // method parameter
    friendship: Friendship, // method parameter
) {
    val users: UserRepository = repo
    val user = users.findById(1) ?: return

    val reader = users.asReader(user)
    reader.canView(context)

    val buyer = users.asBuyer(user)
    buyer.placeOrder(column)

    val contact = users.asContact(user)
    contact.make(friendship)
    contact.cancel(friendship)
}
