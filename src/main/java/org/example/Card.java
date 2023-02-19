package org.example;

public class Card implements Comparable<Card> {

    private final int num;
    private final String suit;

    public Card(int num,int suit) {

        String suitInit = null;
        this.num = num;

        switch (suit) {
            case 0 -> suitInit = "Swords";
            case 1 -> suitInit = "Clubs";
            case 2 -> suitInit = "Cups";
            case 3 -> suitInit = "Golds";
        }
        this.suit = suitInit;

    }
    public int getNum(){return num;}
    @Override
    public String toString(){
        return num +","+ suit;
    }


    @Override
    public int compareTo(Card c) {return this.num - c.getNum();}
}
