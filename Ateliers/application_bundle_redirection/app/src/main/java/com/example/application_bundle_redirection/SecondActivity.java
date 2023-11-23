package com.example.application_bundle_redirection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        res = findViewById(R.id.result);

        String result = getIntent().getStringExtra("result");
        res.setText(result);
    }
}