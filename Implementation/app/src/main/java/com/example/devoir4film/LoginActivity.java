package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private TextInputEditText emailTextBox;
    private TextInputEditText passwordTextBox;
    private TextView connectionErrorLabel;

    private TextView forgotPasswordLabel;
    private TextView createNewAccountLabel;
    private TextView loginAsGuestLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // On réfère l'UI au fichier logique
        this.loginButton = findViewById(R.id.changePasswordButton);
        this.emailTextBox = findViewById(R.id.emailTextBox);
        this.passwordTextBox = findViewById(R.id.changePasswordTextBox);
        this.connectionErrorLabel = findViewById(R.id.connectionErrorLabel);
        this.connectionErrorLabel.setVisibility(View.GONE);
        this.forgotPasswordLabel = findViewById(R.id.forgotPasswordLabel);
        this.createNewAccountLabel = findViewById(R.id.createNewAccountLabel);
        this.loginAsGuestLabel = findViewById(R.id.loginAsGuestLabel);
        // On lie le texte forgot password à son activité
        this.setForgotPasswordLinkClickable(this);
        this.setCreateAccountLinkClickable(this);
        this.setLoginAsGuestLinkClickable(this);
        // On lie le bouton de connexion à son action
        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Si l'authentification est vraie, on passe à la prochaine vue, le cas échéant on affiche un message d'erreur
                if (auth()) {
                    Intent nextActivity = new Intent(LoginActivity.this, choisirHumeur.class);
                    startActivity(nextActivity);
                }
                else {
                    connectionErrorLabel.setText(getResources().getString(R.string.wrong_email_password_combinaison_label));
                    connectionErrorLabel.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    /**
     * Logique d'authentification fake
     * */
    private boolean auth()
    {
        if ((this.emailTextBox.getText().toString().equals("Test") && this.passwordTextBox.getText().toString().equals("1234"))
        || (this.emailTextBox.getText().toString().equals("") && this.passwordTextBox.getText().toString().equals(""))) {
            return true;
        }
        return false;
    }

    /**
     * Liaison du texte mot de passe oublié à sa logique
     * */
    private void setForgotPasswordLinkClickable(Context ctx)
    {
        SpannableString spannableString = new SpannableString(this.forgotPasswordLabel.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            // Lier ForgotPwdActivity au span
            public void onClick(View view) {
                Intent nextActivity = new Intent(LoginActivity.this, ForgotPwdActivity.class);
                startActivity(nextActivity);
            }

            // Changement du style du span
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getColor(R.color.main_blue));
            }
        };
        // Assignation de span au TextView
        spannableString.setSpan(clickableSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        this.forgotPasswordLabel.setText(spannableString);
        this.forgotPasswordLabel.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * Liaison du texte création de compte à sa logique
     * */
    private void setCreateAccountLinkClickable(Context ctx)
    {
        SpannableString spannableString = new SpannableString(this.createNewAccountLabel.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            // Lier NewAccountActivity au span
            public void onClick(View view) {
                /*Intent nextActivity = new Intent(LoginActivity.this, NewAccountActivity.class);
                startActivity(nextActivity);*/
            }

            // Changement du style du span
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getColor(R.color.main_blue));
            }
        };
        // Assignation de span au TextView
        spannableString.setSpan(clickableSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        this.createNewAccountLabel.setText(spannableString);
        this.createNewAccountLabel.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * Liaison du texte connexion en temps qu'invité à sa logique
     * */
    private void setLoginAsGuestLinkClickable(Context ctx)
    {
        SpannableString spannableString = new SpannableString(this.loginAsGuestLabel.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            // Lier SuggestionFilm au span
            public void onClick(View view) {
                Intent nextActivity = new Intent(LoginActivity.this, choisirHumeur.class);
                startActivity(nextActivity);
            }

            // Changement du style du span
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getColor(R.color.low_visibility_gray));
            }
        };
        // Assignation de span au TextView
        spannableString.setSpan(clickableSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        this.loginAsGuestLabel.setText(spannableString);
        this.loginAsGuestLabel.setMovementMethod(LinkMovementMethod.getInstance());
    }
}