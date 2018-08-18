package com.example.dennis.timer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button controllerButton;
    CountDownTimer countDownTimer;

    TextView timerTextView;
    SeekBar seekBar;
    boolean counterIsActive =false;
    public void resetTimer(){
        timerTextView.setText("0:30");
        seekBar.setProgress(30);
        countDownTimer.cancel();
        controllerButton.setText("Go!");
        seekBar.setEnabled(true);
        counterIsActive = false;
    }

    public void updateTimer(int secondsLeft){
        int minute = (int)secondsLeft / 60;
        int seconds = secondsLeft - minute * 60;
        //setting the seconds from 0:0 to 0:00;
        String secondSecond = Integer.toString(seconds);
        if (seconds <= 9){
            secondSecond = "0" +secondSecond;
        }
        //Setting the Minute from 0:00 to 00:00
        String secondMinute = Integer.toString(minute);
        if (minute == 0){
            secondMinute = "00";
        }
        timerTextView.setText(secondMinute+":"+(secondSecond));
    }

    public void controlTimer(View view){

        if (counterIsActive == false) {
            counterIsActive = true;
            seekBar.setEnabled(false);
            controllerButton.setText("Stop");
           countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {
                    resetTimer();
                    MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bellsound);
                    mPlayer.start();


                }
            }.start();

        }else {
            resetTimer();
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controllerButton = (Button)findViewById(R.id.controolerButton);


        timerTextView= (TextView)findViewById(R.id.TimerTextView);
         seekBar= (SeekBar)findViewById(R.id.timerSeekBar);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
