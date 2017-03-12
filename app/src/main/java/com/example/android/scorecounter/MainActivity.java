package com.example.android.scorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*
* Main menu letting user to choose whether the want
* to count basketball or volleyball scores
*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View buttonBasketball = findViewById(R.id.basketball);
        buttonBasketball.setOnClickListener(this);
        View buttonVolleyball = findViewById(R.id.volleyball);
        buttonVolleyball.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basketball:
                Intent iB = new Intent(this, basketballScreen.class);
                startActivity(iB);
                break;
            case R.id.volleyball:
                Intent iV = new Intent(this, volleyballScreen.class);
                startActivity(iV);
                break;
        }
    }

}
