package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

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

public class ThongTinDatPhongActivity extends AppCompatActivity {

    private RecyclerView rcv;
    private ThongTinDatPhongAdapter thongTinDatPhongAdapter;
    ArrayList<DatPhong> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dat_phong);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        rcv = findViewById(R.id.rcv_infoRoom);
        rcv.setHasFixedSize(true);
        thongTinDatPhongAdapter = new ThongTinDatPhongAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<DatPhong>();

        ThongTinDP thongTinDP = new ThongTinDP();
        thongTinDP.execute();
    }

    public class ThongTinDP extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection httpURLConnection = null;
            String mainfile="";
            try {
                URL url = new URL("https://api.npoint.io/2fa29d70df8562ec02cf");
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
                        String id1 = hotelObj.getString("idchitiet");
                        String ten1 = hotelObj.getString("tenkhachhang");
                        String cmnd1 = hotelObj.getString("cmnd");
                        String dienthoai1 = hotelObj.getString("dienthoai");
                        String soluong1 = hotelObj.getString("soluong");
                        String ngaydat1 = hotelObj.getString("ngaydat");
                        String ngaynhan1 = hotelObj.getString("ngaynhan");
                        arrayList.add(new DatPhong(id1, ten1, cmnd1, dienthoai1, soluong1, ngaydat1, ngaynhan1));
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
            ThongTinDatPhongAdapter thongTinDatPhongAdapter = new ThongTinDatPhongAdapter(getApplicationContext(),arrayList);
            rcv.setAdapter(thongTinDatPhongAdapter);
        }

    }
}