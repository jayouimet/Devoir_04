package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class ParametresCompte extends AppCompatActivity {

    private ImageButton parametersReturnButton;
    private EditText parametersDatePicker;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres_compte);

        parametersDatePicker = findViewById(R.id.parametersDatePicker);
        parametersReturnButton = findViewById(R.id.parametersReturnButton);

        parametersDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        parametersDatePicker.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) return;
                showDatePickerDialog();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                parametersDatePicker.setText(
                                (((day + 1) < 10) ? "0" : "") +
                                day +
                                "-" +
                                (((month + 1) < 10) ? "0" : "") +
                                (month + 1) +
                                "-" +
                                year);
            }
        };

        parametersReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quitterParametresCompte();
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                ParametresCompte.this,
                R.style.DatePickerTheme,
                dateSetListener,
                year, month, day);
        dialog.show();
    }

    //Lorsque l'utilisateur clique sur la flèche, il est ramené vers la page précédente, soit la page «Mon Profil»
    public void quitterParametresCompte(){
        this.finish();
    }
    public void deconnexion(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void changecompte(View v){
        Intent intent = new Intent(this, AjouterCompte.class);
        startActivity(intent);
    }
}