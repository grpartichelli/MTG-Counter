package com.example.p23ya.mtgcounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MTG_Counter extends AppCompatActivity {
    //Health starts at 20
    private int playerOneHP=20;
    private int playerTwoHP=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtg__counter);

        //Configure the plus and minus buttons.
        addButtons();
    }


    protected void addButtons(){

        //Finds the minus button for player one
        Button playerOneMinusButton = (Button) findViewById(R.id.player_one_minus_button);
        //Set click listerner for minus button
        playerOneMinusButton.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Lowers player HP on click
                TextView playerOneHPTextView= (TextView) findViewById(R.id.player_one_hp_textview);
                lowerHP(playerOneHP, playerOneHPTextView);

            }
        });

        //Finds the plus button for player one
        Button playerOnePlusButton = (Button) findViewById(R.id.player_one_plus_button);
        //Set click listerner for minus button
        playerOnePlusButton.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Increases player HP on click
                TextView playerOneHPTextView= (TextView) findViewById(R.id.player_one_hp_textview);
                increaseHP(playerOneHP, playerOneHPTextView);

            }
        }

        );

        //Finds the minus button for player two
        Button playerTwoMinusButton = (Button) findViewById(R.id.player_two_minus_button);
        //Set click listerner for minus button
        playerTwoMinusButton.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Lowers player HP on click
                TextView playerTwoHPTextView= (TextView) findViewById(R.id.player_two_hp_textview);
                lowerHP(playerTwoHP, playerTwoHPTextView);

            }
        });

        //Finds the plus button for player two
        Button playerTwoPlusButton = (Button) findViewById(R.id.player_two_plus_button);
        //Set click listerner for minus button
        playerTwoPlusButton.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Increases player HP on click
                TextView playerTwoHPTextView= (TextView) findViewById(R.id.player_two_hp_textview);
                increaseHP(playerTwoHP, playerTwoHPTextView);

            }
        }

        );

    }

    //Function that lowers player HP and displays it on screen
    public void lowerHP(int playerHP, TextView playerView){

        playerHP--;

        //If a player HP goes 0 or lower, it becomes red.
        if(playerHP <= 0 ) {
            playerView.setTextColor(Color.RED);
        }



        //Changes the textview
        playerView.setText(Integer.toString(playerHP));

        //Changes the outside variable accordingly to what textview is being changed
        if(playerView == ((TextView) findViewById(R.id.player_one_hp_textview))){
            this.playerOneHP = playerHP;
        }
        else{
            this.playerTwoHP = playerHP;
        }

    }

    //Function increases player HP and displays it on screen
    public void increaseHP(int playerHP, TextView playerView){



        if(playerHP < 2147483647 ) {
            playerHP++;
        }

        //If player HP is higher then 0, it is white.
        if(playerHP > 0 ){
            playerView.setTextColor(Color.parseColor("#ece7e7"));
        }


        //Changes the textview
        playerView.setText(Integer.toString(playerHP));


        //Changes the outside variable accordingly to what textview is being changed
        if(playerView == ((TextView) findViewById(R.id.player_one_hp_textview))){
            this.playerOneHP = playerHP;
        }
        else{
            this.playerTwoHP = playerHP;
        }


    }


}
