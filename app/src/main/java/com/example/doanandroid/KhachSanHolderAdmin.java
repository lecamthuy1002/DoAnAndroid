package com.example.doanandroid;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class KhachSanHolderAdmin extends RecyclerView.ViewHolder {

    TextView id, ten, hinhanh, sosao, mota, gia, hinh1, hinh2;
    RelativeLayout relativeLayoutHotel;

    public KhachSanHolderAdmin(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.idks);
        ten = itemView.findViewById(R.id.tenks);
        hinhanh = itemView.findViewById(R.id.hinhanh);
        sosao = itemView.findViewById(R.id.sosao);
        mota = itemView.findViewById(R.id.mota);
        gia = itemView.findViewById(R.id.giap);
        hinh1 = itemView.findViewById(R.id.hinh1);
        hinh2 = itemView.findViewById(R.id.hinh2);
        relativeLayoutHotel = itemView.findViewById(R.id.layout_khachsan);
    }
}
