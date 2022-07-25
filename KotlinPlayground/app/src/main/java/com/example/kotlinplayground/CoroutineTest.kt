package com.example.kotlinplayground

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


// 代码段14

fun main() {

    CoroutineScope(Dispatchers.Default).launch {
        println("launch开始了")
        delay(3000)
        println("launch完成了111111111")
    }

    runBlocking {
        print("runBlocking开始")
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

        val results: List<String>

        val time = measureTimeMillis {

            outCoroutine()
            val result1 = async { getResult1() }
            val result2 = async { getResult2() }
            val result3 = async { getResult3() }

            results = listOf(result1.await(), result2.await(), result3.await())
            outCoroutine()
            println("出结果了！")
        }

        println("Time: $time")
        println(results)

        launch {
            delay(5000)
            println("第一个delay里面结束了")
        }
        println("是仅仅开启了一下，还还是block执行完成了才能执行这条语句？")
        launch {
            delay(5000)
            println("我结束了程序才能结束")
        }
        println("程序最后结束了")
    }
}
/*
输出结果：
Time: 1032
[Result1, Result2, Result3]
*/





// 代码段13



/*
输出结果：
Time: 3018
[Result1, Result2, Result3]
*/