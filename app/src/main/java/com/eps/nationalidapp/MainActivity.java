package com.eps.nationalidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText reserveInput;
    private TextInputLayout reserveInputLayout;
    private LinearLayout loadingLoginContainer;

    private Button loginBtn;
    public static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        reserveInput = findViewById(R.id.input_reserve);
        reserveInputLayout = findViewById(R.id.layout_input_reserve);
        loadingLoginContainer = findViewById(R.id.loading_login_container);

        loginBtn = findViewById(R.id.btn_login);

    }
}
