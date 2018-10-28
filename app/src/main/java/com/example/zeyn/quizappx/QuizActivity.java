package com.example.zeyn.quizappx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private TextView mQuestionTV, mScore;
    private RadioButton mR1, mR2, mR3, mR4, mA, selectedRadioButton;
    private Button btnNext;
    private RadioGroup rG;
    private static final String KEY_INDEX = "index";
    private static final String KEY_COUNT = "counter";
    private static final String TAG = "QuizActivity";

    private Question[] questions = {
            new Question(R.string.q1, R.string.ans1),
            new Question(R.string.q2, R.string.ans2),
            new Question(R.string.q3, R.string.ans3),
            new Question(R.string.q4, R.string.ans4),
            new Question(R.string.q5, R.string.ans5)
    };

    private int mIndex, count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(KEY_INDEX, 0);
            count = savedInstanceState.getInt(KEY_COUNT, 0);
        }

        mQuestionTV = findViewById(R.id.qTV);
        mR1 = findViewById(R.id.rb1);
        mR2 = findViewById(R.id.rb2);
        mR3 = findViewById(R.id.rb3);
        mR4 = findViewById(R.id.rb4);
        mA = findViewById(R.id.rbA);
        btnNext = findViewById(R.id.btnNext);
        mScore = findViewById(R.id.countTV);
        rG = findViewById(R.id.radioGroup);

        if(count == 0) {
            mIndex=(int)Math.floor(Math.random()*(4-(9+1))+(9));
            mIndex = (mIndex + 1) % questions.length;
            count++;
        }

        Toast.makeText(this,"Select an answer",Toast.LENGTH_SHORT).show();
        rG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getCheckedRadioButtonId() == -1)
                {
                   btnNext.setEnabled(false);
                }
                else
                {
                    int selectedId = group.getCheckedRadioButtonId();
                    selectedRadioButton = findViewById(selectedId);
                    btnNext.setEnabled(true);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count < questions.length){
                    mA.setText(questions[mIndex].getAns());
                    mIndex = (mIndex + 1) % questions.length;
                    updateAnswer();
                    updateQuestion();
                    rG.clearCheck();
                    btnNext.setEnabled(false);
                    count++;
                }else{
                    MainActivity.score += 10;
                    Intent intent = new Intent(QuizActivity.this, finalActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        mScore.setText(getString(R.string.scoreSetup)+" "+(MainActivity.score)+getString(R.string.scoreEnd));
        updateQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mIndex);
        savedInstanceState.putInt(KEY_COUNT, count);
    }

    public void updateAnswer() {
        if(selectedRadioButton.getText() == mA.getText()){
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            MainActivity.score += 10;
            mScore.setText(getString(R.string.scoreSetup)+" "+(MainActivity.score)+getString(R.string.scoreEnd));
        }
    }

    public void updateQuestion() {
        int question = questions[mIndex].getQuestionText();
        if(questions[mIndex].getQuestionText()== R.string.q1){
            mQuestionTV.setText(question);
            mR1.setText(R.string.ans11);
            mR2.setText(R.string.ans12);
            mR3.setText(R.string.ans13);
            mR4.setText(R.string.ans14);
        } else if(questions[mIndex].getQuestionText()== R.string.q2){
            mQuestionTV.setText(question);
            mR1.setText(R.string.ans21);
            mR2.setText(R.string.ans22);
            mR3.setText(R.string.ans23);
            mR4.setText(R.string.ans24);
        } else if(questions[mIndex].getQuestionText()== R.string.q3){
            mQuestionTV.setText(question);
            mR1.setText(R.string.ans31);
            mR2.setText(R.string.ans32);
            mR3.setText(R.string.ans33);
            mR4.setText(R.string.ans34);
        } else if(questions[mIndex].getQuestionText()== R.string.q4){
            mQuestionTV.setText(question);
            mR1.setText(R.string.ans41);
            mR2.setText(R.string.ans42);
            mR3.setText(R.string.ans43);
            mR4.setText(R.string.ans44);
        } else if(questions[mIndex].getQuestionText()== R.string.q5){
            mQuestionTV.setText(question);
            mR1.setText(R.string.ans51);
            mR2.setText(R.string.ans52);
            mR3.setText(R.string.ans53);
            mR4.setText(R.string.ans54);
        } else{
            Log.d("tag", "E");
        }
    }
}
  