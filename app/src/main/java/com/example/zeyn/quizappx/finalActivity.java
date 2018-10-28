package com.example.zeyn.quizappx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalActivity extends AppCompatActivity {
    TextView mScore;
    Button btnFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        mScore = findViewById(R.id.points);
        btnFinal = findViewById(R.id.startAgain);

        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.score = 0;
                finish();
            }
        });
        updateScore();
    }

    public void updateScore() {
        mScore.setText(getString(R.string.finalScore)+" "
                +(MainActivity.score)+getString(R.string.scoreEnd)
                +getString(R.string.finalSetup)+" "
                +(MainActivity.score/10)+" "+getString(R.string.finalEnd));
    }
}
