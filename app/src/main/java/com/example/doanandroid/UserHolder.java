package com.example.doanandroid;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class UserHolder extends RecyclerView.ViewHolder {

    TextView tvname, tvmail, tvphone, tvdiachi, tvgioitinh;


    public UserHolder(@NonNull View itemView) {

        super(itemView);
        tvname = itemView.findViewById(R.id.tvname);
        tvmail = itemView.findViewById(R.id.tvmail);
        tvphone = itemView.findViewById(R.id.tvphone);
        tvdiachi = itemView.findViewById(R.id.tvaddress);
        tvgioitinh = itemView.findViewById(R.id.tvsex);
    }
}
