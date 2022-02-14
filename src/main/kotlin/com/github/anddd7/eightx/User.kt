package com.github.anddd7.eightx

// 订阅上下文
interface Subscription
interface Column        // 专栏
interface Context       // 专栏下的目录

// 支付上下文
interface Order         // 订单
interface Payment       // 支付

// 社交上下文
interface Friendship    // 好友关系
interface Moments       // 朋友圈

data class User(
    private val id: Long,
)
