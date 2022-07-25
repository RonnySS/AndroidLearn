package com.example.arouterlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.arouterlearn.bean.Employee;
import com.example.arouterlearn.fragments.BlankFragment1;

@Route(path = "/test/activity")
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment targetFragment = (Fragment)ARouter.getInstance().build("/fragments/no1")
                        .navigation();


                BlankFragment1 bk1 = new BlankFragment1();
                ft.add(R.id.fragmentHolder,bk1)
                        .commit();


            }
        });

    }

    public void jumpByScheme(){
        String url = "scheme://mtime/goodsDetail?goodsId=10011002";
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(intent);
    }


    void navToActivity(){
        ARouter.getInstance().build("/test/activity2")
                        .withString("name","mike")
                        .withInt("age",18)
                        .withObject("human",new Employee("Bob",30000))
                        .withBoolean("girl",true)
                .navigation();
    }
}