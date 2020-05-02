package com.example.dynamicbuttonadding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("ComplaintRegistrationDB", Context.MODE_PRIVATE, null);
        layout=findViewById(R.id.linearlayoutid);
       // db.execSQL("CREATE TABLE IF NOT EXISTS  CaseRegistration(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,caseId VARCHAR,Status VARCHAR,Type1 VARCHAR,VName VARCHAR,CName VARCHAR,Complaintname VARCHAR,Mobile VARCHAR,Place VARCHAR,Date1 VARCHAR,Time1 VARCHAR,assigned INT);");
        db.execSQL("INSERT INTO CaseRegistration (Status,Type1,VName,CName,Complaintname,Mobile,Place,Date1,Time1,assigned) VALUES('" +"recorded"+"','" +"robbery"+"','"+"mukesh"+"','"+"swarna"+"','"+"car robbed"+"','"+"8105504284"+"','"+"delhi"+"','"+"1/05/2020"+"','"+"14" + "',0);");
        Cursor c =db.rawQuery("select count(*) from CaseRegistration",null);
        int test = c.getCount();
        int count = 0;
        if(null != c){
            if(c.getCount() > 0){
                c.moveToFirst();
                count = c.getInt(0);
            }
        }
       //long test = DatabaseUtils.queryNumEntries(db, "table_name");
        for(int i=1;i<=count;i++){
            final Button button=new Button(this);
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            button.setId(i);
            button.setGravity(Gravity.CENTER);
            button.setText("Case No "+i+" Details");
            final int finalI=i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"case no pressed is "+finalI,Toast.LENGTH_SHORT).show();
                    Intent gotocase=new Intent(MainActivity.this,Case1Details.class);
                    startActivity(gotocase);

                }
            });
            layout.addView(button);
        }
    }
}
