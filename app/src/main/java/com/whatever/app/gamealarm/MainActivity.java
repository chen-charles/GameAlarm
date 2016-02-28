package com.whatever.app.gamealarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    protected boolean isAlarmOn = false;
    protected boolean isTimeHit = false;
    protected int hr = 0, g_min = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcherl);


                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setLargeIcon(largeIcon)
                                .setSmallIcon(R.drawable.ic_launcherl)
                                .setContentTitle("GameAlarm")
                                .setContentText("Tap to turn off the alarm")
                                .setContentIntent(pendingIntent); //Required on Gingerbread and below

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(5, mBuilder.build());
            }
        });*/


        final TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (isAlarmOn){return;}
                else {
                    hr = hourOfDay;g_min = minute;
                    timePicker.setEnabled(false);
                    return;
                }
            }
        });

        Button setButton = (Button) findViewById(R.id.button);
        Button dismissButton = (Button) findViewById(R.id.button2);
        Button cancelButton = (Button) findViewById(R.id.button3);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAlarmOn = true;
                Timer timer = new Timer();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c.getTime());
                Date dateObj= null;
                try{dateObj = df.parse(formattedDate);}catch(Exception e){}
                if (dateObj == null) return;
                dateObj.setHours(hr);
                dateObj.setMinutes(g_min);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (isAlarmOn)
                        {
                            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            v.vibrate(10000);
                            isTimeHit = true;
                        }
                        isAlarmOn = false;
                    }
                }, dateObj);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcherl);


                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setLargeIcon(largeIcon)
                                .setSmallIcon(R.drawable.ic_launcherl)
                                .setContentTitle("GameAlarm")
                                .setContentText("Tap to turn off the alarm")
                                .setContentIntent(pendingIntent); //Required on Gingerbread and below

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(5, mBuilder.build());
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAlarmOn = false;
                recreate();
            }
        });
        dismissButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (isTimeHit)
                {
                    Intent game = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(game);
                    isTimeHit = false;
                    recreate();
                }
            }
        });
    }
}
