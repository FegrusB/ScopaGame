package org.example;

import java.util.ArrayList;
import java.util.Random;
public class Deck {

    private ArrayList<Card> deck;

    public Deck(){

        deck = new ArrayList<Card>();
        setUp(deck);
    }
    public void setUp(ArrayList<Card> deck){

        int count = 0;

        for (int s = 0; s < 4; s++) {
            for (int n = 1; n < 11; n++) {
                deck.add(new Card(n,s));
            }
        }
        shuffle(deck);
    }
    public void shuffle(ArrayList<Card> deck){

        Random rand = new Random();

        for(int i = 0;i<40;i++){

            int r = i + rand.nextInt(40-i);

            Card temp = deck.get(r);
            deck.set( r ,deck.get(i));
            deck.set(i,temp);
        }
    }


}
