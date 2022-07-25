package com.example.arouterlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.arouterlearn.UtilClass.HelloService;
import com.example.arouterlearn.bean.Employee;

import retrofit2.Retrofit;

@Route(path = "/test/activity2")
public class SecondActivity extends AppCompatActivity {
    @Autowired
    public String name;
    @Autowired
    int age;
    @Autowired(name = "girl")
    boolean boy;
    @Autowired
    Employee human;

    @Autowired
    HelloService helloService;

    @Autowired(name = "/yourservicegroupname/hello")
    HelloService helloService2;

    HelloService helloService3;

    HelloService helloService4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ARouter.getInstance().inject(this);
//        Log.d("TAG", "onCreate: "+helloService.sayHello("Vergil"));
//        Log.d("TAG", "onCreate: "+helloService2.sayHello("Vergil"));

//        helloService3 = ARouter.getInstance().navigation(HelloService.class);
//        helloService4 = (HelloService) ARouter.getInstance().build("/yourservicegroupname/hello").navigation();
//
//        helloService3.sayHello("Vergil");
//        helloService4.sayHello("Vergil");
//        Log.d("TAG", "onCreate: "+helloService3.sayHello("Vergil2"));
//        Log.d("TAG", "onCreate: "+helloService4.sayHello("Vergil3"));


//        Uri data = getIntent().getData();
//        Log.d("TAG", "onCreate: "+data.getQueryParameter("goodsId"));
    }
}


