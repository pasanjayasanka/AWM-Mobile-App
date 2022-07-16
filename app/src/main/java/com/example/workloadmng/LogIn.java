package com.example.workloadmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogIn extends AppCompatActivity {

    Button btnlog;
    EditText txtuser,txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        btnlog = (Button) findViewById(R.id.button3);
        txtuser = (EditText) findViewById(R.id.editTextTextEmailAddress);
        txtpassword = (EditText) findViewById(R.id.editTextTextPassword);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(txtuser.getText().toString()) || TextUtils.isEmpty(txtpassword.getText().toString())){
                    Toast.makeText(LogIn.this,"Username / Password Required", Toast.LENGTH_LONG).show();
                }else{
                    //proceed to login
                    openProfile();
                }
                //openProfile();
            }
        });
    }

//    public void openProfile() {
//        Intent intent = new Intent(this, Profile.class);
//        startActivity(intent);
//    }
    public void openProfile() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(txtuser.getText().toString());
        loginRequest.setPassword(txtpassword.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(LogIn.this,"Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            startActivity(new Intent(LogIn.this,Profile.class)
                                    .putExtra("data",loginResponse.getName())
                                    .putExtra("token",loginResponse.getToken())
                            );
                        }
                    },700);

                }else{
                    Toast.makeText(LogIn.this,"Login Failed", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LogIn.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }
}