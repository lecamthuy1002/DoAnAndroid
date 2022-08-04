package com.example.doanandroid.ui.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.doanandroid.Phong;
import com.example.doanandroid.PhongSingle;
import com.example.doanandroid.R;
import com.example.doanandroid.databinding.FragmentHomeBinding;
import com.example.doanandroid.databinding.FragmentPhongBinding;
import com.example.doanandroid.ui.home.HomeViewModel;


public class PhongFragment extends Fragment {
//text23
    private FragmentPhongBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PhongViewModel phongViewModel =
                new ViewModelProvider(this).get(PhongViewModel.class);
        binding = FragmentPhongBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final EditText editText = binding.searchView;
        phongViewModel.getText2().observe(getViewLifecycleOwner(), editText::setHint);
        final TextView textView5 = binding.textView5;
        phongViewModel.getText5().observe(getViewLifecycleOwner(), textView5::setText);



        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}