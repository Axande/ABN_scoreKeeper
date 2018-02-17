package com.example.andrei.abn_scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0, scoreB = 0;
    String events = "";
    int playerA[] = new int[12]; //0 - neutral, 1 - yellow, >=2 red
    int playerB[] = new int[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void yellowTeamA(View v){
        RadioGroup radioButtonGroup = findViewById(R.id.players_teamA);
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton);

        playerA[idx] ++;
        if(playerA[idx] == 1){
            radioButton.setBackgroundColor(getResources().getColor(R.color.yellowCard));
            addNewEvent("Player " + (idx+1) + " of team A got an yellow card!");
        } else if(playerA[idx] == 2){
            radioButton.setBackgroundColor(getResources().getColor(R.color.redCard));
            radioButton.setEnabled(false);
            addNewEvent("Player " + (idx+1) + " of team A got a second yellow card!");
        }
        radioButton.setSelected(false);
    }

    public void yellowTeamB(View v){
        RadioGroup radioButtonGroup = findViewById(R.id.players_teamB);
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton);

        playerB[idx] ++;
        if(playerB[idx] == 1){
            radioButton.setBackgroundColor(getResources().getColor(R.color.yellowCard));
            addNewEvent("Player " + (idx+1) + " of team B got an yellow card!");
        } else if(playerB[idx] == 2){
            radioButton.setBackgroundColor(getResources().getColor(R.color.redCard));
            radioButton.setEnabled(false);
            addNewEvent("Player " + (idx+1) + " of team B got a second yellow card!");
        }
        radioButton.setSelected(false);
    }

    public void redTeamA(View v){
        RadioGroup radioButtonGroup = findViewById(R.id.players_teamA);
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton);

        if(playerA[idx] < 2) {
            playerA[idx] = 2;
            radioButton.setBackgroundColor(getResources().getColor(R.color.redCard));
            radioButton.setEnabled(false);
            addNewEvent("Player " + (idx + 1) + " of team A got a red card!");
            radioButton.setSelected(false);
        }
    }

    public void redTeamB(View v){
        RadioGroup radioButtonGroup = findViewById(R.id.players_teamB);
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton);

        if(playerB[idx] < 2){
            playerB[idx] = 2;
            radioButton.setBackgroundColor(getResources().getColor(R.color.redCard));
            radioButton.setEnabled(false);
            addNewEvent("Player " + (idx+1) + " of team B got a red card!");
            radioButton.setSelected(false);
        }

    }

    public void resetAll(View v) {
        TextView tw;

        tw = (TextView)findViewById(R.id.teamA_score);
        tw.setText(R.string.initial_score);
        scoreA = 0;

        tw = (TextView)findViewById(R.id.teamB_score);
        tw.setText(R.string.initial_score);
        scoreB = 0;

        tw = (TextView)findViewById(R.id.events);
        tw.setText(R.string.initial_events);
        events = "";

        for(int i = 0; i < 12; i++){
            playerA[i] = 0;
            playerB[i] = 0;
        }

        RadioGroup radioButtonGroup = findViewById(R.id.players_teamA);
        for (int i = 0; i < radioButtonGroup.getChildCount(); i++) {
            View radioButton = radioButtonGroup.getChildAt(i);
            radioButton.setEnabled(true);
            radioButton.setBackgroundColor(getResources().getColor(R.color.white));
        }
        radioButtonGroup.clearCheck();

        radioButtonGroup = findViewById(R.id.players_teamB);
        for (int i = 0; i < radioButtonGroup.getChildCount(); i++) {
            View radioButton = radioButtonGroup.getChildAt(i);
            radioButton.setEnabled(true);
            radioButton.setBackgroundColor(getResources().getColor(R.color.white));
        }
        radioButtonGroup.clearCheck();
    }

    public void teamAscore(View v){
        TextView tw = (TextView)findViewById(R.id.teamA_score);
        scoreA += 1;
        tw.setText(String.valueOf(scoreA));

        addNewEvent("Team A scored a goal!");
    }

    public void teamBscore(View v){
        TextView tw = (TextView)findViewById(R.id.teamB_score);
        scoreB += 1;
        tw.setText(String.valueOf(scoreB));

        addNewEvent("Team B scored a goal!");
    }

    public void addNewEvent(String s){
        TextView tw = (TextView) findViewById(R.id.events);

        events = s + '\n' + events;
        tw.setText(events);
    }

}
