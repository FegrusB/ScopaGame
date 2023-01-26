package org.example;

import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;

    public Player(ArrayList<Card> dealtCards){
        hand = new ArrayList<>();
        hand.addAll(dealtCards);
    }
    public void takeCards(ArrayList<Card> dealtCards){hand.addAll(dealtCards);}

}
