package org.example;

import static java.lang.Math.abs;

public class GameManager {

    int[] scores;
    int playNum;
    public GameManager(int playNum){

        this.playNum = playNum;
        scores = new int[2];

    }

    public void play(){

        boolean[] checkScores = new boolean[2];

        while(!checkScores[0]){
            Round round = new Round(playNum);
            int[] scoresDiff = round.play() ;
            scores[0] = scoresDiff[0];
            scores[1] = scoresDiff[1];
            checkScores = checkScores();
        }

    }

    private boolean[] checkScores(){
        //check scores for a won game. booleans[0] = game won/not-won. booleans[1] = player 1/2 win.

        boolean[] booleans = new boolean[2];

        int dif = scores[0] - scores[1];

        //if both scores are 11+ one must be more than two ahead to win.
        if( (scores[0] > 11 && scores[1] > 11) && abs(dif) > 2 ){

            booleans[0] = true;
            if(dif < 0){booleans[1] = true;}

        } else if(scores[0] > 11){

            booleans[0] = true;

        } else if (scores[1] > 11) {

            booleans[0] = true;
            booleans[1] = true;

        }

        return booleans;

    }


}
