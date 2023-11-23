package com.example.prepads1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText tailleInput;
    private RadioGroup genreRadioGroup;
    private Button calculerButton;
    private Button effacerButton;
    private TextView resultatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tailleInput = findViewById(R.id.nbr1);
        genreRadioGroup = findViewById(R.id.gender);
        calculerButton = findViewById(R.id.compute);
        effacerButton = findViewById(R.id.cancel);
        resultatText = findViewById(R.id.result);

        calculerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerPoidsIdeal();
            }
        });

        effacerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                effacerInput();
            }
        });

        genreRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == -1) {
                    Toast.makeText(MainActivity.this, "Aucun bouton sélectionné", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedRadioButton = findViewById(checkedId);
                    Toast.makeText(MainActivity.this, selectedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void calculerPoidsIdeal() {
        String tailleStr = tailleInput.getText().toString();
        if (tailleStr.isEmpty()) {
            Toast.makeText(this, "Veuillez saisir une taille", Toast.LENGTH_SHORT).show();
            return;
        }

        double taille = Double.parseDouble(tailleStr);
        double poidsIdeal;

        int selectedGenreId = genreRadioGroup.getCheckedRadioButtonId();
        if (selectedGenreId == -1) {
            Toast.makeText(this, "Veuillez sélectionner un genre", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton genreRadioButton = findViewById(selectedGenreId);
        String genre = genreRadioButton.getText().toString();

        if (genre.equals("Homme")) {
            poidsIdeal = taille - 100 - ((taille - 150) / 4);
        } else {
            poidsIdeal = taille - 100 - ((taille - 150) / 2.5);
        }

        resultatText.setText(" " + poidsIdeal);
    }

    private void effacerInput() {
        tailleInput.setText("");
        resultatText.setText("");
        genreRadioGroup.clearCheck();
    }
}
