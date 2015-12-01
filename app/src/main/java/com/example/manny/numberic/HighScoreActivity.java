package com.example.manny.numberic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.manny.numberic.model.model;

public class HighScoreActivity extends AppCompatActivity {

    private ContentValues cv;
    private model mModel;
    private SQLiteDatabase mDatabase;
    private SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        

       // final ListView listView = (ListView) findViewById(R.id.highscore_listView);
       // listView.setAdapter(mAdapter);


        Button easy = (Button) findViewById(R.id.easy_button);
        Button medium = (Button) findViewById(R.id.medium_button);
        Button hard = (Button) findViewById(R.id.hard_button);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }




}
