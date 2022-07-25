package com.example.arouterlearn.UtilClass;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;


//@Route(path = "/yourservicegroupname/hello", name = "test service")
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }

    @Override
    public void init(Context context) {
        Log.d("TAG", "init: helloImpl发生了初始化");
    }
}

