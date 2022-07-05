package com.example.workmanagerandsoon;

import android.app.Application;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageViewBindingAdapter {
    @BindingAdapter("image")
    public static void setImage(ImageView image,String oldimageUrl,String newimageUrl){
        if (!TextUtils.isEmpty(newimageUrl)){
            Log.d("TAG", "发生了setImage: "+newimageUrl+"新值是："+oldimageUrl);
            Glide.with(image.getContext()).load(newimageUrl).into(image);
        }else {
            image.setBackgroundColor(Color.BLUE);
        }
    }

    @BindingAdapter("image")
    public static void setImage(ImageView image,int imageResource){
        image.setImageResource(imageResource);
    }

    @BindingAdapter("padding")
    public static void serPadding(View view,int oldPadding,int newPadding){

    }


}
