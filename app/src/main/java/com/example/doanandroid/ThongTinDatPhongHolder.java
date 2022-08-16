package com.example.doanandroid;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ThongTinDatPhongHolder extends RecyclerView.ViewHolder {
    TextView id, tenKH, cmnd, dienthoai, soluong, ngaydat, ngaynhan;

    public ThongTinDatPhongHolder(@NonNull View itemView) {
        super(itemView);

        tenKH = itemView.findViewById(R.id.etName);
        cmnd = itemView.findViewById(R.id.etCMND);
        dienthoai = itemView.findViewById(R.id.etPhone);
        soluong = itemView.findViewById(R.id.etSoLuong);
        ngaydat = itemView.findViewById(R.id.etNgayDat);
        ngaynhan = itemView.findViewById(R.id.etNgaynhan);
    }
}
