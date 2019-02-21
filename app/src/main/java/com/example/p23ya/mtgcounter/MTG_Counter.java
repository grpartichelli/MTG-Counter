package com.example.p23ya.mtgcounter;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
    //Declaring background image views
    private ImageView playerOneBackground;
    private ImageView playerTwoBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtg__counter);

        //Finds and stores the players background image views
        this.playerOneBackground = (ImageView) findViewById(R.id.player_one_background);
        this.playerTwoBackground = (ImageView) findViewById(R.id.player_two_background);

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
                displayPlayerOneColorPicker();
            }
        });



        //Finds the button for  the player two color picker
        ImageView color_picker_player_two = (ImageView) findViewById(R.id.player_two_color_button);

        color_picker_player_two.setOnClickListener(new View.OnClickListener() {
            //When the button is pressed:
            public void onClick(View v) {
                //When pressed, display player two color picker
                displayPlayerTwoColorPicker();

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
        });

    }


    //Function shows the color picker buttons.
    protected void displayPlayerOneColorPicker(){
        //Create alert builder
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MTG_Counter.this);
        //Inflate the view that will be displayed
        View mView = getLayoutInflater().inflate(R.layout.color_popup_one,null);
        //Setup the builder and creates the alert
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();

        //Setups the display window to be at the bottom and transparent
        Window window = dialog.getWindow();
        window.setGravity(Gravity.TOP);
        window.setLayout(CoordinatorLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        //Finds the color picker white button
        final Button whiteButton =  (Button) mView.findViewById(R.id.player_one_color_white);

        whiteButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to white
                setBackgroundColor(whiteButton,playerOneBackground);
            }

        });

        final Button blackButton =  (Button) mView.findViewById(R.id.player_one_color_black);
        blackButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to black
                setBackgroundColor(blackButton,playerOneBackground);
            }

        });

        final Button blueButton  =  (Button)  mView.findViewById(R.id.player_one_color_blue);
        blueButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to blue
                setBackgroundColor(blueButton,playerOneBackground);
            }

        });
        final Button greenButton =  (Button) mView.findViewById(R.id.player_one_color_green);
        greenButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to green
                setBackgroundColor(greenButton,playerOneBackground);
            }

        });
        final Button redButton   =  (Button) mView.findViewById(R.id.player_one_color_red);

        redButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to red
                setBackgroundColor(redButton,playerOneBackground);
            }

        });

        //Displays the color picker
        dialog.show();
    }



    //Function shows the color picker buttons.
    protected void displayPlayerTwoColorPicker(){
        //Create alert builder
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MTG_Counter.this);
        //Inflate the view that will be displayed
        View mView = getLayoutInflater().inflate(R.layout.color_popup_two,null);
        //Setup the builder and creates the alert
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();

        //Setups the display window to be at the bottom and transparent
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(CoordinatorLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        //Finds the color picker white button
        final Button whiteButton =  (Button) mView.findViewById(R.id.player_two_color_white);

        whiteButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                    //Sets the background color to white
                    setBackgroundColor(whiteButton,playerTwoBackground);
            }

        });

        final Button blackButton =  (Button) mView.findViewById(R.id.player_two_color_black);
        blackButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to black
                setBackgroundColor(blackButton,playerTwoBackground);
            }

        });

        final Button blueButton  =  (Button)  mView.findViewById(R.id.player_two_color_blue);
        blueButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to blue
                setBackgroundColor(blueButton,playerTwoBackground);
            }

        });
        final Button greenButton =  (Button) mView.findViewById(R.id.player_two_color_green);
        greenButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to green
                setBackgroundColor(greenButton,playerTwoBackground);
            }

        });
        final Button redButton   =  (Button) mView.findViewById(R.id.player_two_color_red);

        redButton.setOnClickListener(new View.OnClickListener(){

            //When the button is pressed:
            public void onClick(View v) {
                //Sets the background color to red
                setBackgroundColor(redButton,playerTwoBackground);
            }

        });

        //Displays the color picker
        dialog.show();
    }


    //Give a button and an image view , changes the background color of
    //the image view to the background color of the button.
    protected void setBackgroundColor(Button button, ImageView background){
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        background.setBackgroundColor(buttonColor.getColor());
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
