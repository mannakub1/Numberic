package com.example.manny.numberic;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.manny.numberic.model.model;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GameActivity extends AppCompatActivity {

    private String[] listLevel = {"Easy", "Medium", "Hard"};
    String[] listOfEndGame = new String[] {"Yes", "No"};
    private static String COL_LEVELS = model.COL_LEVELS;
    private static String COL_TIME = model.COL_TIME;
    private static String TABLE_NAME = model.TABLE_NAME;
    private static String COL_SCORE = model.COL_SCORE;
    private SQLiteDatabase mDatabase;
    private SimpleCursorAdapter mAdapter;
    Timer T  ;
    int mLevel;
    TextView textShowTime ;
    int countTime ;
    String key = "Level";

    Random ran = new Random();
    static int level;
    static int currentNum = 0;
    static int index1st = 0;
    static int num1st[] = new int[25];
    static int index2nd = 0;
    static int num2nd[] = new int[25];
    static int index3rd = 0;
    static int num3rd[] = new int[25];
    static int usedColor[] = new int[25];
    static String colorList[] = {"#da2020", "#107ea8", "#99cc00", "#aa66cc", "#ff8800",
            "#dd00cd", "#951add", "#5342d6", "#957451", "#00e248",
            "#1f26ff", "#c07000", "#15d504", "#2daeda", "#e6ba60",
            "#60527a", "#6b93e3", "#0ac17b", "#e89183", "#b62022",
            "#6cbd0a", "#f73500", "#c0d200", "#519572", "#419001"};

    Button number1;
    Button number2;
    Button number3;
    Button number4;
    Button number5;
    Button number6;
    Button number7;
    Button number8;
    Button number9;
    Button number10;
    Button number11;
    Button number12;
    Button number13;
    Button number14;
    Button number15;
    Button number16;
    Button number17;
    Button number18;
    Button number19;
    Button number20;
    Button number21;
    Button number22;
    Button number23;
    Button number24;
    Button number25;
    TextView tv;
    TextView lvl;
    TextView timing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        T = new Timer();
        textShowTime = (TextView) findViewById(R.id.showTime);
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textShowTime.setText(setShowTime(countTime));
                        countTime++;
                    }
                });
            }
        }, 1000, 1000);




        number1 = (Button) findViewById(R.id.number1);
        number2 = (Button) findViewById(R.id.number2);
        number3 = (Button) findViewById(R.id.number3);
        number4 = (Button) findViewById(R.id.number4);
        number5 = (Button) findViewById(R.id.number5);
        number6 = (Button) findViewById(R.id.number6);
        number7 = (Button) findViewById(R.id.number7);
        number8 = (Button) findViewById(R.id.number8);
        number9 = (Button) findViewById(R.id.number9);
        number10 = (Button) findViewById(R.id.number10);
        number11 = (Button) findViewById(R.id.number11);
        number12 = (Button) findViewById(R.id.number12);
        number13 = (Button) findViewById(R.id.number13);
        number14 = (Button) findViewById(R.id.number14);
        number15 = (Button) findViewById(R.id.number15);
        number16 = (Button) findViewById(R.id.number16);
        number17 = (Button) findViewById(R.id.number17);
        number18 = (Button) findViewById(R.id.number18);
        number19 = (Button) findViewById(R.id.number19);
        number20 = (Button) findViewById(R.id.number20);
        number21 = (Button) findViewById(R.id.number21);
        number22 = (Button) findViewById(R.id.number22);
        number23 = (Button) findViewById(R.id.number23);
        number24 = (Button) findViewById(R.id.number24);
        number25 = (Button) findViewById(R.id.number25);
        tv = (TextView) findViewById(R.id.textView);
        lvl = (TextView) findViewById(R.id.textView2);

        Intent i = getIntent();
        mLevel = i.getIntExtra(key, 1);
        if (mLevel == 1) {
            lvl.setText("Level : Easy"); //1-25
            level = 1;
            num1st = reset(num1st);
            num2nd = reset(num2nd);
            num3rd = reset(num3rd);
            randomNumber1st();
        } else if (mLevel == 2) {
            lvl.setText("Level : Medium"); //1-50
            level = 2;
            num1st = reset(num1st);
            num2nd = reset(num2nd);
            num3rd = reset(num3rd);
            randomNumber1st();
            randomNumber2nd();
        } else if(mLevel == 3){
            lvl.setText("Level : Hard"); //1-75
            level = 3;
            num1st = reset(num1st);
            num2nd = reset(num2nd);
            num3rd = reset(num3rd);
            randomNumber1st();
            randomNumber2nd();
            randomNumber3rd();
        }

        Log.i("End","random 3 rd");
        currentNum = 0;
        index1st = 0;
        index2nd = 0;
        index3rd = 0;
        tv.setText("Current Number : 0");
        setBtn(number1);
        setBtn(number2);
        setBtn(number3);
        setBtn(number4);
        setBtn(number5);
        setBtn(number6);
        setBtn(number7);
        setBtn(number8);
        setBtn(number9);
        setBtn(number10);
        setBtn(number11);
        setBtn(number12);
        setBtn(number13);
        setBtn(number14);
        setBtn(number15);
        setBtn(number16);
        setBtn(number17);
        setBtn(number18);
        setBtn(number19);
        setBtn(number20);
        setBtn(number21);
        setBtn(number22);
        setBtn(number23);
        setBtn(number24);
        setBtn(number25);

        usedColor = reset(usedColor);
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number1, tv);
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number2, tv);
            }
        });
        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number3, tv);
            }
        });
        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number4, tv);
            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number5, tv);
            }
        });
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number6, tv);
            }
        });
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number7, tv);
            }
        });
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number8, tv);
            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number9, tv);
            }
        });
        number10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number10, tv);
            }
        });
        number11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number11, tv);
            }
        });
        number12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number12, tv);
            }
        });
        number13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number13, tv);
            }
        });
        number14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number14, tv);
            }
        });
        number15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number15, tv);
            }
        });
        number16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number16, tv);
            }
        });
        number17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number17, tv);
            }
        });
        number18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number18, tv);
            }
        });
        number19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number19, tv);
            }
        });
        number20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number20, tv);
            }
        });
        number21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number21, tv);
            }
        });
        number22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number22, tv);
            }
        });
        number23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number23, tv);
            }
        });
        number24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number24, tv);
            }
        });
        number25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number25, tv);
            }
        });
    }

    public void newGame(int levels){
        mLevel = levels;
        countTime = 0;
        T = new Timer();
        textShowTime = (TextView) findViewById(R.id.showTime);
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textShowTime.setText(setShowTime(countTime));
                        countTime++;
                    }
                });
            }
        }, 1000, 1000);

        if (levels == 1) {
            lvl.setText("Level : Easy"); //1-25
            level = 1;
            num1st = reset(num1st);
            num2nd = reset(num2nd);
            num3rd = reset(num3rd);
            randomNumber1st();
        } else if (levels == 2) {
            lvl.setText("Level : Medium"); //1-50
            level = 2;
            num1st = reset(num1st);
            num2nd = reset(num2nd);
            num3rd = reset(num3rd);
            randomNumber1st();
            randomNumber2nd();
        } else {
            lvl.setText("Level : Hard"); //1-75
            level = 3;
            num1st = reset(num1st);
            num2nd = reset(num2nd);
            num3rd = reset(num3rd);
            randomNumber1st();
            randomNumber2nd();
            randomNumber3rd();
        }
        Log.i("End","random 3 rd");
        currentNum = 0;
        index1st = 0;
        index2nd = 0;
        index3rd = 0;
        tv.setText("Current Number : 0");
        setBtn(number1);
        setBtn(number2);
        setBtn(number3);
        setBtn(number4);
        setBtn(number5);
        setBtn(number6);
        setBtn(number7);
        setBtn(number8);
        setBtn(number9);
        setBtn(number10);
        setBtn(number11);
        setBtn(number12);
        setBtn(number13);
        setBtn(number14);
        setBtn(number15);
        setBtn(number16);
        setBtn(number17);
        setBtn(number18);
        setBtn(number19);
        setBtn(number20);
        setBtn(number21);
        setBtn(number22);
        setBtn(number23);
        setBtn(number24);
        setBtn(number25);

        usedColor = reset(usedColor);
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number1, tv);
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number2, tv);
            }
        });
        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number3, tv);
            }
        });
        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number4, tv);
            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number5, tv);
            }
        });
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number6, tv);
            }
        });
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number7, tv);
            }
        });
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number8, tv);
            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number9, tv);
            }
        });
        number10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number10, tv);
            }
        });
        number11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number11, tv);
            }
        });
        number12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number12, tv);
            }
        });
        number13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number13, tv);
            }
        });
        number14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number14, tv);
            }
        });
        number15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number15, tv);
            }
        });
        number16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number16, tv);
            }
        });
        number17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number17, tv);
            }
        });
        number18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number18, tv);
            }
        });
        number19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number19, tv);
            }
        });
        number20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number20, tv);
            }
        });
        number21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number21, tv);
            }
        });
        number22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number22, tv);
            }
        });
        number23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number23, tv);
            }
        });
        number24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number24, tv);
            }
        });
        number25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(number25, tv);
            }
        });

    }
    public String setShowTime(int countTime){
        return String.format("%02d:%02d", (countTime/60)%60 , countTime % 60);
    }
    public void checkAns(Button btn, TextView tv) {
        int num = Integer.parseInt(btn.getText().toString());
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(500);
        if (currentNum < 25) { //1st stage
            if (num == currentNum + 1) { //correct
                if (level == 1) {
                    btn.setAnimation(fadeOut);
                    btn.setVisibility(View.INVISIBLE);
                    currentNum = num;
                    tv.setText("Current Number : " + currentNum);
                    if (currentNum == 25) {
                        num1st = reset(num1st);
                        showScoreTime();
                        //end game of easy mode
                    }
                } else {
                    CharSequence changNum = String.valueOf(num2nd[index2nd]);
                    btn.setText(changNum);
                    btn.setBackgroundColor(randomBGC());
                    currentNum = num;
                    tv.setText("Current Number : " + currentNum);
                    ++index2nd;
                }
            } else { //wrong

            }
        } else if (currentNum < 50) { //2nd stage
            if (num == currentNum + 1) { //correct
                if (level == 2) {
                    btn.setAnimation(fadeOut);
                    btn.setVisibility(View.INVISIBLE);
                    currentNum = num;
                    tv.setText("Current Number : " + currentNum);
                    if (currentNum == 50) {
                        num1st = reset(num1st);
                        num2nd = reset(num2nd);
                        showScoreTime();
                        //end game of medium mode
                    }
                } else {
                    CharSequence changNum = String.valueOf(num3rd[index3rd]);
                    btn.setText(changNum);
                    btn.setBackgroundColor(randomBGC());
                    currentNum = num;
                    tv.setText("Current Number : " + currentNum);
                    ++index3rd;
                    if (currentNum == 50) {
                        usedColor = reset(usedColor); //reset colorlist for next stage
                    }
                }
            } else { //wrong

            }
        } else { //3rd stage
            if (num == currentNum + 1) { //correct
                btn.setAnimation(fadeOut);
                btn.setVisibility(View.INVISIBLE);
                currentNum = num;
                tv.setText("Current Number : " + currentNum);
                if (currentNum == 75) {
                    num1st = reset(num1st);
                    num2nd = reset(num2nd);
                    num3rd = reset(num3rd);
                    showScoreTime();
                    //end game of hard mode
                }
            } else { //wrong

            }
        }
    }

    public void randomNumber1st() { //random number stage 1st
        int num, i = 0, c;
        while (true) {
            num = ran.nextInt(25);
            ++num;
            c = 0;
            for (int j = 0; j < 25; j++) {
                if (num != num1st[j]) {
                    ++c;
                }
            }
            if (c == 25) {
                num1st[i] = num;
                Log.i("1stNum", String.valueOf(num1st[i]));
                i++;
                c = 0;
            }
            if (i == 25) {
                break;
            }
        }
    }

    public void randomNumber2nd() { //random number 2nd stage
        int num, i = 0, c;
        while (true) {
            num = ran.nextInt(25);
            num += 26;
            c = 0;
            for (int j = 0; j < 25; j++) {
                if (num != num2nd[j]) {
                    ++c;
                }
            }
            if (c == 25) {
                num2nd[i] = num;
                Log.i("2ndtNum", String.valueOf(num2nd[i]));
                i++;
                c = 0;
            }
            if (i == 25) {
                break;
            }
        }
    }

    private void randomNumber3rd() {
        int num, i = 0, c;
        while (true) {
            num = ran.nextInt(25);
            num += 26;
            c = 0;
            for (int j = 0; j < 25; j++) {
                if (num != num3rd[j]) {
                    ++c;
                }
            }
            if (c == 25) {
                num3rd[i] = num;
                Log.i("3rdNum", String.valueOf(num3rd[i]));
                i++;
                c = 0;
            }
            if (i == 25) {
                break;
            }
        }
    }

    public void setBtn(Button btn) { //set button when game start
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(500);
        btn.setBackgroundColor(randomBGC());
        btn.setText(String.valueOf(num1st[index1st]));
        ++index1st;
        btn.startAnimation(fadeIn);
    }

    public int randomBGC() {
        int ranColor;
        while (true) {
            ranColor = ran.nextInt(25);
            if (usedColor[ranColor] != 1) {
                usedColor[ranColor] = 1;
                return Color.parseColor(colorList[ranColor]);
            }
        }
    }

    public int[] reset(int[] preNum) {
        for (int i = 0; i < 25; i++) {
            preNum[i] = 0;
        }
        return preNum;
    }

    public static ContentValues AddDatabase(int mLevel, int i, String s) {
        ContentValues cv = new ContentValues();
        cv.put(COL_LEVELS,mLevel);
        cv.put(COL_SCORE, i);
        cv.put(COL_TIME, s);
        return cv;
    }


    public void showScoreTime(){
        number1.setVisibility(View.VISIBLE);
        number2.setVisibility(View.VISIBLE);
        number3.setVisibility(View.VISIBLE);
        number4.setVisibility(View.VISIBLE);
        number5.setVisibility(View.VISIBLE);
        number6.setVisibility(View.VISIBLE);
        number7.setVisibility(View.VISIBLE);
        number8.setVisibility(View.VISIBLE);
        number9.setVisibility(View.VISIBLE);
        number10.setVisibility(View.VISIBLE);
        number11.setVisibility(View.VISIBLE);
        number12.setVisibility(View.VISIBLE);
        number13.setVisibility(View.VISIBLE);
        number14.setVisibility(View.VISIBLE);
        number15.setVisibility(View.VISIBLE);
        number16.setVisibility(View.VISIBLE);
        number17.setVisibility(View.VISIBLE);
        number18.setVisibility(View.VISIBLE);
        number19.setVisibility(View.VISIBLE);
        number20.setVisibility(View.VISIBLE);
        number21.setVisibility(View.VISIBLE);
        number22.setVisibility(View.VISIBLE);
        number23.setVisibility(View.VISIBLE);
        number24.setVisibility(View.VISIBLE);
        number25.setVisibility(View.VISIBLE);

        T.cancel();
        model mModel = new model(this);
        mDatabase = mModel.getWritableDatabase();
        mDatabase.insert(TABLE_NAME, null, AddDatabase(mLevel, --countTime, setShowTime(--countTime)));
        new AlertDialog.Builder(GameActivity.this)
                .setTitle("Game Cleared")
                .setMessage("Your time is " + setShowTime(countTime))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        endGame();
                    }
                })
                .create()
                .show();
    }
    public void endGame() {
        new AlertDialog.Builder(GameActivity.this)
                .setTitle("Wanna Play Again")
                .setItems(listOfEndGame, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            new AlertDialog.Builder(GameActivity.this)
                                    .setTitle("Please Select Level")
                                    .setItems(listLevel, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            newGame(which + 1);
                                        }
                                    })
                                    .create()
                                    .show();
                        } else {
                            finish();
                        }

                    }
                })
                .create()
                .show();
    }
}
