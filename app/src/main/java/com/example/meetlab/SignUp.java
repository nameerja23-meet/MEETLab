package com.example.meetlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private TextView signUpTxt;
    private EditText name;
    private EditText email;
    private EditText password;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpTxt = findViewById(R.id.signUpTxt);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==submit){
            Intent homeActivityIntent = new Intent(this,HomeActivity.class);
            startActivity(homeActivityIntent);
        }
    }
}