package com.example.android.scorecounter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
* Window that shows when program decides it's the end of a match
*/

public class WinnerWindow extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String newString;
        if (savedInstanceState == null) { // opening bundle files to collect info about who won
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Results");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("Results");
        }
        setContentView(R.layout.winner_window);
        TextView winnerWindow = (TextView) findViewById(R.id.winner_window) ;
        winnerWindow.setText(newString); // setting the name of the winner as chosen by the player

    }
}