package org.example;

import java.util.ArrayList;

public class GameManager {

    private Deck deck;
    private ArrayList<Player> players;
    private ArrayList<Card> cardsInPlay;
    public GameManager(int playNum){

        deck = new Deck();
        cardsInPlay = new ArrayList<>(deck.dealCards(4));
        players = new ArrayList<>();
        for(int i = 0;i<playNum;i++){players.add(new Player(deck.dealCards(3)));}

    }


}
