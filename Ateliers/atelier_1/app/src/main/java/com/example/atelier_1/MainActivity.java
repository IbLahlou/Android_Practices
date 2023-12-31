package com.example.atelier_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Message affiché est :", "-------");
        Log.i("Message affiché est :", "onCreate");
    }

    @Override protected void onStart() {
        super.onStart();
        Log.i("Message affiché est :", "onStart");
    }

    @Override protected void onPause() {
        super.onPause();
        Log.i("Message affiché est :", "onPause");
    }

    @Override protected void onRestart() {
        super.onRestart();
        Log.i("Message affiché est :", "onRestart");
    }

    @Override protected void onResume() {
        super.onResume();
        Log.i("Message affiché est :", "onResume");
    }

    @Override protected void onStop() {
        super.onStop();
        Log.i("Message affiché est :", "onStop");
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        Log.i("Message affiché est :", "onDestroy");
    }

}