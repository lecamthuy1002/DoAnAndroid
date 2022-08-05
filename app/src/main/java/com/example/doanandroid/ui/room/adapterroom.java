package com.example.doanandroid.ui.room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanandroid.R;

import java.util.List;

public class adapterroom extends RecyclerView.Adapter<adapterroom.ViewHolder>{
    Context context;
    List<Room> list;
    public adapterroom(Context context, List<Room> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hotelcard,parent,false));
    }
    public void setHotels(List<Room> lists) {
        this.list = lists;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgView.setImageResource(list.get(position).getImageUrl());
        holder.hotelRatings.setText(list.get(position).getRatings());
        holder.tags.setText(list.get(position).getTags());
        holder.name.setText(list.get(position).getName());
        holder.hotelViews.setText(list.get(position).getVisits() + "\nViews");
        holder.bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView name, hotelRatings, hotelViews,tags;
        Button bookButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = imgView.findViewById(R.id.hotelImage);
            name = name.findViewById(R.id.hotelName);
            hotelRatings = itemView.findViewById(R.id.ratings);
            bookButton = itemView.findViewById(R.id.hotelBookButton);
            tags = itemView.findViewById(R.id.tagsList);
            hotelViews = itemView.findViewById(R.id.hotelCardViews);
        }
    }
}
