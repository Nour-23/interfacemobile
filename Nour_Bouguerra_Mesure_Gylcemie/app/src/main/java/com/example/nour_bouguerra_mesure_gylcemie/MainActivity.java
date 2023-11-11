package com.example.nour_bouguerra_mesure_gylcemie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // UI components
    private EditText etValeur;
    private TextView tvAge;
    private SeekBar sbAge;
    private RadioButton rbIsFasting, rbIsNotFasting;
    private Button btnConsulter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        init();

        // SeekBar listener to update age TextView
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged " + progress);
                tvAge.setText("Votre âge : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Button click listener
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer(v);
            }
        });
    }

    // Method to perform calculation
    public void calculer(View view) {
        Log.i("Information", "button cliqué");

        // Variables for age and measured value
        int age;
        float valeurMesuree;

        // Flags for validation
        boolean verifAge = false, verifValeur = false;

        // Check if age is provided
        if (sbAge.getProgress() != 0)
            verifAge = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre age !", Toast.LENGTH_SHORT).show();

        // Check if measured value is provided
        if (!etValeur.getText().toString().isEmpty())
            verifValeur = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !", Toast.LENGTH_LONG).show();

        // If both age and measured value are provided
        if (verifAge && verifValeur) {
            age = sbAge.getProgress();
            valeurMesuree = Float.valueOf(etValeur.getText().toString());

            // Check fasting status
            boolean isFasting = rbIsFasting.isChecked();

            // Perform glycemia level calculation
            if (isFasting) {
                // Logic based on age ranges
                // Update tvReponse with the result
            } else {
                // Logic for non-fasting condition
                // Update tvReponse with the result
            }
        }
    }

    // Method to initialize UI components
    private void init() {
        sbAge = findViewById(R.id.sbAge);
        tvAge = findViewById(R.id.agee);
        etValeur = findViewById(R.id.etGlycemiaValue);
        rbIsFasting = findViewById(R.id.rbtOui);
        rbIsNotFasting = findViewById(R.id.rbtNon);
        btnConsulter = findViewById(R.id.btnconsulter);

    }
}
