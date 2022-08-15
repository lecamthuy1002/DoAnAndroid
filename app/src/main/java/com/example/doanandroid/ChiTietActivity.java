package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ChiTietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        TextView tvName, tvPrice, tvDesc;
        RatingBar rt;
        ImageView imageView, img1, img2;
        Button btnBook;

        Bundle bundle = getIntent().getExtras();
        if(bundle==null){
            return;
        }

        KhachSan khachSan = (KhachSan) bundle.get("object_hotel");

        tvName = findViewById(R.id.tv_detail_name);
        rt = findViewById(R.id.rtb_detail);
        imageView = findViewById(R.id.img_detail_view);
        btnBook = findViewById(R.id.btn_bookRoom);
        tvPrice = findViewById(R.id.tv_detail_price);
        tvDesc = findViewById(R.id.tv_detail_des);
        img1 = findViewById(R.id.img_detail_view1);
        img2 = findViewById(R.id.img_detail_view3);
        tvName.setText(khachSan.getTenks());
        rt.setRating(Float.valueOf(khachSan.getRating()));
        Picasso.with(this).load(khachSan.getImg()).into(imageView);
        tvPrice.setText(khachSan.getPrice());
        tvDesc.setText(khachSan.getDescribe());
        Picasso.with(this).load(khachSan.getImg1()).into(img1);
        Picasso.with(this).load(khachSan.getImg2()).into(img2);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChiTietActivity.this, "Vui lòng kiểm tra thông tin đặt phòng",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ChiTietActivity.this, DatPhongActivity.class);
                startActivity(intent);
            }
        });
    }

}