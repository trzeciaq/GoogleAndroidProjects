package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String userProfile [] = {"", "", "", "","0"};

    public void startQuiz (){
        Intent i = new Intent(this, QuestionsActivity.class);
        Bundle playerData = new Bundle();
        playerData.putStringArray("PlayerProfile", userProfile);
        i.putExtras(playerData);
        startActivity(i);
    }

    public boolean checkPlayerData() {

        for (int index = 0; index < userProfile.length; index++) {
            if (userProfile[index].length() < 1) {
                return true;
            }
        }
        return false;
    }

    public void closeApp(View view) {
        finish();
        System.exit(0);
    }

    public void getPlayerPersonalData(View view){
        EditText textEdit = (EditText) findViewById(R.id.player_name);
        userProfile[0] = textEdit.getText().toString();
        textEdit = (EditText) findViewById(R.id.player_surname);
        userProfile[1] = textEdit.getText().toString();
        textEdit = (EditText) findViewById(R.id.player_age);
        userProfile[2] = textEdit.getText().toString();
        userProfile[3] = radioButtonGenderCheck();

        if (checkPlayerData()){
            Toast.makeText(getApplicationContext(), R.string.toastEmptyField, Toast.LENGTH_LONG).show();
            return;
        }
        else
            startQuiz();
    }
    public String radioButtonGenderCheck() {
            // Is the button now checked?
        RadioButton maleRadioButton, femaleRadioButton;
        maleRadioButton = (RadioButton) findViewById(R.id.rb_male);
        femaleRadioButton = (RadioButton) findViewById(R.id.rb_female);

        String gender;
            // Check which radio button was clicked
        if (maleRadioButton.isChecked())
            gender = "male";
        else if (femaleRadioButton.isChecked())
            gender = "female";
        else
            gender = "";

        return gender;
    }


}