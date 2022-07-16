package com.example.workloadmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetStart extends AppCompatActivity {

    private Button btnGetStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);

        btnGetStart = (Button) findViewById(R.id.button6);
        btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeviceIDconfig();
            }
        });
    }

    public void openDeviceIDconfig(){
        Intent intent = new Intent(this, BTDeviceList.class);
        startActivity(intent);
    }
}