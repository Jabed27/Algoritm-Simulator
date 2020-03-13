package com.example.jabed.algorithmsimulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
     private Button button,quicksort ;
     private TextView passshowing;
     private EditText input;
     DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mydb = new DatabaseHelper(this);              ///now it is calling the database which is creationg the database
        passshowing =(TextView) findViewById(R.id.textView2);
    }
    public void onclickButton(View V){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void onclickButton2(View V){

              EditText input = (EditText) findViewById(R.id.editText2);
        passshowing =(TextView) findViewById(R.id.textView2);
              button = (Button) findViewById(R.id.button1);
              //quicksort = (Button) findViewById(R.id.button2);
             /* if (V.getId() == R.id.button2) {
                  Intent intent1 = new Intent(Activity2.this, QuicksortActivity.class);
                  startActivity(intent1);
                  Toast.makeText(Activity2.this, "You have selected Quick Sort ", Toast.LENGTH_SHORT).show();
              }*/
              if (V.getId() == R.id.button3) {
                  try{
                      input = (EditText) findViewById(R.id.editText2);
                      passshowing =(TextView) findViewById(R.id.textView2);
                      String text = input.getText().toString();

                      if(text.isEmpty()) {
                          CustomException.exceptionhandling(1);
                      }

                     try {
                         String intString1[] = text.split(" ");
                         int insertionArr[] = new int[intString1.length];
                         for (int i = 0; i < insertionArr.length; i++) {
                             insertionArr[i] = Integer.parseInt(intString1[i]);
                         }

                         Intent intent = new Intent(this, BubbleSortActivity.class);
                         intent.putExtra("Extra_message", text);
                         startActivity(intent);
                         Toast.makeText(Activity2.this, "You have selected Bubble Sort ", Toast.LENGTH_SHORT).show();
                         // input ase
                     }catch (Exception e){
                          Toast.makeText(this,"invalid input",Toast.LENGTH_SHORT).show();
                          return;
                     }
                  }catch(ArithmeticException e){

                          Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

                  }

              }
              /*if (V.getId() == R.id.button4) {
                  Intent intent = new Intent(this, MargeSortActivity.class);
                  startActivity(intent);
                  Toast.makeText(Activity2.this, "You have selected Marge Sort ", Toast.LENGTH_SHORT).show();
              }*/
              if(V.getId()==R.id.button5){
                  try{
                      input = (EditText) findViewById(R.id.editText2);
                      passshowing =(TextView) findViewById(R.id.textView2);
                      String text = input.getText().toString();
                      if(text.isEmpty())
                      {
                          CustomException.exceptionhandling(1);
                      }
                      try {
                          String intString1[] = text.split(" ");
                          int insertionArr[] = new int[intString1.length];
                          for (int i = 0; i < insertionArr.length; i++) {
                              insertionArr[i] = Integer.parseInt(intString1[i]);
                          }

                          Intent intent = new Intent(this, InsertionActivity.class);
                          intent.putExtra("Extra_message", text);
                          startActivity(intent);
                          Toast.makeText(Activity2.this, "You have selected Insertion Sort ", Toast.LENGTH_SHORT).show();
                      }catch (Exception e){
                          Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT).show();
                      }
                      }catch(ArithmeticException e){
                      Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                  }


              }
              if(V.getId()==R.id.button6){
                  try{
                      input = (EditText) findViewById(R.id.editText2);
                      passshowing =(TextView) findViewById(R.id.textView2);
                      String text = input.getText().toString();
                      if(text.isEmpty()){
                          CustomException.exceptionhandling(1);
                      }
                      try {
                          String intString1[] = text.split(" ");
                          int insertionArr[] = new int[intString1.length];
                          for (int i = 0; i < insertionArr.length; i++) {
                              insertionArr[i] = Integer.parseInt(intString1[i]);
                          }

                          Intent intent = new Intent(this, SelectionActivity.class);
                          intent.putExtra("Extra_message", text);
                          startActivity(intent);
                          Toast.makeText(Activity2.this, "You have selected Selection Sort ", Toast.LENGTH_SHORT).show();
                      }catch(Exception e){
                          Toast.makeText(this,"Please take integer as input",Toast.LENGTH_SHORT).show();
                      }
                  }catch(ArithmeticException e){
                      Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                  }

              }



    }
}
