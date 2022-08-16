package com.example.doanandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThongTinDatPhongAdapter extends RecyclerView.Adapter<ThongTinDatPhongHolder> {

    Context mContext;
    ArrayList<DatPhong> list;

    public ThongTinDatPhongAdapter(Context mContext, ArrayList<DatPhong> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public ThongTinDatPhongAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ThongTinDatPhongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_datphongadmin, parent, false);
        return new ThongTinDatPhongHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongTinDatPhongHolder holder, int position) {
        DatPhong datPhong = list.get(position);
        holder.tenKH.setText(datPhong.getTen());
        holder.cmnd.setText(datPhong.getCmnd());
        holder.dienthoai.setText(datPhong.getDienthoai());
        holder.soluong.setText(datPhong.getSoluong());
        holder.ngaydat.setText(datPhong.getNgaydat());
        holder.ngaynhan.setText(datPhong.getNgaynhan());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
