package com.whatever.app.gamealarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setbutton = (Button) findViewById(R.id.button);
        Button dismissbutton = (Button) findViewById(R.id.button2);
        Button cancelbutton = (Button) findViewById(R.id.button3);


        Intent intt = new Intent(this, GameActivity.class );
        startActivity(intt);
    }
}
