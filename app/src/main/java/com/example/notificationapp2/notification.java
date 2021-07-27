package com.example.notificationapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class notification extends AppCompatActivity {

    TextView mtxtshowmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mtxtshowmessage=findViewById(R.id.lblShowActivity);

        String msg= getIntent().getStringExtra("message");
        mtxtshowmessage.setText(msg);
    }
}