package com.example.doanandroid;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public DetailHolder(@NonNull View itemView) {
        super(itemView);
        itemView = itemView.findViewById(R.id.img_detail_hotel);
    }
}
