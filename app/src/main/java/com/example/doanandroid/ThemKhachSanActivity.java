package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ThemKhachSanActivity extends AppCompatActivity {

    Button btnThem;
    EditText ten, sosao, hinh, mota, gia, hinh1, hinh2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_khach_san);

        ten = (EditText) findViewById(R.id.tenksthem);
        sosao = (EditText) findViewById(R.id.sosaothem);
        hinh = (EditText) findViewById(R.id.hinhanhthem);
        mota = (EditText) findViewById(R.id.motathem);
        gia = (EditText) findViewById(R.id.giathem);
        hinh1 = (EditText) findViewById(R.id.hinh1them);
        hinh2 = (EditText) findViewById(R.id.hinh2them);


        btnThem = (Button) findViewById(R.id.btn_ThemKS);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtten = ten.getText().toString();
                String txtsao = sosao.getText().toString();
                String txthinh = hinh.getText().toString();
                String txtmota = mota.getText().toString();
                String txtgia = gia.getText().toString();
                String txthinh1 = hinh1.getText().toString();
                String txthinh2 = hinh2.getText().toString();
                if (TextUtils.isEmpty(txtten) || TextUtils.isEmpty(txtmota) || TextUtils.isEmpty(txtgia)) {
                    Toast.makeText(ThemKhachSanActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                } else {
                    themKhachSan(txtten, txtsao, txthinh, txtmota, txtgia, txthinh1, txthinh2);

                }
            }
        });
    }
    private void themKhachSan(String ten, String sosao, String hinh, String mota, String gia, String hinh1, String hinh2){
        ProgressDialog progressDialog = new ProgressDialog(ThemKhachSanActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Booking Successful");
        String url = "http://10.0.2.2:8080/loginregister/inserthotel.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Sucessfully insert")){
                    progressDialog.dismiss();
                    Toast.makeText(ThemKhachSanActivity.this, response, Toast.LENGTH_SHORT).show();

                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(ThemKhachSanActivity.this, "Thêm khách sạn thành công!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ThemKhachSanActivity.this, AdminHomeActivity.class));
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error == null || error.networkResponse == null){
                    progressDialog.dismiss();
                    Toast.makeText(ThemKhachSanActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
                String body;
                final String status = String.valueOf(error.networkResponse.statusCode);
                try {
                    body = new String(error.networkResponse.data, "UTF-8");

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }){
            protected Map<String, String> getParams()throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("ten", ten);
                param.put("sao", sosao);
                param.put("hinhanh", hinh);
                param.put("mota", mota);
                param.put("gia", gia);
                param.put("hinh1", hinh1);
                param.put("hinh2", hinh2);
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySing.getmInstance(ThemKhachSanActivity.this).addToRequestQueue(request);
    }
}