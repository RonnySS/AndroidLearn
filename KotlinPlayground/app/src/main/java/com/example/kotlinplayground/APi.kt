package com.example.kotlinplayground

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

public interface APi {

    @GET("/getNickName?username=1138378312")
    suspend fun getNews(): News

    @GET("/findMovie?MapStr=redamption%20for")
    fun getNormalNews(): Call<News>
}