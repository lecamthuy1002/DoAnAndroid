package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.AndroidException;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.doanandroid.ui.home.HomeFragment;

import org.w3c.dom.Document;

import javax.xml.transform.Result;

public class RegisterActivity extends AppCompatActivity {

    EditText hoten, email, dienthoai, diachi, password;
    RadioGroup radioGroup;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        hoten = (EditText) findViewById(R.id.fullname);
        email = (EditText)  findViewById(R.id.email);
        dienthoai = (EditText) findViewById(R.id.phone);
        diachi = (EditText) findViewById(R.id.address);
        password = (EditText) findViewById(R.id.password);
        radioGroup = (RadioGroup) findViewById(R.id.rdroup);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txthoten = hoten.getText().toString();
                String txtemail = email.getText().toString();
                String txtdienthoai = dienthoai.getText().toString();
                String txtdiachi = diachi.getText().toString();
                String txtpass = password.getText().toString();
                if(TextUtils.isEmpty(txthoten) || TextUtils.isEmpty(txtemail) || TextUtils.isEmpty(txtdiachi) || TextUtils.isEmpty(txtdienthoai) || TextUtils.isEmpty(txtpass)){
                    Toast.makeText(RegisterActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
                else {
                    int gioiTinhId = radioGroup.getCheckedRadioButtonId();
                    RadioButton selected_gioitinh = radioGroup.findViewById(gioiTinhId);
                    if(selected_gioitinh == null){
                        Toast.makeText(RegisterActivity.this, "Select gender please!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String selectGioitinh = selected_gioitinh.getText().toString();
                        registerNewAccount(txthoten, txtemail, txtdienthoai, txtdiachi, txtpass, selectGioitinh);

                    }
                }
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
    private void registerNewAccount(String hoten, String email, String dienthoai, String diachi, String password, String gioitinh){
        ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Registering New Account");
        String url = "http://10.0.2.2:8080/loginregister/register.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Successfully Register")){
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error == null || error.networkResponse == null){
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
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
            protected Map<String, String> getParams()throws AuthFailureError{
                HashMap<String, String> param = new HashMap<>();
                param.put("hoten", hoten);
                param.put("email", email);
                param.put("dienthoai", dienthoai);
                param.put("diachi", diachi);
                param.put("gioitinh", gioitinh);
                param.put("password", password);
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(RegisterActivity.this).addToRequestQueue(request);
    }


}




