package com.whatever.app.gamealarm;

<<<<<<< HEAD
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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


                //NotificationCompat.Builder notification = new NotificationCompat.Builder(R.drawable.ic_launcherl,
                //        "GameAlarm", pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(5, mBuilder.build());
            }
        });
        Button setButton = (Button) findViewById(R.id.button);
        Button dismissButton = (Button) findViewById(R.id.button2);
        Button cancelButton = (Button) findViewById(R.id.button3);


        Intent game = new Intent(this, GameActivity.class );
        startActivity(game);
    }
}
