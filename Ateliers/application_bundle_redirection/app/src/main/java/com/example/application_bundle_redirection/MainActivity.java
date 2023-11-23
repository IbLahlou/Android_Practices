package com.example.application_bundle_redirection;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nbr1, nbr2, nbr3;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nbr1 = findViewById(R.id.nbr1);
        nbr2 = findViewById(R.id.nbr2);
        nbr3 = findViewById(R.id.nbr3);
        result = findViewById(R.id.result);

        Button computeButton = findViewById(R.id.compute);
        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(MainActivity.this , SecondActivity.class);
                secondeActivite.putExtra("result",calculateResult());
                startActivity(secondeActivite);
            }
        });

        Button eraseButton = findViewById(R.id.erase);
        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private String calculateResult() {

        double a = Double.parseDouble(nbr1.getText().toString());
        double b = Double.parseDouble(nbr2.getText().toString());
        double c = Double.parseDouble(nbr3.getText().toString());
        // Perform the calculation and set the result
        String calculatedResult = calculateQuadraticFormula(a, b, c);
        return calculatedResult;
    }


    private String calculateQuadraticFormula(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        String result ;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            result= " root 1 :"+ root1 ;
            result+="\n root 2 :" + root2 ;
            return result;
        } else if (discriminant == 0) {
            double root = -b / (2 * a);

            result = "root :"+ root ;

            return result;
        } else {
            // Complex roots
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);

            result= "root 1 : "+ realPart + "+ i" + imaginaryPart ;
            result+= "\n root 2 : "+ realPart + "- i" + imaginaryPart ;

            return result;
        }
    }

    // Methode Résourdre d'equation de second ordre


    private void resetFields() {
        nbr1.setText("");
        nbr2.setText("");
        nbr3.setText("");

    }




}