package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

    private ArrayList<Card> hand;
    private ArrayList<Card> cardsTaken;

    public Player(ArrayList<Card> dealtCards){
        hand = new ArrayList<>();
        takeCards(dealtCards);
        cardsTaken = new ArrayList<>();
    }
    public void takeCards(ArrayList<Card> dealtCards){hand.addAll(dealtCards);}

    public HashMap<String, ArrayList<Card>> makeChoice(ArrayList<Card> inPlay){

        HashMap<String, ArrayList<Card>> returnChoices = new HashMap<>();

        //chose random card to place
        int randomNum = ThreadLocalRandom.current().nextInt(0, hand.size());
        Card choice = hand.get(randomNum);

        returnChoices.put("placedCard", new ArrayList<>(Arrays.asList()));


        cardsTaken.add(choice);
        hand.remove(randomNum);


        return returnChoices;

    }

    private void calcMatches(ArrayList<Card> inPlay, Card choice) {

        int choiceInt = choice.getNum();
        ArrayList<Integer> nums = new ArrayList<>();
        for (Card card : inPlay) {
            int x = card.getNum();
            if (x <= choiceInt) {nums.add(x);}
        }
        nums.sort(null);

        for(int comboSize = 1; comboSize < nums.size(); comboSize++){

            for(int x:nums){
                int sum = 0;
                ArrayList<Integer> combo = new ArrayList<>();

                for(int i = 0; i < comboSize; i++) {
                    sum += nums.get(i);
                    combo.add(nums.get(i));
                }

                if(sum == choiceInt){ }
            }

        }





    }



}
