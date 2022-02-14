package com.github.anddd7.eightx.option2

import com.github.anddd7.eightx.Column
import com.github.anddd7.eightx.Context
import com.github.anddd7.eightx.Friendship
import com.github.anddd7.eightx.User

/**
 * 由context独立控制角色和其行为
 */
interface SubscriptionContext {
    interface Reader {
        fun canView(context: Context): Boolean
    }

    fun asReader(user: User): Reader
}

interface SocialContext {
    interface Contact {
        fun make(friendship: Friendship): Unit
        fun cancel(friendship: Friendship): Unit
    }

    fun asContact(user: User): Contact
}

interface OrderContext {
    interface Buyer {
        fun placeOrder(column: Column): Unit = TODO()
    }

    fun asBuyer(user: User): Buyer
}

/**
 * 由repo提供context的环境
 */
interface UserRepository {
    fun findById(id: Long): User?
    fun inSubscriptionContext(): SubscriptionContext
    fun inSocialContext(): SocialContext
    fun inOrderContext(): OrderContext
}

fun flow(
    repo: UserRepository,   // injected
    context: Context,       // method parameter
    column: Column,         // method parameter
    friendship: Friendship, // method parameter
) {
    val users: UserRepository = repo
    val user = users.findById(1) ?: return

    val reader = users.inSubscriptionContext().asReader(user)
    reader.canView(context)

    val buyer = users.inOrderContext().asBuyer(user)
    buyer.placeOrder(column)

    val contact = users.inSocialContext().asContact(user)
    contact.make(friendship)
    contact.cancel(friendship)
}
