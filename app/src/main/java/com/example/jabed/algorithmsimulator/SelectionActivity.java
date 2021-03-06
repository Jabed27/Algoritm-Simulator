package com.example.jabed.algorithmsimulator;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SelectionActivity extends AppCompatActivity {
    private Button button;
    private TextView passshowing;
    private EditText input;
    DatabaseHelper mydb;
    private  String selection;
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        mydb = new DatabaseHelper(this);
        Intent intent = getIntent();
        passshowing =(TextView)findViewById(R.id.textView2);
         selection = intent.getStringExtra("Extra_message");
        String intString2[]=selection.split(" ");
        int selectionArr[]=new int[intString2.length];
        for(int i=0;i<selectionArr.length;i++) {
            selectionArr[i]=Integer.parseInt(intString2[i]);
        }
        int n = selectionArr.length;
        passshowing.append("  Passes in ascending order" +"\n");
        for (int i = 0; i < n-1; i++)
        {

            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (selectionArr[j] < selectionArr[min_idx])
                    min_idx = j;

                int temp = selectionArr[min_idx];
                selectionArr[min_idx] = selectionArr[i];
                selectionArr[i] = temp;
            }

            String strArr7[]=new String[selectionArr.length];
            passshowing.append("  Pass "+(i+1)+": ");
            for (int k=0; k<n; k++) {
                strArr7[k]=String.valueOf(selectionArr[k]);
                passshowing.append(strArr7[k]+" ");


            }

            passshowing.append("\n");

        }
        s = (passshowing.getText().toString());
    }
    public void onclickButton(View V){
        Intent intent  = new Intent(this,Activity2.class);
        startActivity(intent);
    }
    public void Addthis(View v){
        boolean isInserted = mydb.insertdata("Selection Sort",selection,s);
        if(isInserted == true){
            Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"data not inserted",Toast.LENGTH_SHORT).show();
        }
    }
    public void ViewAll(View v){
        Cursor res = mydb.getAlldata();
        if(res.getCount() == 0){
            showMessege("Error","Nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID : "+res.getString(0)+"\n");
            buffer.append("Name : "+res.getString(1)+"\n");
            buffer.append("Input : "+res.getString(2)+"\n");
            buffer.append("Output : "+res.getString(3)+"\n\n");

        }
        //show all data
        showMessege("DATA",buffer.toString());

    }
    public void showMessege(String title,String  messege){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(messege);
        builder.show();
    }
}
