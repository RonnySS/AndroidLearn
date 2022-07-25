package com.example.kotlinplayground

import android.util.Log
import kotlinx.coroutines.*







fun main() {
    runBlocking {
        val user = getUserInfo()
        println("main: $user")
        outCoroutine()
        val friends = getFriendList(user)
        println("main: $friends")
        outCoroutine()
        val feedList = getFeedList(friends)
        println(feedList)
        outCoroutine()
    }
    outCoroutine()
}

fun outCoroutine(){
    println("协程信息:${Thread.currentThread().name}")
}


// delay(1000L)用于模拟网络请求

//挂起函数
// ↓
suspend fun getUserInfo(): String {
    withContext(Dispatchers.IO) {
        outCoroutine()
        delay(1000L)
    }
    outCoroutine()
    return "BoyCoder"
}

//挂起函数
// ↓
suspend fun getFriendList(user: String): String {
    withContext(Dispatchers.IO) {
        outCoroutine()
        delay(1000L)
    }
    outCoroutine()
    return "${user}的朋友:Tom, Jack"
}

//挂起函数
// ↓
suspend fun getFeedList(list: String): String {
    withContext(Dispatchers.IO) {
        outCoroutine()
        delay(1000L)
    }

    return "${list}的动态：{FeedList..}"
}
