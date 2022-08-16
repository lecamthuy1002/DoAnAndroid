package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class AdminHomeActivity extends AppCompatActivity {

    Button btnTaiKhoan, btnKhachSan, btnDonHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnTaiKhoan = findViewById(R.id.btn_QLTaiKhoan);
        btnKhachSan = findViewById(R.id.btn_QLKhachSan);
        btnDonHang = findViewById(R.id.btn_QLDonHang);

        btnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminHomeActivity.this, "Thông tin tài khoản", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminHomeActivity.this,UserActivity.class));
            }
        });

        btnKhachSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminHomeActivity.this, "Thông tin khách sạn", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminHomeActivity.this,KhachSanAdminActivity.class));
            }
        });

        btnDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminHomeActivity.this, "Thông tin đặt phòng", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminHomeActivity.this,ThongTinDatPhongActivity.class));
            }
        });
    }
}