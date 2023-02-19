package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        returnChoices.put("placedCard", new ArrayList<>(List.of(new Card[]{choice})));



        hand.remove(randomNum);

        ArrayList<Card> match = calcMatches(inPlay,choice);

        returnChoices.put("takenCards", match);
        if(!(match.isEmpty())){ cardsTaken.add(choice);cardsTaken.addAll(match);}

        return returnChoices;

    }

    /** Build array of cards that can be taken with a given choice. List must be the shortest possible. Eg with 7, 6, 1 in play, a choice of 7 must take the 7
     * @param inPlay an ArrayList of the cards currently on the table
     * @param  choice the card to check for matches against.
     * @return an arrayList of the cards that can be taken with the given card
     **/
    private ArrayList<Card> calcMatches(ArrayList<Card> inPlay, Card choice) {

        if (inPlay.size() < 1){return new ArrayList<>();}

        //build array of cards that could be taken. Then sort.
        int choiceInt = choice.getNum();
        ArrayList<Card> nums = new ArrayList<>();
        for (Card card : inPlay) {if (card.getNum() <= choiceInt) {nums.add(card);}}
        nums.sort(null);
        ArrayList<ArrayList<Card>> combos = new ArrayList<>();

        //check cards in play. If there are any single matches pick a random one and return.
        boolean singleMatch = false;
        for (Card c:nums){if (c.getNum() == choiceInt){combos.add(new ArrayList<>(List.of(new Card[]{c})));singleMatch = true;}}
        if (singleMatch){
            int randomNum = ThreadLocalRandom.current().nextInt(0, combos.size());
            return combos.get(randomNum);
        }

    }



}
