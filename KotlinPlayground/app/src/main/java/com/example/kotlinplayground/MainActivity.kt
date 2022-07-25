package com.example.kotlinplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.internal.operators.flowable.FlowableFromCallable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //SSLAgent.getInstance().trustAllHttpsCertificates()
        val retrofit = Retrofit.Builder() //使用自定义的mGsonConverterFactory
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())

            //.addCallAdapterFactory(FlowCallAdapterFactory.create())
            .baseUrl("http://124.221.72.44:8080")
            .build()
        val mApi:APi = retrofit.create(APi::class.java)




        CoroutineScope(Dispatchers.IO).launch {


           flow<News> {
                Log.d("TAG", "至少发出成功了: ")
                emit(mApi.getNews())
                Log.d("TAG", "至少发出成功了: ")

            }.flowOn(Dispatchers.IO)
               .catch {
                   e->{e.printStackTrace()}
               }.collect{
                   println("!!!!"+it.nickName)
               }
            //print("哈哈哈哈出来了${mApi.getNews()}")
//            mApi.getNormalNews().enqueue(object : Callback<News> {
//                override fun onResponse(p0: Call<News>, p1: Response<News>) {
//                    Log.d("TAG", "onResponse: ${p1.body()?.exist}")
//                }
//
//                override fun onFailure(p0: Call<News>, p1: Throwable) {
//                    Log.d("TAG", "onFailure: ")
//                }
//
//            })

                //

        }





    }
    fun outCoroutine(){
        println("当前的线程与协程信息是:${Thread.currentThread().name}")
    }
}


data class News(var nickName:String): Serializable {

}