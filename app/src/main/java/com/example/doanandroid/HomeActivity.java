package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.SearchView;
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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rcvKs;
    private ReviewAdapter reviewAdapter;
    ArrayList<KhachSan> arrayList;
    private TextView email;
    private String txtemail;
    public static String NAME = "NAME";

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);

        rcvKs = findViewById(R.id.rcv_ks);
        rcvKs.setHasFixedSize(true);
        reviewAdapter = new ReviewAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvKs.setLayoutManager(new LinearLayoutManager(this));

//        reviewAdapter.setData(getListKS());
//        rcvKs.setAdapter(reviewAdapter);

        arrayList = new ArrayList<KhachSan>();
//        Intent intent = new Intent(HomeActivity.this,ChiTietActivity.class);
//        String emailUser = getIntent().getStringExtra("object_user");
//        intent.putExtra("object_email",emailUser);
        email = findViewById(R.id.tvemail);
        Intent intent = getIntent();
        txtemail = intent.getStringExtra(NAME);
        //email.setText("hi"+txtemail);
        Hotel hotel = new Hotel();
        hotel.execute();

    }
    public class Hotel extends AsyncTask<String, String, String> {
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

                    //stringBuffer.append(line);
                    mainfile = mainfile + line;

                }
                //mainfile = stringBuffer.toString();

                //JSONArray parent = new JSONArray(mainfile);
                if(!mainfile.isEmpty()){
                    JSONObject jsonObject = new JSONObject(mainfile);
                    JSONArray hotels = jsonObject.getJSONArray("");
                    arrayList.clear();
                    for (int i=0; i<hotels.length();i++){
                        JSONObject hotelObj = hotels.getJSONObject(i);
                        String ten = hotelObj.getString("ten");
                        int id = hotelObj.getInt("id");
                        String hinh = hotelObj.getString("hinhanh");
                        String star = hotelObj.getString("sao");
                        String des = hotelObj.getString("mota");
                        String price = hotelObj.getString("gia");
                        String img1 = hotelObj.getString("hinh1");
                        String img2 = hotelObj.getString("hinh2");
                        arrayList.add(new KhachSan(id, ten, hinh, star, des, price, img1, img2));
                    }

                }
//                int i = 0;
//                while (i <= parent.length()){
//
//                    JSONObject child = new JSONObject();
//                    String name = child.getString("ten");
//                    String img = child.getString("hinhanh");
////                    String star = child.getString("sao");
//                    arrayList.add(new KhachSan(name, img));
//                        i++;
//                }

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

            ReviewAdapter reviewAdapter = new ReviewAdapter(getApplicationContext());
            reviewAdapter.setData(arrayList);
            rcvKs.setAdapter(reviewAdapter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(reviewAdapter!=null){
            reviewAdapter.release();
        }
    }
}

