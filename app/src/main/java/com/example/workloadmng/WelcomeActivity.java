package com.example.workloadmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button btnlog;
    private Button btnaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnlog = (Button) findViewById(R.id.button2);
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogIn();
            }
        });

        btnaccount = (Button) findViewById(R.id.button);
        btnaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAccount();
            }
        });

    }

    public void openLogIn(){
        Intent intent = new Intent(this,LogIn.class);
        startActivity(intent);
    }

    public void openAccount(){
        Intent intent = new Intent(this,CreateAccount.class);
        startActivity(intent);
    }
}