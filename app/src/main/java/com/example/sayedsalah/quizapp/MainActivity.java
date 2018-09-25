package com.example.sayedsalah.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    Button submit,reset;

    CheckBox mCheckBox1,mCheckBox2,mCheckBox3,mCheckBox4;

    EditText mEditTextQ4;

    RadioGroup mRadioGroup1,mRadioGroup2;

    private int score1, score2, score4, score5, totalScore;
    private boolean checked1, checked2, checked5;
    private String anwser4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckBox1 = (CheckBox) findViewById(R.id.button51);
        mCheckBox2 = (CheckBox) findViewById(R.id.button52);
        mCheckBox3 = (CheckBox) findViewById(R.id.button53);
        mCheckBox4 = (CheckBox) findViewById(R.id.button54);

        mEditTextQ4 = (EditText) findViewById(R.id.edit_text_q4);

        mRadioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        mRadioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);

    }


    public void onCheckedQuestion1(View view) {
        checked1 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button11:
                if (checked1) {
                    score1 = 0;
                    break;
                }
            case R.id.button12:
                if (checked1) {
                    score1 = 20;
                    break;
                }
            case R.id.button13:
                if (checked1) {
                    score1 = 0;
                    break;
                }
        }
    }



    public void onCheckedQuestion2(View view) {
        checked2 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button21:
                if (checked2) {
                    score2 = 20;
                    break;
                }
            case R.id.button22:
                if (checked2) {
                    score2 = 0;
                    break;
                }
            case R.id.button23:
                if (checked2) {
                    score2 = 0;
                    break;
                }
        }
    }



    public void onCheckedQuestion4(View view) {
        checked5 = mCheckBox1.isChecked() || mCheckBox2.isChecked() || mCheckBox3.isChecked() || mCheckBox4.isChecked();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.submit:
                anwser4 = mEditTextQ4.getText().toString();


                if (checked1 && checked2 && !anwser4.equals("") && checked5) {


                    if (anwser4.toLowerCase().equals("java"))
                        score4 = 20;
                    else
                        score4 = 0;

                    score5 = 0;
                    if (mCheckBox1.isChecked()) {
                        score5 += -10;
                    }
                    if (mCheckBox2.isChecked()) {
                        score5 += 10;
                    }
                    if (mCheckBox3.isChecked()) {
                        score5 += 10;
                    }
                    if (mCheckBox4.isChecked()) {
                        score5 += 10;
                    }

                    if (score5 < 0) {
                        score5 = 0;
                    }

                    totalScore = score1 + score2 + score4 + score5;

                    Toast.makeText(getBaseContext(), "your score is" + " " + totalScore, Toast.LENGTH_LONG).show();
                }

                else {

                    Toast.makeText(getBaseContext(), "sure to answer all question", Toast.LENGTH_SHORT).show();

                }
            break;

            case R.id.reset:
                mRadioGroup1.clearCheck();
                mRadioGroup2.clearCheck();
                mEditTextQ4.setText("");
                mCheckBox1.setChecked(false);
                mCheckBox2.setChecked(false);
                mCheckBox3.setChecked(false);
                mCheckBox4.setChecked(false);
                checked5 = false;
                break;
        }


    }
}
