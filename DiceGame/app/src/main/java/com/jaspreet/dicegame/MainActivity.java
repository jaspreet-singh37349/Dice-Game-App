package com.jaspreet.dicegame;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String title;
    private int ct=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ct=1;
        Button buttonroll = (Button)findViewById(R.id.button);
        final ImageView leftdice = (ImageView)findViewById(R.id.image_leftdice);
        final ImageView rightdice = (ImageView)findViewById(R.id.image_rightdice);

        final int[] dicearray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        buttonroll.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Log.d("jassi","button pressed");

                Random randomno = new Random();
                int integer = randomno.nextInt(6);

                Log.d("jassi","the no is ");

                leftdice.setImageResource(dicearray[integer]);
                int intege = randomno.nextInt(6);
                rightdice.setImageResource(dicearray[intege]);

                if(integer==intege&&integer==5) {
                    title = "Congratulations! You Won\n";
                    title += "No. Of Attempts = "+ct;
                    ct=1;
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(R.string.dialog_message)
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    finish();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle(title);
                    alert.show();
                }
                else
                {
                    ct++;
                }
            }
        });

    }
}
