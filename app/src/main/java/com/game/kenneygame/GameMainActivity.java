package com.game.kenneygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameMainActivity extends AppCompatActivity {


    TextView timeText;
    TextView scoreText;



    ImageView imageView1,imageView2 ,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12;


    Handler handler;
    Runnable runnable;

    int score=0;
    int sure=380;
    int time=0;
    ImageView[] imageViewsArrays;

    String character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);



         imageView1 = (ImageView) findViewById(R.id.imageView);
         imageView2 = (ImageView) findViewById(R.id.imageView2);
         imageView3 = (ImageView) findViewById(R.id.imageView3);
         imageView4 = (ImageView) findViewById(R.id.imageView4);
         imageView5 = (ImageView) findViewById(R.id.imageView5);
         imageView6 = (ImageView) findViewById(R.id.imageView6);
         imageView7 = (ImageView) findViewById(R.id.imageView7);
         imageView8 = (ImageView) findViewById(R.id.imageView8);
         imageView9 = (ImageView) findViewById(R.id.imageView9);
         imageView10 = (ImageView) findViewById(R.id.imageView10);
         imageView11 = (ImageView) findViewById(R.id.imageView11);
         imageView12 = (ImageView) findViewById(R.id.imageView12);

        imageViewsArrays=new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12};


        //get data
        Intent intent = getIntent();
        character=intent.getStringExtra("character");
        System.out.println("character:"+character);


        if (character.equals("BUBU")) {

            for(ImageView imageView:imageViewsArrays)
            {

                imageView.setImageResource(R.drawable.bubu);


            }


        }
        else if (character.equals("DUDU")) {

            for(ImageView imageView:imageViewsArrays)
            {

                imageView.setImageResource(R.drawable.dudu);


            }

        }

        timeText=(TextView)findViewById(R.id.textViewTime);
        scoreText=(TextView)findViewById(R.id.textViewScore);
        score=0;


        hideImages();

        new CountDownTimer(20000,1000)
        {


            @Override
            public void onTick(long millisUntilFinished) {
                time= (int) (millisUntilFinished/1000);

                if(time==6)
                {
                    Log.e("Time"," Time 340 set");
                    sure=340;
                }
                else
                {

                }
                timeText.setText("TIME:"+time);

            }

            @Override
            public void onFinish() {

                handler.removeCallbacks(runnable);
                // Tüm ImageView'leri gizle
                for (ImageView imageView : imageViewsArrays) {
                    imageView.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(GameMainActivity.this);
                alertDialog.setTitle("Restart!");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("Button","The game is repeated");


                        Intent intent1=getIntent();
                        finish();
                        startActivity(intent1);

                    }
                });

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("Button","exiting the game");
                    }
                });

                alertDialog.show();

            }
        }.start();



    }
    public  void increaseScore(View view)
    {
        if(time !=0)
        {
            score++;
            scoreText.setText("SCORE:"+score);
        }
        else
        {
            timeText.setText("Time OFF");
        }



    }

    public void hideImages() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                //Hide all ImageViews
                for (ImageView imageView : imageViewsArrays) {
                    imageView.setVisibility(View.INVISIBLE);
                }

                //Make a random ImageView visible
                Random random = new Random();
                int i = random.nextInt(12);
                imageViewsArrays[i].setVisibility(View.VISIBLE);

                // Call again after a certain period of time
                handler.postDelayed(this, sure);


            }
        };

        //First run
        handler.post(runnable);
    }

}