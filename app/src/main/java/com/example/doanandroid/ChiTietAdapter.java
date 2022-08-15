package com.example.doanandroid;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChiTietAdapter extends RecyclerView.Adapter<CTHolder> {
    Context context;
    ArrayList<CTDatPhong> list;

    @NonNull
    @Override
    public CTHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CTHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
