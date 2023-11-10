// MainActivity.java
package com.example.equation2nddegree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3;
    private Button calculateButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        calculateButton = findViewById(R.id.button);
        clearButton = findViewById(R.id.buttonEffacer);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });
    }

    private void calculateAndDisplayResult() {
        // Récupérer les valeurs des EditText
        String strA = editText1.getText().toString();
        String strB = editText2.getText().toString();
        String strC = editText3.getText().toString();

        // Convertir les chaînes en nombres
        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);

        // Utiliser la classe EquationSolver pour résoudre l'équation
        String resultText = EquationSolver.solveEquation(a, b, c);

        // Créer un Intent pour ouvrir la nouvelle activité
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", resultText);

        // Démarrer l'activité
        startActivity(intent);
    }

    private void clearInputs() {
        editText1.getText().clear();
        editText2.getText().clear();
        editText3.getText().clear();
    }
}
