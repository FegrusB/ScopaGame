package org.example;

import java.util.ArrayList;
import java.util.Random;
public class Deck {

    private ArrayList<Card> deck;

    public Deck(){

        deck = new ArrayList<Card>();
        setUp();
        printCards();
    }
    public void setUp(){

        int count = 0;

        for (int s = 0; s < 4; s++) {
            for (int n = 1; n < 11; n++) {
                deck.add(new Card(n,s));
            }
        }
        shuffle();
    }
    public void shuffle(){

        Random rand = new Random();

        for(int i = 0;i<40;i++){

            int r = i + rand.nextInt(40-i);

            Card temp = deck.get(r);
            deck.set( r ,deck.get(i));
            deck.set(i,temp);
        }
    }
    public ArrayList<Card> dealCards(int num){

        ArrayList<Card> out = new ArrayList<>();

        for(int i = 0; i<num;i++){
            if (deck.isEmpty()){break;}
            out.add(deck.get(0));
            deck.remove(0);
        }
        return out;
    }
    public void printCards(){
        for (Card card: deck) {
            System.out.println(card.toString());
        }
    }


}
