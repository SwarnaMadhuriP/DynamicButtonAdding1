package com.example.dynamicbuttonadding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
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
      //  Cursor c =db.rawQuery("select count(*) from CaseRegistration",null);
        //int test = c.getCount();
       // long test = DatabaseUtils.queryNumEntries(db, "table_name");
        for(int i=1;i<=5;i++){
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
                }
            });
            layout.addView(button);
        }
    }
}
