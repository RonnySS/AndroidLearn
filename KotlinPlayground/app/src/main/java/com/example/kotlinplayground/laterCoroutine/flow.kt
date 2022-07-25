package com.example.kotlinplayground.laterCoroutine

import com.example.kotlinplayground.logX
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.flowOn

// 代码段17



fun main() = runBlocking {


    logX("当前的线程")
    val scope = CoroutineScope(Dispatchers.IO)
    val flow = flow {
        logX("Start")
        emit(1)
        logX("Emit: 1")
        emit(2)
        logX("Emit: 2")
        emit(3)
        logX("Emit: 3")
    }
        .flowOn(Dispatchers.IO)
        .filter {
            logX("Filter: $it")
            it > 2
        }
        .onEach {
            logX("onEach $it")
        }

    val flow2 = flow{
        emit(1)
    }

    flow.launchIn(scope)

    delay(100L)
}