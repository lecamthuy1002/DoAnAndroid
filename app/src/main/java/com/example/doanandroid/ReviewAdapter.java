package com.example.doanandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<HotelViewHolder> {

   Context mContext;
   ArrayList<KhachSan> list;

    public ReviewAdapter(Context mContext, ArrayList<KhachSan> list) {
        this.mContext = mContext;
        this.list = list;
    }


    public ReviewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(ArrayList<KhachSan> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(mContext).inflate(R.layout.item_khachsan, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        KhachSan khachSan = list.get(position);
        holder.txtView.setText(khachSan.getTenks());
        Float s =Float.valueOf(khachSan.getRating());
        holder.ratingBar.setRating(s);
        Picasso.with(mContext).load(khachSan.getImg()).into(holder.imgView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToDetail(khachSan);
            }
        });

    }

    private void onClickGoToDetail(KhachSan ks){
        Intent intent = new Intent(mContext, ChiTietActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_hotel", ks);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public void release(){
        mContext=null;
    }

    @Override
    public int getItemCount() {

        return list.size();
    }


}
