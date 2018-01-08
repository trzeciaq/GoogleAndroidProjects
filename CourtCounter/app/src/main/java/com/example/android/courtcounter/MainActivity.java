package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    int goalsTeamA = 0;
    int goalsTeamB = 0;
    int faulsTeamA = 0;
    int faulsTeamB = 0;
    int offsidesTeamA = 0;
    int offsidesTeamB = 0;
    String currentTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public String getCurrentTime(){
        return currentTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    }

    public void displayForTeamA(String time) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        TextView faulsView = (TextView) findViewById(R.id.fauls_score_team_a);
        TextView offsidesView = (TextView) findViewById(R.id.offsides_score_team_a);
        TextView updateView = (TextView) findViewById(R.id.update_text_view);

        scoreView.setText(String.valueOf(goalsTeamA));
        faulsView.setText(String.valueOf(getString(R.string.faults) + faulsTeamA));
        offsidesView.setText(String.valueOf(getString(R.string.offsides) + offsidesTeamA));
        updateView.setText(String.valueOf(getString(R.string.last_update) + time));
    }

    public void goalTeamA(View view) {
        goalsTeamA += 1;
        displayForTeamA(getCurrentTime());
    }

    public void faulsTeamA(View view) {
        faulsTeamA += 1;
        displayForTeamA(getCurrentTime());
    }

    public void offsideTeamA(View view) {
        offsidesTeamA += 1;
        displayForTeamA(getCurrentTime());
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(String time ) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        TextView faulsView = (TextView) findViewById(R.id.fauls_score_team_b);
        TextView offsidesView = (TextView) findViewById(R.id.offsides_score_team_b);
        TextView updateView = (TextView) findViewById(R.id.update_text_view);

        scoreView.setText(String.valueOf(goalsTeamB));
        faulsView.setText(String.valueOf(getString(R.string.faults) + faulsTeamB));
        offsidesView.setText(String.valueOf(getString(R.string.offsides) + offsidesTeamB));
        updateView.setText(String.valueOf(getString(R.string.last_update) + time));
    }

    public void goalTeamB(View view) {
        goalsTeamB += 1;
        displayForTeamB(getCurrentTime());
    }

    public void faulsTeamB(View view) {
        faulsTeamB += 1;
        displayForTeamB(getCurrentTime());
    }

    public void offsideTeamB(View view) {
        offsidesTeamB += 1;
        displayForTeamB(getCurrentTime());
    }

    public void resetPoints(View view) {
        goalsTeamA = 0;
        goalsTeamB = 0;
        faulsTeamA = 0;
        faulsTeamB = 0;
        offsidesTeamA = 0;
        offsidesTeamB = 0;
        displayForTeamA("");
        displayForTeamB("");
    }

}
