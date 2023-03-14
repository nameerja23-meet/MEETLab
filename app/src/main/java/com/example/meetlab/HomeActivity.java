package com.example.meetlab;

import static com.example.meetlab.R.id.usersListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    private ListView usersListView;
    private ArrayList<User> users;
    private ArrayAdapter<User> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usersListView = findViewById(R.id.usersListView);
        users = new ArrayList<>();
        users.add(new User("Nameer","nemojabara@gmail.com","1234"));
        users.add(new User("Liam", "lulu@gmail.com","1234"));
        arrayAdapter = new UserArrayAdapter(this,R.layout.user_row,users);
        usersListView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.signOutBtn){
            Intent mainActivityIntent = new Intent(this,MainActivity.class);
            startActivity(mainActivityIntent);
        }
        return true;
    }
}