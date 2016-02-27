package com.whatever.app.gamealarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int val1,val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button ans1 = (Button) findViewById(R.id.ans1);
        Button ans2 = (Button) findViewById(R.id.ans2);

        int dif = new Random().nextInt(5)+1;
        int num1a = new Random().nextInt(50)+1;
        int num2a = new Random().nextInt(50)+1;
        int num1b, num2b;

        val1 = new Random().nextInt(50)+1;

        if (new Random().nextDouble()<0.5){
            val2 = val1+dif;
            num1b = val1-num1a;
            if (num1b<0){
                ans1.setText(""+num1a+" + ("+num1b+")");
            }
            else{
                ans1.setText(""+num1a+" + "+num1b);
            }
        }
        else{
            val2 = val1-dif;
            num1b = num1a - val1;
            if (num1b<0){
                ans1.setText(""+num1a+" - ("+num1b+")");
            }
            else{
                ans1.setText(""+num1a+" - "+num1b);
            }
        }

        if (new Random().nextDouble()<0.5){
            num2b = val2-num2a;
            if (num2b<0){
                ans2.setText(""+num2a+" + ("+num2b+")");
            }
            else{
                ans2.setText(""+num2a+" + "+num2b);
            }
        }
        else{
            num2b = num2a - val2;
            if (num2b<0){
                ans2.setText(""+num2a+" - ("+num2b+")");
            }
            else {
                ans2.setText(""+num2a+" - "+num2b);
            }
        }

        //Toast.makeText(this, val1+"\t"+val2, Toast.LENGTH_LONG).show();


        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GameActivity.this.val1>GameActivity.this.val2){
                    Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                    finish();
                }
                else{
                    Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_LONG).show();
                    recreate();
                }
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GameActivity.this.val2>GameActivity.this.val1){
                    Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                    finish();
                }
                else{
                    Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_LONG).show();
                    recreate();
                }
            }
        });

    }
}
