package com.example.dennis.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    TextView sumTextView;
    TextView resultTextView;
    TextView pointTextView;
    TextView timerTextView;
    Button playAgain;
    RelativeLayout gameRelativeLayout;
    Button button0;Button button1;Button button2;Button button3;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswers;
    int score = 0;
    int numberOfQuestions = 0;

    public void playAgain(View view){
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        pointTextView.setText("0/0");
        resultTextView.setText("");
        playAgain.setVisibility(View.INVISIBLE);
        generateQuestion();
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000+ "s"));

            }

            @Override
            public void onFinish() {
                playAgain.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your Score: "+ Integer.toString(score)+ "/"+ Integer.toString(numberOfQuestions));

            }
        }.start();

    }

    public void generateQuestion(){
        Random random = new Random();
        int a = random.nextInt(50);
        int b = random.nextInt(50);
        sumTextView.setText(Integer.toString(a)+ " + "+ Integer.toString(b));

        locationOfCorrectAnswers = random.nextInt(4);
        // clears the answers and generate a new one
        answers.clear();
        int incorrectAnswer;
        for (int i = 0; i < 4; i++){
            if (i == locationOfCorrectAnswers){
                answers.add(a+b);
            }else {
                incorrectAnswer = random.nextInt(100);
                while (incorrectAnswer == a + b){
                    incorrectAnswer = random.nextInt(100);
                }
                answers.add(incorrectAnswer);
            }

        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public void chooseAns(View view){
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswers))){
            score = score +1;
            resultTextView.setText("Correct!");

        }else {
            resultTextView.setText("Wrong!");
        }
        numberOfQuestions++;
        pointTextView.setText(Integer.toString(score)+ "/"+ Integer.toString(numberOfQuestions));
        generateQuestion();

    }
    public void startButton(View view){
        startButton.setVisibility(View.INVISIBLE);
        gameRelativeLayout.setVisibility(RelativeLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
         button0 = (Button) findViewById(R.id.button0);
         button1 = (Button) findViewById(R.id.button1);
         button2 = (Button) findViewById(R.id.button2);
         button3 = (Button) findViewById(R.id.button3);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        pointTextView = (TextView) findViewById(R.id.pointTextView);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        playAgain = (Button)findViewById(R.id.playAgainButton);
        gameRelativeLayout = (RelativeLayout)findViewById(R.id.gameRelativeLayout);



        sumTextView = (TextView) findViewById(R.id.sumTextView);

    }
}
