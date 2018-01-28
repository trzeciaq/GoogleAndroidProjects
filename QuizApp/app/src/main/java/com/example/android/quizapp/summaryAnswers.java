package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class summaryAnswers extends AppCompatActivity {


    String[] playerProfile = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_answers);
        Bundle userProfile = this.getIntent().getExtras();
        playerProfile = userProfile.getStringArray("PlayerProfile");

        TextView tvPlayerScore = (TextView) findViewById(R.id.label_score);
        String playerScore = playerProfile[4]+ " / 4";
        tvPlayerScore.setText(playerScore);

        TextView tvPlayerName = (TextView) findViewById(R.id.label_playerName);
        String playerName = playerProfile[0] + " " + playerProfile[1];
        tvPlayerName.setText(playerName);
    }


    public void closeApp(View view) {
        finish();
        finishAffinity();
    }

}
