package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DatPhongActivity extends AppCompatActivity {

//    ArrayList<User> arrayList;
//    User main;
//    String emailPut, name1, email1, phone1, addr1;
//    KhachSan hotels;
//    EditText name, email, phone, address, hotel, quantity, ngaydat, ngaynhan;
//    TextView tvName;

    public static String NAME = "NAME";
    EditText ten, mail, dienthoai, cmnd, khachsan, soluong, ngaydatphong, ngaynhanphong;
    Button books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //xử lý sự kiện nút đặt phòng
        ten = (EditText) findViewById(R.id.edname);
        mail = (EditText) findViewById(R.id.edmail);
        dienthoai = (EditText) findViewById(R.id.edphone);
        cmnd = (EditText) findViewById(R.id.edaddress);
        khachsan = (EditText) findViewById(R.id.ednamehotel);
        soluong = (EditText) findViewById(R.id.edSoluong);

        ngaydatphong = (EditText) findViewById(R.id.edNgayDat);
        ngaynhanphong = (EditText) findViewById(R.id.edNgaynhan);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = simpleDateFormat.format(calendar.getTime());
        ngaydatphong.setText(currentDate);
        books = (Button) findViewById(R.id.booking);
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtten = ten.getText().toString();
                String txtmail = mail.getText().toString();
                String txtdt = dienthoai.getText().toString();
                String txtdc = cmnd.getText().toString();
                String txtks = khachsan.getText().toString();
                String txtsl = soluong.getText().toString();
                String txtdatp = ngaydatphong.getText().toString();
                String txtnhanp = ngaynhanphong.getText().toString();
                if (TextUtils.isEmpty(txtsl) || TextUtils.isEmpty(txtdatp) || TextUtils.isEmpty(txtnhanp)) {
                    Toast.makeText(DatPhongActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                } else {

                    registerNewAccount(txtten, txtmail, txtdt, txtdc, txtks, txtsl, txtdatp, txtnhanp);

                }
            }

//            startActivity(new Intent(DatPhongActivity.this, LoginActivity .class));
//
//            finish();


        });
    }
    private void registerNewAccount(String ten, String mail, String dienthoai, String cmnd, String khachsan, String soluong, String ngaydatphong, String ngaynhanphong){
        ProgressDialog progressDialog = new ProgressDialog(DatPhongActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Booking Successful");
        String url = "http://10.0.2.2:8080/loginregister/datphong.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Sucessfully booking")){
                    progressDialog.dismiss();
                    Toast.makeText(DatPhongActivity.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DatPhongActivity.this, DatPhongActivity.class));
                    finish();
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(DatPhongActivity.this, "Đặt phòng thành công!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DatPhongActivity.this, HomeActivity.class));
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error == null || error.networkResponse == null){
                    progressDialog.dismiss();
                    Toast.makeText(DatPhongActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
                String body;
                //final String status = String.valueOf(error.networkResponse.statusCode);
//                try {
//                    body = new String(error.networkResponse.data, "UTF-8");
//
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }

            }
        }){
            protected Map<String, String> getParams()throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("hoten", ten);
                param.put("email", mail);
                param.put("dienthoai", dienthoai);
                param.put("cmnd", cmnd);
                param.put("khachsan", khachsan);
                param.put("soluong", soluong);
                param.put("ngaydat", ngaydatphong);
                param.put("ngaynhan", ngaynhanphong);
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(DatPhongActivity.this).addToRequestQueue(request);
    }

}