package com.example.arouterlearn.UtilClass;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

//@Interceptor(priority = 8,name = "登录拦截")
public class LoginInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        int state = 1;
        if(path.equals("/test/activity2")){
            if (state == 1){
                Log.d("TAG", "process: 拦截了");
                callback.onContinue(postcard);
                //callback.onInterrupt(new Throwable("还没有登录，去登陆"));
            }else {
                Log.d("TAG", "process: 没拦截");
                callback.onContinue(postcard);
            }
        }else {
            callback.onContinue(postcard);
            Log.d("TAG", "process: 拦截器至少动了");
        }
    }

    @Override
    public void init(Context context) {
        Log.d("LoginInterceptor", "LoginInterceptor初始化了");
    }
}
