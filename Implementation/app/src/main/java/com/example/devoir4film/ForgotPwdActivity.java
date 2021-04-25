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
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ForgotPwdActivity extends AppCompatActivity {

    private ImageButton forgotPasswordReturnButton;
    private TextView forgotPasswordMessageSentLabel;
    private TextView forgotEmailLabel;
    private Button forgotPasswordReinitialiseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);
        // Référence des input au UI
        this.forgotPasswordReinitialiseButton = findViewById(R.id.forgotPasswordReinitialiseButton);
        this.forgotEmailLabel = findViewById(R.id.forgotEmailLabel);
        this.forgotPasswordMessageSentLabel = findViewById(R.id.forgotPasswordMessageSentLabel);
        this.forgotPasswordReturnButton = findViewById(R.id.forgotPasswordReturnButton);
        // On lie le texte forgot email à son activité
        this.setForgotEmailClickable();
        this.setReinitialiseLinkClickable();
        this.forgotPasswordMessageSentLabel.setVisibility(View.GONE);
        // On lie le bouton au message d'envoi de courriel
        this.forgotPasswordReinitialiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPasswordMessageSentLabel.setText(getResources().getString(R.string.forgot_password_message_sent_label));
                setReinitialiseLinkClickable();
                forgotPasswordMessageSentLabel.setVisibility(View.VISIBLE);
            }
        });

        this.forgotPasswordReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeActivity();
            }
        });
    }

    /**
     * Fermeture de l'activité ForgotPassword
     */
    private void closeActivity() {
        this.finish();
    }

    /**
     * Liaison du texte email oublié à sa logique
     * */
    private void setForgotEmailClickable()
    {
        SpannableString spannableString = new SpannableString(this.forgotEmailLabel.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Fonctionnalitée non implémentée, serait un lien vers le site du support
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
        this.forgotEmailLabel.setText(spannableString);
        this.forgotEmailLabel.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * Liaison du lien réinitialisation du mot de passe à sa logique
     * */
    private void setReinitialiseLinkClickable()
    {
        SpannableString spannableString = new SpannableString(this.forgotPasswordMessageSentLabel.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            // Lier ChangePasswordActivity au span
            public void onClick(View view) {
                Intent nextActivity = new Intent(ForgotPwdActivity.this, ChangePasswordActivity.class);
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
        spannableString.setSpan(clickableSpan, 100, 103, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 100, 103, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        this.forgotPasswordMessageSentLabel.setText(spannableString);
        this.forgotPasswordMessageSentLabel.setMovementMethod(LinkMovementMethod.getInstance());
    }
}