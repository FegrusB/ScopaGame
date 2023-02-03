package org.example;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

    private ArrayList<Card> hand;
    private int score;
    private ArrayList<Card> cardsTaken;

    public Player(ArrayList<Card> dealtCards){
        this.score = 0;
        hand = new ArrayList<>();
        hand.addAll(dealtCards);
        cardsTaken = new ArrayList<>();
    }
    public void takeCards(ArrayList<Card> dealtCards){hand.addAll(dealtCards);}

    public Card makeChoice(ArrayList<Card> inPlay){
        int randomNum = ThreadLocalRandom.current().nextInt(0, hand.size());
        Card choice = hand.get(randomNum);
        cardsTaken.add(choice);
        hand.remove(randomNum);
        return choice;
    }

    public int getScore() {return score;}
}
