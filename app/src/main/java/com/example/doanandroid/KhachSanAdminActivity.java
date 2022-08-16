package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class KhachSanAdminActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private KhachSanAdapter khachSanAdapter;
    public ArrayList<KhachSanAdmin> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_san_admin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = findViewById(R.id.rcv_adminhotel);
        recyclerView.setHasFixedSize(true);
        khachSanAdapter = new KhachSanAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<KhachSanAdmin>();
        HolderKhachSan holderKhachSan = new HolderKhachSan();
        holderKhachSan.execute();

    }
    public class HolderKhachSan extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection httpURLConnection = null;
            String mainfile="";
            try {
                URL url = new URL("https://api.npoint.io/5eb62aa46ffca932003f");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line;
                while((line = bufferedReader.readLine())!=null){
                    mainfile = mainfile + line;
                }

                if(!mainfile.isEmpty()){
                    JSONObject jsonObject = new JSONObject(mainfile);
                    JSONArray hotelss = jsonObject.getJSONArray("");
                    arrayList.clear();
                    for (int i=0; i<hotelss.length();i++){
                        JSONObject hotelObj = hotelss.getJSONObject(i);
                        String id = hotelObj.getString("id");
                        String ten = hotelObj.getString("ten");
                        String hinh = hotelObj.getString("hinhanh");
                        String star = hotelObj.getString("sao");
                        String des = hotelObj.getString("mota");
                        String price = hotelObj.getString("gia");
                        String img1 = hotelObj.getString("hinh1");
                        String img2 = hotelObj.getString("hinh2");
                        arrayList.add(new KhachSanAdmin(id, ten, hinh, star, des, price, img1, img2));
                    }

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            KhachSanAdapter khachSanAdapter = new KhachSanAdapter(getApplicationContext());
            khachSanAdapter.setData(arrayList);
            recyclerView.setAdapter(khachSanAdapter);
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(khachSanAdapter!=null){
            khachSanAdapter.release();
        }
    }
}