package com.example.android.scorecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jam on 28.02.2017.
 */

public class volleyballScreen extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volleyball);
        View Reset = findViewById(R.id.reset);
        Reset.setOnClickListener(this);
        View Back = findViewById(R.id.back);
        Back.setOnClickListener(this);
    }
        /*
        * in case of rotating the phone funct saving data
        */

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("MyInt1", actualScore1);
        savedInstanceState.putInt("MyInt2", actualScore2);
        savedInstanceState.putInt("MyInt3", setsNumber1);
        savedInstanceState.putInt("MyInt4", setsNumber2);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        actualScore1 = savedInstanceState.getInt("MyInt1");
        actualScore2 = savedInstanceState.getInt("MyInt2");
        setsNumber1 = savedInstanceState.getInt("MyInt3");
        setsNumber2 = savedInstanceState.getInt("MyInt4");
        display1(actualScore1);
        display2(actualScore2);
        displaySet1(setsNumber1);
        displaySet2(setsNumber2);
    }

    /*
    Buttons
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset:
                display1(0);
                actualScore1 = 0;
                display2(0);
                actualScore2 = 0;
                displaySet1(0);
                displaySet2(0);
                setsNumber1 = 0;
                setsNumber2 = 0;
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    /*
    Adding points
     */
    int actualScore1 = 0;
    int actualScore2 = 0;
    int setsNumber1 = 0;
    int setsNumber2 = 0;

    public void Count1(View view) {
        actualScore1 += 1;
        display1(actualScore1);
        checkIfWonSet();
    }

    public void Count2(View view) {
        actualScore2 += 1;
        display2(actualScore2);
        checkIfWonSet();
    }

    public void addSet1() {
        setsNumber1 += 1;
        displaySet1(setsNumber1);
    }

    public void addSet2() {
        setsNumber2 += 1;
        displaySet2(setsNumber2);
    }

    /*
    *displaying points and number of sets
    */

    private void display1(int number) {
        TextView t = (TextView) findViewById(R.id.score_1);
        t.setText(String.valueOf(number));
    }

    private void display2(int number) {
        TextView t = (TextView) findViewById(R.id.score_2);
        t.setText(String.valueOf(number));
    }

    private void displaySet1(int number) {
        TextView t = (TextView) findViewById(R.id.set_1);
        t.setText(String.valueOf(number));
    }

    private void displaySet2(int number) {
        TextView t = (TextView) findViewById(R.id.set_2);
        t.setText(String.valueOf(number));
    }

    /*
    End match funcs
     */

    private void resetAfterSet() {
        actualScore1 = 0;
        actualScore2 = 0;
    }

    private void checkIfWonSet() {
        if (actualScore1 >= 25 && actualScore1 - actualScore2 >= 2) {
            addSet1();
            resetAfterSet();
            display1(0);
            display2(0);
            checkIfWonMatch();
        } else if (actualScore2 >= 25 && actualScore2 - actualScore1 >= 2) {
            addSet2();
            resetAfterSet();
            display1(0);
            display2(0);
            checkIfWonMatch();
        }
    }

    private void checkIfWonMatch() {
        if (setsNumber1 == 3) {
            TextView editText = (EditText) findViewById(R.id.player_1);
            String Result = editText.getText().toString() + " won";
            Intent i = new Intent(this, WinnerWindow.class);
            i.putExtra("Results", Result);
            startActivity(i);

        }
        if (setsNumber2 == 3) {
            TextView editText = (EditText) findViewById(R.id.player_2);
            String Result = editText.getText().toString() + " won";
            Intent i = new Intent(this, WinnerWindow.class);
            i.putExtra("Results", Result);
            startActivity(i);

        }
    }
}