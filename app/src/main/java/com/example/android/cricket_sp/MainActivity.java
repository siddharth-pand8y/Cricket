package com.example.android.cricket_sp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v7.app.ActionBar;


public class MainActivity extends AppCompatActivity {



    int totalscoreA=0;int wicketsA=0;
    int currentscoreA=0;
    int ballsA=0; int biaoA=0; int nooA=0;
    String overA=nooA+"."+ballsA;
    String totalscoreAC="";

    String oversAA="";
    int totalscoreB=0; int wicketsB=0;
    int currentscoreB=0;
    int ballsB=0; int biaoB=0; int nooB=0;
    String overB=nooB+"."+ballsB;
    String totalscoreBC="";
    boolean outB=false;
    String oversBB="";

    String recentrun="";
    boolean out=false;
    boolean outt=false;
    String finalresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //-----------------------------------------------------------------------
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(String score, String over, String last) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

        TextView overView = (TextView) findViewById(R.id.team_a_over);
        overView.setText(String.valueOf(over));

        TextView runView = (TextView) findViewById(R.id.team_a_run);
        runView.setText(String.valueOf(last));
    }

    public void displayForTeamB(String score, String over, String last) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));

        TextView overView = (TextView) findViewById(R.id.team_b_over);
        overView.setText(String.valueOf(over));

        TextView runView = (TextView) findViewById(R.id.team_a_run);
        runView.setText(String.valueOf(last));
    }

    public boolean wwick()
    {
        switch ((int) ((Math.random() * 6) + 1)) {
            case 1:
                outt = false;
            break;
            case 2:
                outt = false;
            break;
            case 3:
                outt = false;
            break;
            case 4:
                outt = false;
            break;
            case 5:
                outt = false;
            break;
            case 6:
                outt = true;

            break;
        }
        return outt;
    }
    public void NextBall(View view)
    {

        ImageButton Lview=(ImageButton) findViewById(R.id.score_one);
        Lview.setImageResource(R.drawable.s2);

        TextView lastView3 = (TextView) findViewById(R.id.last_ball_text_view);
        lastView3.setText(String.valueOf("Runs scored on the last ball"));


        if (ballsA < 12) {
            currentscoreA = 0;
            ballsA++;
            int rnddecisio = (int) ((Math.random() * (6 - 1 + 1)) + 1);
            switch (rnddecisio) {
                case 1:
                    currentscoreA = 6;
                    break;
                case 2:
                    currentscoreA = 4;
                    break;
                case 3:
                    currentscoreA = 3;
                    out=wwick();
                    break;
                case 4:
                    currentscoreA = 2;
                    out=wwick();
                    break;
                case 5:
                    currentscoreA = 1;
                    out=wwick();
                    break;
                case 6:
                    currentscoreA = 0;
                    out=wwick();

                    break;
            }

            if (out == true) {
                wicketsA++;
                out = false;
            }
            totalscoreA += currentscoreA;
            biaoA = ballsA % 6;
            nooA = ballsA / 6;
            oversAA = nooA + "." + biaoA;
            recentrun = currentscoreA + " runs";
            totalscoreAC = totalscoreA + "/" + wicketsA;

            displayForTeamA(totalscoreAC, oversAA, recentrun);


        }
        if(ballsA>=12 && ballsB<12 && totalscoreB<=totalscoreA)
        {
            currentscoreB = 0;
            ballsB++;
            int rnddecisioB = (int) ((Math.random() * (6 - 1 + 1)) + 1);
            switch (rnddecisioB) {
                case 1:
                    currentscoreB = 6;
                    break;
                case 2:
                    currentscoreB = 4;
                    break;
                case 3:
                    currentscoreB = 3;
                    out=wwick();
                    break;
                case 4:
                    currentscoreB = 2;
                    out=wwick();
                    break;
                case 5:
                    currentscoreB = 1;
                    out=wwick();
                    break;
                case 6:
                    currentscoreB = 0;
                    out=wwick();
                    break;
            }

            if (out == true) {
                wicketsB++;
                out = false;
            }
            totalscoreB += currentscoreB;
            biaoB = ballsB % 6;
            nooB = ballsB / 6;
            oversBB = nooB + "." + biaoB;
            recentrun = currentscoreB + " runs";
            totalscoreBC = totalscoreB + "/" + wicketsB;

            displayForTeamB(totalscoreBC, oversBB, recentrun);
        }

        if(ballsB==12 || totalscoreB>totalscoreA)
        {
            String finalresult;
            if(totalscoreB>totalscoreA) finalresult="Kings XI Punjab won the match";
            else if(totalscoreA>totalscoreB) finalresult="Kolkata Knight Riders won the match";
            else finalresult="The match is a tie";
            TextView lastView = (TextView) findViewById(R.id.last_ball_text_view);
            lastView.setText(String.valueOf(finalresult));

            ImageButton Lview2=(ImageButton) findViewById(R.id.score_one);
            Lview2.setImageResource(R.drawable.s3);

            TextView runView7 = (TextView) findViewById(R.id.team_a_run);
            runView7.setText(String.valueOf(""));
        }
    }
//------------------------------------------------------------------------------

        public void resett(View view)
        {
            finalresult="Click the start button to play";
            TextView lastView2 = (TextView) findViewById(R.id.last_ball_text_view);
            lastView2.setText(String.valueOf(finalresult));

            ImageButton Lview=(ImageButton) findViewById(R.id.score_one);
            Lview.setImageResource(R.drawable.ss);

            ballsA=0;
            totalscoreA=0;
            //totalscoreAC="";
            oversAA="";
            recentrun="";
            nooA=0;
            biaoA=0;
            wicketsA=0;

            displayForTeamA("0/0", oversAA,recentrun);

            ballsB=0;
            totalscoreB=0;
            //totalscoreBC="";
            oversBB="";
            recentrun="";
            nooB=0;
            biaoB=0;
            wicketsB=0;

            displayForTeamB("0/0", oversBB,recentrun);

        }
    }
