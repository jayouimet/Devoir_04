package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class CreationCompte extends AppCompatActivity {

    private ImageButton createAccountReturnButton;
    private EditText editTextDate;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        createAccountReturnButton = findViewById(R.id.createAccountReturnButton);
        editTextDate = findViewById(R.id.editTextDate);
        // Lorsque l'utilisateur clique sur le bouton « Créer le comte », il est amené vers la page « choisirHumeur »
        final Button button = findViewById(R.id.btCreerCompte);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CreationCompte.this, choisirHumeur.class);
                startActivity(intent);
            }
        });

        createAccountReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retourConnexionCreation();
            }
        });

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        editTextDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) return;
                showDatePickerDialog();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                editTextDate.setText(
                                (((day + 1) < 10) ? "0" : "") +
                                day +
                                "-" +
                                (((month + 1) < 10) ? "0" : "") +
                                (month + 1) +
                                "-" +
                                year);
            }
        };
    }

    private void showDatePickerDialog() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                CreationCompte.this,
                R.style.DatePickerTheme,
                dateSetListener,
                year, month, day);
        dialog.show();
    }

    public void retourConnexionCreation(){
        this.finish();
    }
}