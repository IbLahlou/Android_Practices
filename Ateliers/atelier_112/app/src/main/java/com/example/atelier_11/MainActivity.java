package com.example.atelier_11;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner jour = (Spinner) findViewById(R.id.Mesjours);
        jour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
               String j= adapterView.getItemAtPosition(position).toString();
               Toast.makeText(getApplicationContext(),"Jour sélectionné est "+j,Toast.LENGTH_LONG).show();
           }
           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
           }
        });
        Spinner mois = (Spinner) findViewById(R.id.Mesmois);
        mois.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String j= adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Mois sélectionné est "+j,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}