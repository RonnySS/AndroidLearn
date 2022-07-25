package com.example.viewpager2learn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.CardViewHolder> {
    public static class CardViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.textView.setText("test"+position);
    }



    @Override
    public int getItemCount() {
        return 4;
    }
}
