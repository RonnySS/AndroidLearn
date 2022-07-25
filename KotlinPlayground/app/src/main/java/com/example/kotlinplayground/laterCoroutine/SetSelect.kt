package com.example.kotlinplayground.laterCoroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.selects.select


// 代码段2
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val productId = "xxxId"

    val cacheDeferred = async { getCacheInfo(productId) }
    val latestDeferred = async { getNetworkInfo(productId) }
    //          1，注意这里
    //               ↓
    val product = select<Product?> {
        // 2，注意这里
        cacheDeferred
            .onAwait { // 3，注意这里
                it?.copy(isCache = true)
            }
        // 4，注意这里
        latestDeferred
            .onAwait {  // 5，注意这里
                it?.copy(isCache = false)
            }
    }

    if (product != null) {
        updateUI(product)
        println("Time cost: ${System.currentTimeMillis() - startTime}")

    }

    if(product != null&&product.isCache){
        val latest = latestDeferred.await()?: return@runBlocking
        updateUI(latest)
        println("Time cost: ${System.currentTimeMillis() - startTime}")
    }
}

suspend fun getCacheInfo(productId:String):Product?{
    delay(100)
    return Product(productId,9.9,true)
}

suspend fun getNetworkInfo(productId: String):Product?{
    delay(200)
    return Product(productId,9.8,false)
}


fun updateUI(product: Product){
    println("现在的价格是${product.price}")
}

data class Product(
    val productId:String,
    val price:Double,
    val isCache:Boolean
)

/*
输出结果
xxxId==9.9
Time cost: 127
*/