package com.example.meetlab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.meetlab.databinding.ActivityMainBinding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInText = findViewById(R.id.signInText);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);
        mAuth=FirebaseAuth.getInstance();
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
    public void signinUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}