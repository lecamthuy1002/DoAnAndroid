package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private Button login;
    private String txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        email = (EditText)  findViewById(R.id.emailLogin);
        password = (EditText) findViewById(R.id.passLogin);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtemail = email.getText().toString().trim();
                String txtpass = password.getText().toString();

                if(TextUtils.isEmpty(txtemail) || TextUtils.isEmpty(txtemail) || TextUtils.isEmpty(txtpass) ){
                    Toast.makeText(LoginActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
                else{
                    String soSanh = "admin123@gmail.com";
                    if(txtemail.equals(soSanh)){
                        loginAdmin(txtemail, txtpass);
                    }else {
                        login(txtemail, txtpass);
                    }

                }

                //finish();
            }
        });
    }//
//////
    private void login(String email, String password){
        ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Registering New Account");
        String url = "http://10.0.2.2:8080/loginregister/login.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("Login Success")){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    if(response.equals("This Email is not valid")||response.equals("Wrong Password")||response.equals("This Email is not registered")){
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra(HomeActivity.NAME, txtemail);
                        startActivity(intent);
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error == null || error.networkResponse == null){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }){
            protected Map<String, String> getParams()throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("email", email);
                param.put("password", password);
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(LoginActivity.this).addToRequestQueue(request);
    }

    private void loginAdmin(String email, String password){
        ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Registering New Account");
        String url = "http://10.0.2.2:8080/loginregister/login.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("Login Success")){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    if(response.equals("This Email is not valid")||response.equals("Wrong Password")||response.equals("This Email is not registered")){
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
                        startActivity(intent);
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error == null || error.networkResponse == null){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }){
            protected Map<String, String> getParams()throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("email", email);
                param.put("password", password);
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(LoginActivity.this).addToRequestQueue(request);
    }
}