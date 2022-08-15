package com.example.doanandroid;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HotelViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    ImageView imgView, img1, img2;
    TextView txtView;
    RatingBar ratingBar;


    public HotelViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardV1);
        imgView = itemView.findViewById(R.id.imgview);
        img1 = itemView.findViewById(R.id.img_detail_hotel);
        img2 = itemView.findViewById(R.id.imgview);
        txtView = itemView.findViewById(R.id.txtview2);
        ratingBar = itemView.findViewById(R.id.ratingBar);
    }
}
