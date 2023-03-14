package com.example.meetlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private TextView signUpTxt;
    private EditText name;
    private EditText email;
    private EditText password;
    private Button submit;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

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
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public void onClick(View view) {
        if(view==submit){
            createUser(email.getText().toString(), password.getText().toString());
        }
    }

    public void createUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        User user = new User(name.getText().toString(), email, password);
                        String uid = mAuth.getCurrentUser().getUid().toString();
                        database.getReference("Users").child(uid).setValue(user);


                        Intent i = new Intent(SignUp.this, HomeActivity.class);
                        startActivity(i);
                    } else {
                        // If sign in fails, display a message to the user
                        Toast.makeText(SignUp.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();

                    }
                }
            });
    }
}