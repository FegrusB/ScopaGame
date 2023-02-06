package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class GameManager {

    int[] scores;

    private ArrayList<Player> players;
    int playNum;
    public GameManager(int playNum){

        this.playNum = playNum;
        scores = new int[2];
        players = new ArrayList<>();

    }

    public void play(){

        boolean gameWon = false;

        //Create new round, play round and update scores. Check scores and loop if not won.
        while(!gameWon){

            Round round = new Round(players);
            int[] scoresDiff = round.play() ;

            scores[0] += scoresDiff[0];
            scores[1] += scoresDiff[1];

            Map<String, Boolean> checkScores = checkScores();
            gameWon = checkScores.get(gameWon);

        }

    }

    private Map<String, Boolean> checkScores(){
        //check scores for a won game.  = game won/not-won. booleans[1] = player 1/2 win.

        Map<String, Boolean> returns = new HashMap<>();
        returns.put("gameWon",false);
        returns.put("winner",false);

        int dif = scores[0] - scores[1];

        //An 11+ score is a win. If both scores are 11+ one must be more than two ahead to win.
        if( (scores[0] > 11 && scores[1] > 11) && abs(dif) > 2 ){

            returns.put("gameWon", true);
            if(dif < 0){returns.put("winner",true);}

        } else if(scores[0] > 11){

            returns.put("gameWon",true);

        } else if (scores[1] > 11) {

            returns.put("gameWon",true);
            returns.put("winner",true);

        }
        return returns;
    }


}
