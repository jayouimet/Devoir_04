package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class filmDescription extends AppCompatActivity {
    TextView description;
    Film actuel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_description);
        description=findViewById(R.id.descriptionfilm);
        actuel=BD.tabfilm.get(0);
        description.setText(actuel.getDescription());
    }
}