package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    String[] playerProfile = new String[5];
    String[] playerAnswers = {"","","",""};
    String[] correctAnswers = {"2", "1001110", "1", "4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Bundle userProfile = this.getIntent().getExtras();
        playerProfile = userProfile.getStringArray("PlayerProfile");
    }

    public void summaryAnswers() {
        Intent i = new Intent(this, summaryAnswers.class);
        Bundle playerData = new Bundle();
        playerData.putStringArray("PlayerProfile", playerProfile);
        i.putExtras(playerData);
        startActivity(i);
    }


    public void checkAnswerQ1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_1_q1:
                if (checked)
                    playerAnswers[0] = "1";
                break;
            case R.id.radio_2_q1:
                if (checked)
                    playerAnswers[0] = "2";
                break;
            case R.id.radio_3_q1:
                if (checked)
                    playerAnswers[0] = "3";
                break;
            case R.id.radio_4_q1:
                if (checked)
                    playerAnswers[0] = "4";
                break;
        }
        disableAnswersQ1();
    }

    public void disableAnswersQ1() {
        RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
        radioButton1 = (RadioButton) findViewById(R.id.radio_1_q1);
        radioButton1.setEnabled(false);
        radioButton2 = (RadioButton) findViewById(R.id.radio_2_q1);
        radioButton2.setEnabled(false);
        radioButton3 = (RadioButton) findViewById(R.id.radio_3_q1);
        radioButton3.setEnabled(false);
        radioButton4 = (RadioButton) findViewById(R.id.radio_4_q1);
        radioButton4.setEnabled(false);
    }

    public void checkAnswerQ2() {
        playerAnswers[1] = "";

        CheckBox ck1 = (CheckBox) findViewById(R.id.checkbox_1_q2);
        if (ck1.isChecked())
            playerAnswers[1] += "1";
        else
            playerAnswers[1] += "0";

        CheckBox ck2 = (CheckBox) findViewById(R.id.checkbox_2_q2);
        if (ck2.isChecked())
            playerAnswers[1] += "1";
        else
            playerAnswers[1] += "0";

        CheckBox ck3 = (CheckBox) findViewById(R.id.checkbox_3_q2);
        if (ck3.isChecked())
            playerAnswers[1] += "1";
        else
            playerAnswers[1] += "0";

        CheckBox ck4 = (CheckBox) findViewById(R.id.checkbox_4_q2);
        if (ck4.isChecked())
            playerAnswers[1] += "1";
        else
            playerAnswers[1] += "0";

        CheckBox ck5 = (CheckBox) findViewById(R.id.checkbox_5_q2);
        if (ck5.isChecked())
            playerAnswers[1] += "1";
        else
            playerAnswers[1] += "0";

        CheckBox ck6 = (CheckBox) findViewById(R.id.checkbox_6_q2);
        if (ck6.isChecked())
            playerAnswers[1] += "1";
        else
            playerAnswers[1] += "0";

        CheckBox ck7 = (CheckBox) findViewById(R.id.checkbox_7_q2);
        if (ck7.isChecked())
            playerAnswers[1] += "1";
        else
            playerAnswers[1] += "0";

    }

    public void toastAnswerQ2(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();
        playerAnswers[1] = "";

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_1_q2:
                if (checked)
                    Toast.makeText(getApplicationContext(), R.string.question2_answer1, Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_2_q2:
                if (checked)
                    Toast.makeText(getApplicationContext(), R.string.question2_answer2, Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_3_q2:
                if (checked)
                    Toast.makeText(getApplicationContext(), R.string.question2_answer3, Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_4_q2:
                if (checked)
                    Toast.makeText(getApplicationContext(), R.string.question2_answer4, Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_5_q2:
                if (checked)
                    Toast.makeText(getApplicationContext(), R.string.question2_answer5, Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_6_q2:
                if (checked)
                    Toast.makeText(getApplicationContext(), R.string.question2_answer6, Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_7_q2:
                if (checked)
                    Toast.makeText(getApplicationContext(), R.string.question2_answer7, Toast.LENGTH_LONG).show();
                break;

        }

        checkAnswerQ2();
    }

    public void checkAnswerQ3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_1_q3:
                if (checked)
                    playerAnswers[2] = "1";
                break;
            case R.id.radio_2_q3:
                if (checked)
                    playerAnswers[2] = "2";
                break;
            case R.id.radio_3_q3:
                if (checked)
                    playerAnswers[2] = "3";
                break;
            case R.id.radio_4_q3:
                if (checked)
                    playerAnswers[2] = "4";
                break;
        }
        disableAnswersQ3();
    }

    public void disableAnswersQ3() {
        RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
        radioButton1 = (RadioButton) findViewById(R.id.radio_1_q3);
        radioButton1.setEnabled(false);
        radioButton2 = (RadioButton) findViewById(R.id.radio_2_q3);
        radioButton2.setEnabled(false);
        radioButton3 = (RadioButton) findViewById(R.id.radio_3_q3);
        radioButton3.setEnabled(false);
        radioButton4 = (RadioButton) findViewById(R.id.radio_4_q3);
        radioButton4.setEnabled(false);
    }

    public void checkAnswerQ4() {
        EditText editText = (EditText) findViewById(R.id.q4_answer);
        String answer = editText.getText().toString();
        playerAnswers[3] = answer;
        System.out.println(answer);
    }

    public boolean checkAnswersIfEmpty() {

        for (int index = 0; index < correctAnswers.length; index++) {
            if (playerAnswers[index].length() < 1) {
                return true;
            }
        }
        return false;
    }

    public void checkAnswers(View view) {

        checkAnswerQ4();

        if (checkAnswersIfEmpty()){
            Toast.makeText(getApplicationContext(), R.string.toastEmptyField, Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            int score = 0;

            for (int index = 0; index < playerAnswers.length; index++) {
                if (playerAnswers[index].equals(correctAnswers[index])) {
                    score += 1;
                }
                playerProfile[4] = Integer.toString(score);
            }

            summaryAnswers();
            finish();
        }
    }
}
