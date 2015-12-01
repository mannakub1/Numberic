package com.example.manny.numberic;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

import com.example.manny.numberic.R;
import com.example.manny.numberic.model.model;

public class MainActivity extends AppCompatActivity {

    private String[] Level={"Easy", "Mediuun", "Hard"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button startGame = (Button) findViewById(R.id.Start_button);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
            }
        });

        Button highScore = (Button) findViewById(R.id.HighScore_button);
        highScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

    }

    // For GameActivity
    public void select_level(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Please Select Level")
                .setItems(Level, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String select = Level[which];
                        if(select.equals("Easy")) {

                        }
                        else if(select.equals("Medium")){

                        }
                        else{

                        }
            }
        })
                .create()
                .show();
    }



}
