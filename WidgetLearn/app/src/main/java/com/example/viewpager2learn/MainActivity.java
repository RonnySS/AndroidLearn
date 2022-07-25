package com.example.viewpager2learn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.example.viewpager2learn.fragments.Fragmen4;
import com.example.viewpager2learn.fragments.Fragment1;
import com.example.viewpager2learn.fragments.Fragment2;
import com.example.viewpager2learn.fragments.Fragment3;
import com.example.viewpager2learn.fragments.Fragment4;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager_2);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragmen4());
        viewPager2.setAdapter(new ViewPagerFragmentStateAdapter(this,fragments));
        //将tabLayout与viewPager进行绑定
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText("ssss")).attach();
        /*
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
         */

        //若想要实现ViewPager的元素为View，则adapter为一个RecyclerView的adapter
        //，因为大型开发常用fragment，所以不常用
        //viewPager2.setAdapter(new ViewPagerAdapter());



    }
}