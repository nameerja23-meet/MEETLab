package com.example.meetlab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.meetlab.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView signInText;
    private EditText email;
    private EditText password;
    private Button signInButton;
    private Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInText = findViewById(R.id.signInText);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);
        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    CharSequence text = "Signup is under construction!";
    int duration = Toast.LENGTH_SHORT;
    @Override
    public void onClick(View view) {
        if(view == signInButton) {
            email.setText(email.getText().toString());
            password.setText(email.getText().toString());
            Intent homeActivityIntent = new Intent(this,HomeActivity.class);
            startActivity(homeActivityIntent);
        }else if (view == signUpButton) {
            Toast.makeText(MainActivity.this, text, duration).show();
            Intent signUpIntent = new Intent(this,SignUp.class);
            startActivity(signUpIntent);
        }



    }
}