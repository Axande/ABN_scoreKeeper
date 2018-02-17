package com.example.andrei.abn_scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0, scoreB = 0;
    String events = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    public void teamA_score(View v){
        TextView tw = (TextView)findViewById(R.id.teamA_score);
        scoreA += 1;
        tw.setText(String.valueOf(scoreA));
    }

    public void teamB_score(View v){
        TextView tw = (TextView)findViewById(R.id.teamB_score);
        scoreB += 1;
        tw.setText(String.valueOf(scoreB));
    }

    public void addNewEvent(String s){
        TextView tw = (TextView) findViewById(R.id.events);

        events = s + '\n' + events;
        tw.setText(events);
    }

}
