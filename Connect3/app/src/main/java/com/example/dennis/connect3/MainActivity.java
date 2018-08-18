package com.example.dennis.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameIsActive = true;
    // 0 = green, 1 = yellow;
    int activePlayer = 0;
    // 2 means unplayed;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPoaition = {{0,1,2},{5,4,3},{6,7,8},{0,5,8},{1,4,7},{2,3,6},{0,4,6},{2,4,8}};

    public void dropIn(View view){
        ImageView imageView = (ImageView)view;

        int tappCounter = Integer.parseInt(imageView.getTag().toString());
        if (gameState[tappCounter]  == 2 && gameIsActive) {
            gameState[tappCounter] = activePlayer;
            imageView.setTranslationY(-1000f);
            if (activePlayer == 0) {
                imageView.setImageResource(R.drawable.green);
                activePlayer = 1;

            } else {
                imageView.setImageResource(R.drawable.yellow);
                activePlayer = 0;
            }
            imageView.animate().translationYBy(1000f).rotation(350).setDuration(300);
            for (int[] winningPositions: winningPoaition){
                if (gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState
                        [winningPositions[2]] && gameState[winningPositions[0]] != 2){
                    gameIsActive = false;
                    String winner = "yellow";
                    if(gameState[winningPositions[0]] == 0){
                        winner = "green";

                    }
                    //some on hax won!
                    TextView winnerMessage = (TextView)findViewById(R.id.winningMessage);
                    winnerMessage.setText(winner + " has won");
                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                    layout.setVisibility(view.VISIBLE);

                }else {
                    boolean gameIsOver = true;
                    for (int counterState: gameState){
                        if (counterState == 2)gameIsOver = false;
                    }
                    if (gameIsOver){
                        TextView winnerMessage = (TextView)findViewById(R.id.winningMessage);
                        winnerMessage.setText(" It's a draw");
                        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                        layout.setVisibility(view.VISIBLE);

                    }
                }

            }
        }

    }
    public void playAgain(View v){
        gameIsActive = true;

        LinearLayout linearlayout = (LinearLayout)findViewById(R.id.playAgainLayout);
        linearlayout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++){
            gameState[i] =2;
        }
        GridLayout gridlayout = (GridLayout)findViewById(R.id.gridLayout);
        for (int i = 0; i < gridlayout.getChildCount(); i++){
            ((ImageView)gridlayout.getChildAt(i)).setImageResource(0);
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
