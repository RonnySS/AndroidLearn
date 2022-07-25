package com.example.kotlinplayground

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


// 代码段14

@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking {
    // 注意这里
    val scope = CoroutineScope(Job() + Dispatchers.Default)

    scope.launch(CoroutineName("sad")) {
        // 注意这里
        logX(coroutineContext[CoroutineDispatcher] == Dispatchers.Default)
        delay(1000L)
        logX("First end!")  // 不会执行
    }

    delay(500L)
    scope.cancel()
    delay(1000L)
}
/*
输出结果：
================================
true
Thread:MySingleThread @coroutine#2
================================
*/