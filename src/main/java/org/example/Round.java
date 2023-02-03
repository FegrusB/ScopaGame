package org.example;

import java.util.ArrayList;

public class Round {

    private Deck deck;
    private ArrayList<Player> players;
    private ArrayList<Card> cardsInPlay;

    public Round(int playNum){

        deck = new Deck();
        cardsInPlay = new ArrayList<>(deck.dealCards(4));
        players = new ArrayList<>();
        for(int i = 0;i<playNum;i++){players.add(new Player(deck.dealCards(3)));}

    }

    public int[] play(){

        for (Player player: players) {
            player.makeChoice(cardsInPlay);
        }
        return null;
    }




}
