package com.example.p23ya.mtgcounter;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;


public class MTG_Counter extends AppCompatActivity {
    //Health starts at 20
    private  int playerOneHP=20;
    private  int playerTwoHP=20;
    //Declaring the textviews
    private  TextView playerOneHPTextView;
    private  TextView playerTwoHPTextView;
    //Dialog for the popup color window
    // Dialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtg__counter);



        //Finds and stores player one and two hp text views

        this.playerOneHPTextView = (TextView) findViewById(R.id.player_one_hp_textview);
        this.playerTwoHPTextView= (TextView) findViewById(R.id.player_two_hp_textview);



        //Configure the toolbar
        addToolbar();

        //Configure the plus and minus buttons.
        addButtons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        //If the button clicked was the reset button, reset players HP
        if (id == R.id.reset_HP_button) {

            resetHP();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void  addToolbar(){
        //Finds the toolbar and sets it as a replacement for the action bar
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }





    protected void addButtons(){


        //Finds the button for the player one color picker
        ImageView color_picker_player_one = (ImageView) findViewById(R.id.player_one_color_button);

        color_picker_player_one.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                return; //TODO
            }
        });



        //Finds the button for  the player two color picker
        ImageView color_picker_player_two = (ImageView) findViewById(R.id.player_two_color_button);

        color_picker_player_two.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MTG_Counter.this);

                View mView = getLayoutInflater().inflate(R.layout.color_popup_two,null);

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();

                Window window = dialog.getWindow();
                window.setGravity(Gravity.BOTTOM);

                window.setLayout(CoordinatorLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }


        });



        ImageView resetHP = (ImageView) findViewById(R.id.resetHP_button);
        resetHP.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Reset players HP
                resetHP();

            }
        });


        Button playerOneMinusButton = (Button) findViewById(R.id.player_one_minus_button);
        //Set click listener for minus button
        playerOneMinusButton.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Lowers player HP on click
                lowerHP(playerOneHP, playerOneHPTextView);

            }
        });

        //Finds the plus button for player one
        Button playerOnePlusButton = (Button) findViewById(R.id.player_one_plus_button);
        //Set click listener for minus button
        playerOnePlusButton.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Increases player HP on click
                increaseHP(playerOneHP, playerOneHPTextView);

            }
        }

        );

        //Finds the minus button for player two
        Button playerTwoMinusButton = (Button) findViewById(R.id.player_two_minus_button);
        //Set click listener for minus button
        playerTwoMinusButton.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Lowers player HP on click
                lowerHP(playerTwoHP, playerTwoHPTextView);

            }
        });

        //Finds the plus button for player two
        Button playerTwoPlusButton = (Button) findViewById(R.id.player_two_plus_button);
        //Set click listener for minus button
        playerTwoPlusButton.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //Increases player HP on click
                increaseHP(playerTwoHP, playerTwoHPTextView);

            }
        }

        );

    }






    //Function that lowers player HP and displays it on screen
    protected void lowerHP(int playerHP, TextView playerView){

        playerHP--;


        //Changes the textview
        displayHP(playerHP,playerView);

        //Changes the outside variable accordingly to what textview is being changed
        if(playerView.getId() == R.id.player_one_hp_textview){
            this.playerOneHP = playerHP;
        }
        else{
            this.playerTwoHP = playerHP;
        }

    }

    //Function increases player HP and displays it on screen
    protected void increaseHP(int playerHP, TextView playerView){

        if(playerHP < 2147483647 ) {
            playerHP++;
        }


        //Changes the textview
        displayHP(playerHP,playerView);


        //Changes the outside variable accordingly to what textview is being changed
        if(playerView.getId() == R.id.player_one_hp_textview){
            this.playerOneHP = playerHP;
        }
        else{
            this.playerTwoHP = playerHP;
        }


    }

    //Given a HP value and a textview, alters that textview to display the value
    protected void displayHP( int playerHP, TextView playerView){
        //Gets the resetHP button
        ImageView resetHPButton = (ImageView) findViewById(R.id.resetHP_button);

        //If a player HP goes 0 or lower, it becomes red. A reset button shows up
        if(playerHP <= 0 ) {
            playerView.setTextColor(getResources().getColor(R.color.darkerRed, getResources().newTheme()));

            //Shows reset hp button

            resetHPButton.setVisibility(View.VISIBLE);
        }
        else{
            //If player HP is higher then 0, it is white.
            playerView.setTextColor(getResources().getColor(R.color.colorBlack, getResources().newTheme()));

        }

        playerView.setText(Integer.toString(playerHP));
    }

    //Resets to 20 and displays both players HP
    protected void resetHP(){

        this.playerOneHP = 20;
        this.playerTwoHP=20;


        displayHP(playerOneHP,playerOneHPTextView);
        displayHP(playerTwoHP,playerTwoHPTextView);


        //Gets the resetHP button
        ImageView resetHPButton = (ImageView) findViewById(R.id.resetHP_button);
        resetHPButton.setVisibility(View.GONE);
    }
}
