package com.example.logindemoapplication;
/**
 * @Author-Swati.Khobragade
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvUsername;
    private TextView tvPassword;
    private TextView editTextForgotPwd;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        registerListeners();
        editTextForgotPwd.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * Initialize views
     */
    private void initViews() {
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        editTextForgotPwd = (TextView) findViewById(R.id.tvForgotPassword);
        editTextUsername = (EditText) findViewById(R.id.editTxtUsername);
        editTextPassword = (EditText) findViewById(R.id.editTxtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        btnLogin.setOnClickListener(this);
    }

    /**
     * Method to Login
     */
    private void login() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if (validateFields(username, password)) {
            Toast.makeText(this, "Login Successfully !!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method to validate empty fields
     * @param username
     * @param password
     * @return
     */
    private boolean validateFields(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(getApplicationContext(), "Please enter Username", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;
        }
    }

}
