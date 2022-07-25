package com.example.arouterlearn.UtilClass;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

//@Route(path = "/sssss/qqweqwd")
public class JsonServiceImpl implements SerializationService {
    Gson gson;
    @Override
    public void init(Context context) {
        gson = new Gson();
    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        Log.d("类名", "json2Object: "+clazz.getSimpleName());
        Log.d("TAG", "json2Object: "+text);
        return gson.fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return gson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        Log.d("类名", "json2Object: "+clazz.getTypeName());
        Log.d("TAG", "json2Object: "+input);
        return gson.fromJson(input, clazz);
    }
}
