package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

import java.util.HashMap;
import java.util.Map;

public class UpdateKhachSanActivity extends AppCompatActivity {
    EditText idp, tenp, saop, hinhp, motap, giap, hinh1p, hinh2p;
    Button btnCapNhat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_khach_san);

        Bundle bundle = getIntent().getExtras();
        if(bundle==null){
            return;
        }
        KhachSanAdmin khachSanAdmin = (KhachSanAdmin) bundle.get("update_khachsan");
        idp = (EditText) findViewById(R.id.idksphong);
        tenp = (EditText) findViewById(R.id.tenksphong);
        saop = (EditText) findViewById(R.id.sosaophong);
        hinhp = (EditText) findViewById(R.id.hinhanhphong);
        motap = (EditText) findViewById(R.id.motaphong);
        giap = (EditText) findViewById(R.id.giaphong);
        hinh1p = (EditText) findViewById(R.id.hinh11);
        hinh2p = (EditText) findViewById(R.id.hinh22);
        btnCapNhat = (Button) findViewById(R.id.btn_CapNhat);

        idp.setText(khachSanAdmin.getIdks());
        tenp.setText(khachSanAdmin.getTenks());
        saop.setText(khachSanAdmin.getRating());
        hinhp.setText(khachSanAdmin.getImg());
        motap.setText(khachSanAdmin.getDescribe());
        giap.setText(khachSanAdmin.getPrice());
        hinh1p.setText(khachSanAdmin.getImg1());
        hinh2p.setText(khachSanAdmin.getImg2());

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtten = tenp.getText().toString();
                String txtsao = saop.getText().toString();
                String txthinh = hinhp.getText().toString();
                String txtmota = motap.getText().toString();
                String txtgia = giap.getText().toString();
                String txthinh1 = hinh1p.getText().toString();
                String txthinh2 = hinh2p.getText().toString();
                if (TextUtils.isEmpty(txtten) || TextUtils.isEmpty(txtmota) || TextUtils.isEmpty(txtgia)) {
                    Toast.makeText(UpdateKhachSanActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                } else {

                    capNhatKhachSan(txtten, txtsao, txthinh, txtmota, txtgia, txthinh1, txthinh2);

                }
            }
        });
    }

    private void capNhatKhachSan(String ten, String sosao, String hinh, String mota, String gia, String hinh1, String hinh2){
        ProgressDialog progressDialog = new ProgressDialog(UpdateKhachSanActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Booking Successful");
        String url = "http://10.0.2.2:8080/loginregister/updatehotel.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Sucessfully insert")){
                    progressDialog.dismiss();
                    Toast.makeText(UpdateKhachSanActivity.this, response, Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(UpdateKhachSanActivity.this, UpdateKhachSanActivity.class));
//                    finish();
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(UpdateKhachSanActivity.this, "Cập nhật khách sạn thành công!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateKhachSanActivity.this, AdminHomeActivity.class));
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error == null || error.networkResponse == null){
                    progressDialog.dismiss();
                    Toast.makeText(UpdateKhachSanActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
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
        MySing.getmInstance(UpdateKhachSanActivity.this).addToRequestQueue(request);
    }

}