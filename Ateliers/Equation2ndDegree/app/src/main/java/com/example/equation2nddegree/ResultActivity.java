package com.example.equation2nddegree;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Récupère le résultat de l'intent
        Intent intent = getIntent();
        String resultText = intent.getStringExtra("result");

        // Affiche le résultat dans le TextView approprié
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(resultText);
    }
}
