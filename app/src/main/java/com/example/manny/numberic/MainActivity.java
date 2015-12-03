package com.example.manny.numberic;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String[] listLevel = {"Easy", "Medium", "Hard"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button startGame = (Button) findViewById(R.id.Start_button);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_level();
            }
        });

        Button highScore = (Button) findViewById(R.id.HighScore_button);
        highScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage(HighScoreActivity.class);
                //
            }
        });

    }

    // For GameActivity
    public void select_level() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Please Select Level")
                .setItems(listLevel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("Level", String.valueOf(which + 1));
                        nextPage(which + 1, GameActivity.class);
                    }
                })
                .create()
                .show();

    }


    private void nextPage(Class str) {
        Intent i = new Intent(MainActivity.this, str);
        startActivity(i);
    }

    private void nextPage(int number, Class str) {
        Intent i = new Intent(MainActivity.this, GameActivity.class);
        i = putExtra(i, "Level", number);
        startActivity(i);
    }

    private Intent putExtra(Intent i, String key, int number) {
        i.putExtra(key, number);
        return i;
    }


}
