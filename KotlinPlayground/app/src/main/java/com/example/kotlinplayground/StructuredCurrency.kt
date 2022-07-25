package com.example.kotlinplayground

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


// 代码段13

fun main() = runBlocking {
    suspend fun getResult1(): String {
        delay(1000L) // 模拟耗时操作
        outCoroutine()
        return "Result1"

    }

    suspend fun getResult2(): String {
        delay(1000L) // 模拟耗时操作
        outCoroutine()
        return "Result2"
    }

    suspend fun getResult3(): String {
        delay(1000L) // 模拟耗时操作
        outCoroutine()
        return "Result3"
    }

    val results = mutableListOf<String>()

    val time = measureTimeMillis {
        results.add(getResult1())
        results.add(getResult2())
        results.add(getResult3())
    }
    outCoroutine()
    println("Time: $time")
    println("Time:")
    println(results)
}

/*
输出结果：
Time: 3018
[Result1, Result2, Result3]
*/