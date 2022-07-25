package com.example.viewpager2learn.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager2learn.R

class Fragmen4:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View? = inflater.inflate(R.layout.fragment_4,container,false)
        if (view != null) {


            view.setOnClickListener (){
                print(1)
                print(2)
            }

            view.setOnClickListener(object:View.OnClickListener{
                override fun onClick(v: View?) {
                    print(1)
                    print(2)
                }
            })
        }
        return view
    }
}