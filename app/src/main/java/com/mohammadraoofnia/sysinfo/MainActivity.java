package com.mohammadraoofnia.sysinfo;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // initiating necessary objects
        ////battery
        IntentFilter ifilterBattery = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = getApplicationContext().registerReceiver(new PowerConnectionReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {

                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                        status == BatteryManager.BATTERY_STATUS_FULL;

                int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
                boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
                String BatteryStat = "Disconnected";
                if(isCharging){
                    BatteryStat = "Charging via ";
                    if(usbCharge)
                        BatteryStat += "USB";
                    else if(acCharge)
                        BatteryStat += "AC adapter";
                }
                ((TextView)findViewById(R.id.BatteryStatus)).setText(BatteryStat);
            }
        },ifilterBattery);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting phone general information
        ((TextView)findViewById(R.id.Serial)).setText(Build.SERIAL);
        ((TextView)findViewById(R.id.Model)).setText(Build.SERIAL);
        ((TextView)findViewById(R.id.ID)).setText(Build.ID);
        ((TextView)findViewById(R.id.Manufacturer)).setText(Build.MANUFACTURER);
        ((TextView)findViewById(R.id.Brand)).setText(Build.BRAND);
        ((TextView)findViewById(R.id.Type)).setText(Build.TYPE);
        ((TextView)findViewById(R.id.User)).setText(Build.USER);
        ((TextView)findViewById(R.id.VersionI)).setText(Build.VERSION.INCREMENTAL);
        ((TextView)findViewById(R.id.SDK)).setText(Build.VERSION.SDK);
        ((TextView)findViewById(R.id.Board)).setText(Build.BOARD);
        ((TextView)findViewById(R.id.Host)).setText(Build.HOST);
        ((TextView)findViewById(R.id.FingerPrint)).setText(Build.FINGERPRINT);
        ((TextView)findViewById(R.id.VersionC)).setText(Build.VERSION.RELEASE);
        ////getting battery information
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;
        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
        String BatteryStat = "Disconnected";
        if(isCharging){
            BatteryStat = "Charging via ";
            if(usbCharge)
                BatteryStat += "USB";
            else if(acCharge)
                BatteryStat += "AC adapter";
        }
        ((TextView)findViewById(R.id.BatteryStatus)).setText(BatteryStat);
        //////battery level
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float)scale;
        ((TextView)findViewById(R.id.BatteryLevel)).setText("%" + String.format("%2.0f" ,batteryPct*100));
    }

}
