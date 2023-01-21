package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Card[] deck = setUp();
        System.out.println();
    }

    public static Card[] setUp(){

        Card[] deck = new Card[40];

        int count = 0;

        for (int s = 0; s < 4; s++) {
            for (int n = 1; n < 11; n++) {
                deck[count] = new Card(n,s);
                count++;
            }
        }
        deck = shuffle(deck);
        return deck;
    }
    public static Card[] shuffle(Card[] deck){

        Random rand = new Random();

        for(int i = 0;i<40;i++){

            int r = i + rand.nextInt(40-i);

            Card temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        return deck;
    }
}