package com.example.lekshmi.dbase;


import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.*;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt;
    Cursor cr;
    SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            mydatabase = openOrCreateDatabase("sample_db", MODE_PRIVATE, null);

            mydatabase.execSQL("CREATE TABLE First_tb(Username VARCHAR,Password VARCHAR);");
            mydatabase.execSQL("INSERT INTO First_tb VALUES('Rajalekshmi','Lekshmi');");
            cr = mydatabase.rawQuery("select Username from First_tb", null);


        }
        catch (Exception e){

            Toast.makeText(this, "errorrr", Toast.LENGTH_SHORT).show();
        }
        bt=(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str=cr.toString();
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();

            }
        });
    }
}
