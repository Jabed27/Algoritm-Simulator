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

public class BubbleSortActivity extends AppCompatActivity {
    private Button button;
    private TextView passshowing;
    private EditText input;
    DatabaseHelper mydb;
    private String bubble;
    private String s;
    public Button viewbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort);
        mydb = new DatabaseHelper(this);
        Intent intent = getIntent();
        bubble = intent.getStringExtra("Extra_message");
        passshowing = (TextView) findViewById(R.id.textView2);
        viewbutton = (Button) findViewById(R.id.viewbutton);
       String [] intString=  bubble.split(" ");


        int bubbleArr[]=new int[intString.length];
        for(int i=0;i<bubbleArr.length;i++) {
            bubbleArr[i]=Integer.parseInt(intString[i]);
        }
        int n = bubbleArr.length;
        String []strArr=new String[bubbleArr.length];
       // String []s = new String[bubbleArr.length];
        passshowing.setText("  Passes in ascending order" + "\n");
        for (int i = 0; i < n-1; i++) {
            boolean swap=false;
            for (int j = 0; j < n-i-1; j++) {
                if (bubbleArr[j] > bubbleArr[j+1])
                {

                    int temp = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j+1];
                    bubbleArr[j+1] = temp;
                    swap=true;
                }

            }
            if(swap==false)
                break;



            passshowing.append("  Pass "+(i+1)+": ");
            for (int k=0; k<n; k++) {
                strArr[k]=String.valueOf(bubbleArr[k]);

                passshowing.append(strArr[k]+" ");

            }
            passshowing.append("\n");



   }
           /*
            for(int k =0;k<n;k++){

                 t2.append(s[k]+" ");
            }*/
         s = (passshowing.getText().toString());


}
        public void onclickButton(View V){
            Intent intent = new Intent(this,Activity2.class);
            startActivity(intent);

        }
        public void Addthis(View v){
           boolean isInserted = mydb.insertdata("Bubble Sort",bubble,s);
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
