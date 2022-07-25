package com.example.kotlinplayground.laterCoroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.*

fun main(){
    runBlocking {

        flow {

            emit(1)
            println("发送了第1条")

            emit(2)
            println("发送了第2条")

            emit(3)
            println("发送了第3条")
        }
            .filter{
                it>0
            }
            .collect{
                delay(1000)
                println(it)
            }

    }

}