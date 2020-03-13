package com.example.jabed.algorithmsimulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     private Button button;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);
    }
    public void onButtonClick(View V){

        button = (Button)findViewById(R.id.button1);
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
}
