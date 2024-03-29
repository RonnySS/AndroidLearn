package com.example.viewpager2learn;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerFragmentStateAdapter extends FragmentStateAdapter {
    List<Fragment> fragments;

    public ViewPagerFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity,List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}







