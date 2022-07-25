package com.example.arouterlearn.UtilClass;


import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

//@Route(path = "/sdasd/sadasf")
public class DegradeServiceImpl implements DegradeService {

    @Override
    public void onLost(Context context, Postcard postcard) {
        Log.d("TAG", "全局onLost: ");
    }

    @Override
    public void init(Context context) {

    }
}
