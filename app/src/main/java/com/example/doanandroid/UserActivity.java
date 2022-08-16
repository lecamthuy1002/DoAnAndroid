package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class UserActivity extends AppCompatActivity {

    ArrayList<User> arrayList;
    private TextView tvemail;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    String email1;
    public static String NAM = "NAM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        recyclerView = findViewById(R.id.rcv_user);
        recyclerView.setHasFixedSize(true);
        userAdapter = new UserAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<User>();
        Intent intent = getIntent();
        email1 = intent.getStringExtra(NAM);
        tvemail = findViewById(R.id.txtTravel123);
        //tvemail.setText("Hi "+email1);

        Usersss usersss = new Usersss();
        usersss.execute();
    }
    public class Usersss extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection httpURLConnection = null;
            String mainfile="";
            try {
                URL url = new URL("https://api.npoint.io/8d5eb34204a91dcd3965");
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
                    JSONArray users = jsonObject.getJSONArray("users");
                    arrayList.clear();
                    for (int i=0; i<users.length();i++){
                        JSONObject hotelObj = users.getJSONObject(i);
                        int id = hotelObj.getInt("IDTAIKHOAN");
                        String ten = hotelObj.getString("HOTEN");
                        String dienthoai = hotelObj.getString("DIENTHOAI");
                        String email = hotelObj.getString("EMAIL");
                        String diachi = hotelObj.getString("DIACHI");
                        String gioitinh = hotelObj.getString("GIOITINH");
                        arrayList.add(new User(id, ten, email, dienthoai, diachi, gioitinh));
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
                    UserAdapter userAdapter = new UserAdapter(getApplicationContext(),arrayList);
                    recyclerView.setAdapter(userAdapter);
            }

        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(userAdapter!=null){
            userAdapter.release();
        }
    }
}