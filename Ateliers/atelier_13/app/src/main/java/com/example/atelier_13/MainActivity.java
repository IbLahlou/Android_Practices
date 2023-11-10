package com.example.atelier_13;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView ACV;
    MultiAutoCompleteTextView MACV;
    String[] ville = {"Errachidia", "Casablanca", "Rabat", "Tanger",
            "Salé", "Safi", "Marrakech", "Eljadida", "Fes", "Meknes", "Tetouan",
            "Oujda", "Essaouira"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ACV = findViewById(R.id.AutoC);
        MACV = findViewById(R.id.MAutoC);
//Création de l'instance de ArrayAdapter contenant la liste des ville
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, ville);
        ACV.setThreshold(2);//Sera fonctionné à partir du deuxième caractère
        ACV.setAdapter(adapter);//Définir les données de l'adaptateur dans AutoCompleteTextView
        //MultiAutoCompleteTextView
        MACV.setThreshold(2);//Sera fonctionné à partir du deuxième caractère
        MACV.setAdapter(adapter);//Définir les données de l'adaptateur dans AutoCompleteTextView
        MACV.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}