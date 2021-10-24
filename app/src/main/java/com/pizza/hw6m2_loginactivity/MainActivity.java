package com.pizza.hw6m2_loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout1, linearLayout2;
    private Button loginButton;
    private EditText emailEditText, passwordEditText;
    private TextView loginHintText, forgetPasswordText, urlText, loginTextview;

    private boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1 = findViewById(R.id.linear_layout1);
        linearLayout2 = findViewById(R.id.linear_layout2);
        loginButton = findViewById(R.id.login_button);
        emailEditText = findViewById(R.id.email_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        loginHintText = findViewById(R.id.login_hint_text);
        forgetPasswordText = findViewById(R.id.forget_password_textview);
        urlText = findViewById(R.id.click_here_textview);
        loginTextview = findViewById(R.id.login_textview);

        emailEditText.addTextChangedListener(loginTextWatcher);
        passwordEditText.addTextChangedListener(loginTextWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailEditText.getText().toString().equals("admin@gmail.com") && passwordEditText.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    linearLayout1.animate().alpha(0F);
                    linearLayout2.animate().alpha(0F);
                    loginHintText.animate().alpha(0F);
                    loginTextview.animate().alpha(0F);
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailInput = emailEditText.getText().toString().trim();
            String passwordInput = passwordEditText.getText().toString().trim();

//            loginButton.setEnabled(!emailInput.isEmpty() && !passwordInput.isEmpty());

            if (!emailInput.isEmpty() && !passwordInput.isEmpty()) {
                loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_edittext_texture_orange));
            } else {
                loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_edittext_texture_gray));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
