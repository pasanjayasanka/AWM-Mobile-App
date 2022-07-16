package com.example.workloadmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private static final String TAG = "BlueTest5-IDConfig";

    private Button btnStart;
    private Button btnUpload;

    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tv1 = (TextView)findViewById(R.id.textView7);

        Intent intent = getIntent();
        String passedUsername = intent.getStringExtra("data");
        tv1.setText(passedUsername);

        token = intent.getStringExtra("token");


        btnStart = (Button) findViewById(R.id.button4);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGetStart();
            }
        });

        btnUpload = (Button) findViewById(R.id.button5);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStartUpload();
            }
        });
    }

    public void openGetStart(){
        Intent intent = new Intent(this, GetStart.class);
        startActivity(intent);
    }

    public void openStartUpload(){
        Intent intent = new Intent(this, BTDeviceListU.class);
        startActivity(intent
                .putExtra("token",token)
        );
    }
}