package com.example.ext01d1840.bardak;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("SuHesaplama",MODE_PRIVATE,null);

        String createQuery = "Create table if not exists Water (_id integer primary key autoincrement, watername text,waterdate text) ";
        db.execSQL(createQuery);

    }

    public void addWater(String watertype){

        db = openOrCreateDatabase("SuHesaplama",MODE_PRIVATE,null);

        Calendar c  = Calendar.getInstance();
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String waterdate = myDateFormat.format(c.getTime());

        String insertQuery = "insert into Water(watername,waterdate) values ('"+watertype+"','"+waterdate+"')";
        db.execSQL(insertQuery);
    }


    public  void BardakOnclick(View view)
    {
        String txtBardak = "1 bardak su icildi";
        addWater(txtBardak);
        Toast.makeText(this,"1 bardak su icildi",Toast.LENGTH_SHORT).show();
    }

    public  void SiseOnclick(View view)
    {
        String txtSise = "1 sise su icildi";
        addWater(txtSise);
        Toast.makeText(this,"1 sise su icildi",Toast.LENGTH_SHORT).show();
    }

    public void ArsivOnClick(View view){

        Intent ArsicAc = new Intent(this,Arsiv.class);
        startActivity(ArsicAc);
    }
}
