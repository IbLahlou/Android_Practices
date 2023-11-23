package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText heightEditText;
    private EditText weightEditText;
    private RadioGroup genderRadioGroup;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.nbr1);
        weightEditText = findViewById(R.id.nbr2);
        genderRadioGroup = findViewById(R.id.gender);
        resultTextView = findViewById(R.id.result);

        Button calculateButton = findViewById(R.id.compute);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                if (checkedId == -1) {
                    Toast.makeText(MainActivity.this, "No button selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, selectedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button eraseButton = findViewById(R.id.cancel);
        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }


    private void calculateBMI() {
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr) / 100; // Convert height to meters
            float weight = Float.parseFloat(weightStr);

            float bmi = weight / (height * height);

            String result;
            int selectedId = genderRadioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);
            if (selectedId == -1) {
                result = "Please select gender";
            } else {
                String gender = selectedRadioButton.getText().toString();
                boolean isMale = gender.equals("Male");
                result = "Your BMI: " + bmi + "\n" + selectedRadioButton.getText() + " selected\n" + getBMICategory(bmi, isMale);
            }

            resultTextView.setText(result);
        } else {
            resultTextView.setText("Please enter both height and weight");
        }
    }


    private String getBMICategory(float bmi, boolean isMale) {
        String category = "Category: ";
        if (bmi < 18.5) {
            category += "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            category += "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            category += "Overweight";
        } else if (bmi >= 30 && bmi < 35) {
            category += "Obesity class I";
        } else if (bmi >= 35 && bmi < 40) {
            category += "Obesity class II";
        } else {
            category += "Obesity class III";
        }

        return category;
    }


    private void resetFields() {
        heightEditText.setText("");
        weightEditText.setText("");
        resultTextView.setText("");
        genderRadioGroup.clearCheck();
    }



}
