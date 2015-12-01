package com.example.manny.numberic;

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

import java.util.Random;


public class GameActivity extends AppCompatActivity {

    Random ran = new Random();
    static int currentNum = 0;
    static int indexPreNum = 0;
    static int preNum[] = new int[25];
    static int indexPostNum = 0;
    static int postNum[] = new int[25];
    static int usedColor[] = new int[25];
    static String colorList[] = {"#da2020", "#107ea8", "#99cc00", "#aa66cc", "#ff8800",
            "#dd00cd", "#951add", "#5342d6", "#957451", "#00e248",
            "#1f26ff", "#c07000", "#15d504", "#2daeda", "#e6ba60",
            "#60527a", "#6b93e3", "#0ac17b", "#e89183", "#b62022",
            "#6cbd0a", "#f73500", "#c0d200", "#519572", "#419001"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final Button number1 = (Button) findViewById(R.id.number1);
        final Button number2 = (Button) findViewById(R.id.number2);
        final Button number3 = (Button) findViewById(R.id.number3);
        final Button number4 = (Button) findViewById(R.id.number4);
        final Button number5 = (Button) findViewById(R.id.number5);
        final Button number6 = (Button) findViewById(R.id.number6);
        final Button number7 = (Button) findViewById(R.id.number7);
        final Button number8 = (Button) findViewById(R.id.number8);
        final Button number9 = (Button) findViewById(R.id.number9);
        final Button number10 = (Button) findViewById(R.id.number10);
        final Button number11 = (Button) findViewById(R.id.number11);
        final Button number12 = (Button) findViewById(R.id.number12);
        final Button number13 = (Button) findViewById(R.id.number13);
        final Button number14 = (Button) findViewById(R.id.number14);
        final Button number15 = (Button) findViewById(R.id.number15);
        final Button number16 = (Button) findViewById(R.id.number16);
        final Button number17 = (Button) findViewById(R.id.number17);
        final Button number18 = (Button) findViewById(R.id.number18);
        final Button number19 = (Button) findViewById(R.id.number19);
        final Button number20 = (Button) findViewById(R.id.number20);
        final Button number21 = (Button) findViewById(R.id.number21);
        final Button number22 = (Button) findViewById(R.id.number22);
        final Button number23 = (Button) findViewById(R.id.number23);
        final Button number24 = (Button) findViewById(R.id.number24);
        final Button number25 = (Button) findViewById(R.id.number25);
        final TextView tv = (TextView) findViewById(R.id.textView);

        preNum = randomNumber1st();
        usedColor = reset(usedColor);
        currentNum = 0;
        indexPostNum = 0;
        indexPreNum = 0;
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
        postNum = randomNumber2nd();
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

    public int[] randomNumber1st() { //random number stage 1st
        int num, i = 0, c;
        int preNum[] = new int[25];
        while (true) {
            num = ran.nextInt(25);
            ++num;
            c = 0;
            for (int j = 0; j < 25; j++) {
                if (num != preNum[j]) {
                    ++c;
                }
            }
            if (c == 25) {
                preNum[i] = num;
                Log.i("PreNum", String.valueOf(preNum[i]));
                i++;
                c = 0;
            }
            if (i == 25) {
                break;
            }
        }
        return preNum;
    }


    public int[] randomNumber2nd() { //random number 2nd stage
        int num, i = 0, c;
        int preNum[] = new int[25];
        while (true) {
            num = ran.nextInt(25);
            num += 26;
            c = 0;
            for (int j = 0; j < 25; j++) {
                if (num != preNum[j]) {
                    ++c;
                }
            }
            if (c == 25) {
                preNum[i] = num;
                Log.i("PreNum", String.valueOf(preNum[i]));
                i++;
                c = 0;
            }
            if (i == 25) {
                break;
            }
        }
        return preNum;
    }


    public void setBtn(Button btn) { //set button when game start
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(500);
        btn.setBackgroundColor(randomBGC());
        btn.setText(String.valueOf(preNum[indexPreNum]));
        ++indexPreNum;
        btn.startAnimation(fadeIn);
    }


    public void checkAns(Button btn, TextView tv) {
        int num = Integer.parseInt(btn.getText().toString());
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(500);
        if (currentNum <= 24) { //1st stage
            if (num == currentNum + 1) { //correct
                CharSequence changNum = String.valueOf(postNum[indexPostNum]);
                btn.setText(changNum);
                btn.setBackgroundColor(randomBGC());
                currentNum = num;
                tv.setText("Current Number : " + currentNum);
                ++indexPostNum;
            } else { //wrong

            }
        } else { //2nd stage
            if (num == currentNum + 1) { //correct
                btn.setAnimation(fadeOut);
                btn.setVisibility(View.INVISIBLE);
                currentNum = num;
                tv.setText("Current Number : " + currentNum);
            } else { //wrong

            }
        }
        //end game at 50
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
}
