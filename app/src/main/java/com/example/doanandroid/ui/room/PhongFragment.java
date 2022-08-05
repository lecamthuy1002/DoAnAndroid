package com.example.doanandroid.ui.room;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.doanandroid.Phong;
import com.example.doanandroid.PhongDouble;
import com.example.doanandroid.PhongSingle;
import com.example.doanandroid.R;
import com.example.doanandroid.databinding.FragmentPhongBinding;

import java.util.ArrayList;


public class PhongFragment extends Fragment {
    public class Phong extends AppCompatActivity {

        CardView cardView, cardView2;
        EditText searchView;

        Animation anim_from_button, anim_from_top, anim_from_left;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_phong);

            cardView = findViewById(R.id.cardView);
            cardView2 = findViewById(R.id.cardView2);
            searchView = findViewById(R.id.searchView);

            //Load Animations
            anim_from_button = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
            anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
            anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);

            //Set Animations
            cardView.setAnimation(anim_from_button);
            cardView2.setAnimation(anim_from_button);
            searchView.setAnimation(anim_from_left);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent secondActivity = new Intent(com.example.doanandroid.Phong.this, PhongSingle.class);
                    startActivity(secondActivity);
                }
            });
            cardView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent fourthActivity = new Intent(com.example.doanandroid.Phong.this, PhongDouble.class);
                    startActivity(fourthActivity);
                }
            });
            //Hide status bar and navigation bar at the bottom
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            );

            this.getWindow().getDecorView().setSystemUiVisibility(

                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

            );

        }
    }
/*//text23
    adapterroom adapter;
    FragmentActivity listener;
    CardView cardView, cardView2;
    EditText searchView;

    Animation anim_from_button, anim_from_top, anim_from_left;

    private FragmentPhongBinding binding;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.listener = (FragmentActivity) context;
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Room> things = new ArrayList<Room>();
        adapter = new adapterroom(getActivity(), things);

        cardView = (CardView) cardView.findViewById(R.id.cardView);
        cardView2 = (CardView) cardView2.findViewById(R.id.cardView2);
        searchView = (EditText) searchView.findViewById(R.id.searchView);

        //Load Animations
        anim_from_button = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);

        //Set Animations
        cardView.setAnimation(anim_from_button);
        cardView2.setAnimation(anim_from_button);
        searchView.setAnimation(anim_from_left);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent secondActivity = new Intent(Phong.this, PhongSingle.class);
                //startActivity(secondActivity);

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent fourthActivity = new Intent(Phong.this, PhongDouble.class);
                //startActivity(fourthActivity);
            }
        });
        //Hide status bar and navigation bar at the bottom
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        this.getWindow().getDecorView().setSystemUiVisibility(

                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lv = (ListView) view.findViewById(R.id.lvSome);
        //lv.setAdapter(adapter);
    }

    // This method is called when the fragment is no longer connected to the Activity
    // Any references saved in onAttach should be nulled out here to prevent memory leaks.
    @Override
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    // This method is called after the parent Activity's onCreate() method has completed.
    // Accessing the view hierarchy of the parent activity must be done in the onActivityCreated.
    // At this point, it is safe to search for activity View objects by their ID, for example.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_phong, container, false);
        //return root;
    }*/
}