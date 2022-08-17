package com.example.doanandroid;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

public class MySing {
    private static MySing mInstance;
    private RequestQueue mRequestQueu;
    private Context mContext;

    public MySing(Context mContext){
        this.mContext = mContext;
        mRequestQueu = getmRequestQueu();
    }
    public  RequestQueue getmRequestQueu(){
        if(mRequestQueu == null){
            Cache cache = new DiskBasedCache(mContext.getCacheDir(), 1024*1024);
            Network network = new BasicNetwork(new HurlStack());
            mRequestQueu = new RequestQueue(cache, network);
            mRequestQueu = Volley.newRequestQueue(mContext.getApplicationContext());

        }
        return mRequestQueu;
    }

    public  static synchronized MySing getmInstance(Context context){
        if(mInstance == null){
            mInstance = new MySing(context);
        }
        return mInstance;
    }
    public <T> void addToRequestQueue(Request<T> request){
        mRequestQueu.add(request);
    }
}
