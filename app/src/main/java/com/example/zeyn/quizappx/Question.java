package com.example.zeyn.quizappx;

import android.support.v7.app.AppCompatActivity;

public class Question extends AppCompatActivity {
    private int mQuestionText;
    private int mAns;

    public Question(int mQuestionText, int answer) {
        this.mQuestionText = mQuestionText;
        this.mAns = answer;
    }

    public int getQuestionText() {
        return mQuestionText;
    }

    public int getAns() {
        return mAns;
    }

}
