package com.example.android.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etQ1;
    CheckBox[] chkBoxQ2Array = new CheckBox[4];
    RadioButton rbQ3ans1;
    RadioButton rbQ3ans2;
    EditText etQ4;
    EditText etQ5;
    EditText etQ6;

    TextView tvScore;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();

    }

    public void initialUISetup(){
        etQ1 = (EditText) findViewById(R.id.evQ1Ans);
//        chkBoxQ2Ans1 = (CheckBox) findViewById(R.id.chkBxQ2Ans1);
        chkBoxQ2Array[0] = (CheckBox) findViewById(R.id.chkBxQ2Ans1);
        chkBoxQ2Array[1] = (CheckBox) findViewById(R.id.chkBxQ2Ans2);
        chkBoxQ2Array[2] = (CheckBox) findViewById(R.id.chkBxQ2Ans3);
        chkBoxQ2Array[3] = (CheckBox) findViewById(R.id.chkBxQ2Ans4);

        //Radio button this is the only that should be selected
        rbQ3ans1 = (RadioButton) findViewById(R.id.rbQ3Ans1);
        rbQ3ans2 = (RadioButton) findViewById(R.id.rbQ3Ans2);

        etQ4 = (EditText) findViewById(R.id.etQ4Ans);
        etQ5 = (EditText) findViewById(R.id.etQ5Ans);
        etQ6 = (EditText) findViewById(R.id.etQ6Ans);

        tvScore = (TextView) findViewById(R.id.tvScore);
    }

    public void submitAnswers(View view){

        //Get all answers then check for them if wrong background color wrong ones
        boolean checkAnswers = false;

        //Question1
        checkAnswerOne();

        //Question 2
        checkAnswerTwo();

        //Question 3
        checkAnswerThree();

        //Question 4
        checkAnswerFour();

        //Question 5
        checkAnswerFive(etQ5);

        //Question 6
        checkAnswerSix(etQ6);
        tvScore.setText("" + score);

    }


    public void checkAnswerOne(){
        //What property do you use to find size of an array? length
        if(etQ1.getText().toString().toLowerCase() == "length"){
            score = score + 1;
            etQ1.setBackgroundColor(Color.GREEN);
        }
        else{
            etQ1.setBackgroundColor(Color.RED);
        }
    }
    public void checkAnswerTwo(){
        /* What are the main components in android?
         *A - Activity
         *B - Services
         *C - Broadcast Receiver
         *D - Content provider
         *Answer : A,B,C and D
         *The main components in android are Activity, services, Broadcast Receiver and content providers.
         */
        //Switch on ischecked if not change background to red and set correct to false(no point)
        for(int i = 0; i < chkBoxQ2Array.length; i++){
            if(chkBoxQ2Array[i].isChecked()){
                score = score + 1;
                chkBoxQ2Array[i].setBackgroundColor(Color.GREEN);
            }
            else{
                chkBoxQ2Array[i].setBackgroundColor(Color.RED);
            }
        }
    }
    public void checkAnswerThree(){
        //"3 You can have a RelativeLayout be a child of a LinearLayout." True or False
        if(rbQ3ans1.isChecked()){
            score = score + 1;
            rbQ3ans1.setBackgroundColor(Color.GREEN);
        }
        else{
            rbQ3ans1.setBackgroundColor(Color.RED);
        }

    }
    public void checkAnswerFour(){
       // "4 What does ADB stand for in android?" Android Debug Bridge
        if(etQ4.getText().toString().toLowerCase() == "android debug bridge"){
            score = score + 1;
            etQ4.setBackgroundColor(Color.GREEN);
        }
        else{
            etQ4.setBackgroundColor(Color.RED);
        }
    }
    public void checkAnswerFive(EditText et){
        //5 Data can be read from local source XML in android through" XML resource parser
        if(et.getText().toString().toLowerCase() == "xml resource parser"){
            score = score + 1;
            et.setBackgroundColor(Color.GREEN);
        }
        else{
            et.setBackgroundColor(Color.RED);
        }
    }
    public void checkAnswerSix(EditText et){
        //"6 What is used for size for elements, DP or SP" SP
        if(et.getText().toString().toLowerCase() == "sp"){
            score = score + 1;
            et.setBackgroundColor(Color.GREEN);
        }
        else{
            et.setBackgroundColor(Color.RED);
        }
    }

    public void resetAnswers(View v)
    {
        //reset radio buttons
        rbQ3ans1.setChecked(false);
        rbQ3ans1.setBackgroundColor(0);
        rbQ3ans2.setChecked(false);
        rbQ3ans2.setBackgroundColor(0);

        //reset checkboxes
        for(CheckBox chkBoxes : chkBoxQ2Array){
            chkBoxes.setChecked(false);
            chkBoxes.setBackgroundColor(0);
        }
        //clear text boxes
        etQ1.setText("");
        etQ1.setBackgroundColor(0);

        etQ4.setText("");
        etQ4.setBackgroundColor(0);

        etQ5.setText("");
        etQ5.setBackgroundColor(0);

        etQ6.setText("");
        etQ6.setBackgroundColor(0);

        //clear score
        score = 0;
        tvScore.setText("");

    }



}
