package com.mohammadraoofnia.sysinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String inf= new String();
        TextView TV = findViewById(R.id.TV);
        inf=refresh();
        TV.setText(inf);
    }

    public String refresh(){
        String result = "";
        result = "Serial:" + " " +Build.SERIAL + "\n" +
                "Model:" + " " + Build.MODEL + "\n" +
                "ID:" + " " + Build.ID + "\n" +
                "Manufacturer:" + " " + Build.MANUFACTURER + "\n" +
                "Brand:" + " " + Build.BRAND + "\n" +
                "Type:" + " " + Build.TYPE + "\n" +
                "User:" + " " + Build.USER + "\n" +
                "Version Base:" + " " + Build.VERSION_CODES.BASE + "\n" +
                "Version Incremental:" + " " + Build.VERSION.INCREMENTAL + "\n" +
                "SDK:" + " " + Build.VERSION.SDK + "\n" +
                "Board:" + " " + Build.BOARD + "\n" +
                "Host:" + " " + Build.HOST + "\n" +
                "FingerPrint" + " " + Build.FINGERPRINT + "\n" +
                "Version Code:" + " " + Build.VERSION.RELEASE;
        result += "";
        return result;
    }
}
