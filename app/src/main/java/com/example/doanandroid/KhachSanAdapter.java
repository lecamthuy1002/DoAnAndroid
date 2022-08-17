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

public class KhachSanAdapter extends RecyclerView.Adapter<KhachSanHolderAdmin> {

    Context mContext;
    ArrayList<KhachSanAdmin> list;

    public KhachSanAdapter(Context mContext, ArrayList<KhachSanAdmin> list) {
        this.mContext = mContext;
        this.list = list;
    }
    public void setData(ArrayList<KhachSanAdmin> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public KhachSanAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public KhachSanHolderAdmin onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_khachsanadmin, parent, false);
        return new KhachSanHolderAdmin(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhachSanHolderAdmin holder, int position) {
        KhachSanAdmin khachSanAdmin = list.get(position);
        holder.id.setText(khachSanAdmin.getIdks());
        holder.ten.setText(khachSanAdmin.getTenks());
        holder.sosao.setText(khachSanAdmin.getRating());
        holder.hinhanh.setText(khachSanAdmin.getImg());
        holder.mota.setText(khachSanAdmin.getDescribe());
        holder.gia.setText(khachSanAdmin.getPrice());
        holder.hinh1.setText(khachSanAdmin.getImg1());
        holder.hinh2.setText(khachSanAdmin.getImg2());
        
        holder.relativeLayoutHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoTo(khachSanAdmin);
            }
        });
    }

    private void onClickGoTo(KhachSanAdmin khachSanAdmin) {
        Intent intent = new Intent(mContext, UpdateKhachSanActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("update_khachsan", khachSanAdmin);
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