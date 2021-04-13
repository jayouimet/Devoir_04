package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ChangePasswordActivity extends AppCompatActivity {
    // Variables de référence à l'UI
    private TextInputEditText changePasswordTextBox;
    private TextInputEditText confirmChangePasswordTextBox;
    private Button changePasswordButton;
    private TextView changePasswordErrorLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        // On créé les références
        this.changePasswordTextBox = findViewById(R.id.changePasswordTextBox);
        this.confirmChangePasswordTextBox = findViewById(R.id.confirmChangePasswordTextBox);
        this.changePasswordButton = findViewById(R.id.changePasswordButton);
        this.changePasswordErrorLabel = findViewById(R.id.changePasswordErrorLabel);
        this.changePasswordErrorLabel.setVisibility(View.GONE);
        // Création de la logique du button
        this.changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changePasswordTextBox.getText().toString().equals(confirmChangePasswordTextBox.getText().toString())) {
                    Intent nextActivity = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                    startActivity(nextActivity);
                } else {
                    changePasswordErrorLabel.setText(getResources().getString(R.string.change_password_error_message_label));
                    changePasswordErrorLabel.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}