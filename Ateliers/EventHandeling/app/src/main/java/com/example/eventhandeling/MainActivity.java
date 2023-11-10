package com.example.eventhandeling;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNum1, editTextNum2;
    private Button buttonSum, buttonClear;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editText);
        editTextNum2 = findViewById(R.id.editText2);
        buttonSum = findViewById(R.id.button5);
        buttonClear = findViewById(R.id.button6);
        textViewResult = findViewById(R.id.res);

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSum();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInputs();
            }
        });
    }

    private void calculateSum() {
        String num1Str = editTextNum1.getText().toString();
        String num2Str = editTextNum2.getText().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);

            double sum = num1 + num2;
            textViewResult.setText("Résultat de la somme entre "+num1+"et "+num2+" est : " + sum);
        } else {
            textViewResult.setText("Veuillez entrer des nombres valides.");
        }
    }

    private void clearInputs() {
        editTextNum1.setText("");
        editTextNum2.setText("");
        textViewResult.setText("");
    }
}
