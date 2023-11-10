package com.example.atelier_9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton1, toggleButton2;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton1 = findViewById(R.id.toggleButton);
        toggleButton2 = findViewById(R.id.toggleButton2);
        buttonSubmit = findViewById(R.id.button);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder message = new StringBuilder();
                message.append("Toggle 1 is ").append(toggleButton1.isChecked() ? "ON" : "OFF").append("\n");
                message.append("Toggle 2 is ").append(toggleButton2.isChecked() ? "ON" : "OFF");
                showAlert("Toggle States", message.toString());
            }
        });

        toggleButton1.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showAlert("Toggle 1 State Changed", isChecked ? "Toggle 1 is ON" : "Toggle 1 is OFF");
            }
        });

        toggleButton2.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showAlert("Toggle 2 State Changed", isChecked ? "Toggle 2 is ON" : "Toggle 2 is OFF");
            }
        });
    }

    private void showAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}
