package com.example.doanandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {
    Context context;
    ArrayList<User> list;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    public UserAdapter(Context context) {
        this.context = context;
    }
    public void setData(ArrayList<User> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = list.get(position);
        holder.tvname.setText(user.getName());
        holder.tvmail.setText(user.getEmail());
        holder.tvphone.setText(user.getPhoneNum());
        holder.tvdiachi.setText(user.getAddress());
        holder.tvgioitinh.setText(user.getSex());
    }
    public void release(){
        context = null;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

}
