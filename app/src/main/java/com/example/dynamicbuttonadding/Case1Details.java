package com.example.dynamicbuttonadding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Case1Details extends AppCompatActivity {
 SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1_details);
        db = openOrCreateDatabase("ComplaintRegistrationDB", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT  *  FROM CaseRegistration WHERE Mobile='" +"8105504284"+ "'", null);
        if(c.getCount()==0)
        {
            showMessage("Error", "No records found");
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("ComplaintId: "+c.getString(0)+"\n");
            buffer.append("Assigned: "+c.getString(1)+"\n\n");
        }
        showMessage("Complaint Details are :", buffer.toString());
        //clearText();
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
   /* public void clearText()
    {
        complaintname.setText("");
        convictname.setText("");
        victimname.setText("");
        mobileno.setText("");
        place.setText("");
        date.setText("");
        time.setText("");
        complaintname.requestFocus();
    }*/
}
