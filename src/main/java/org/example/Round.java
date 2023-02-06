package org.example;

import java.util.ArrayList;

public class Round {

    private Deck deck;
    private ArrayList<Player> players;
    private ArrayList<Card> cardsInPlay;

    public Round(ArrayList<Player> playersIn){

        deck = new Deck();
        cardsInPlay = new ArrayList<>(deck.dealCards(4));
        this.players = playersIn;
        dealToPlayers();

    }

    public void dealToPlayers(){for(Player player: players){player.takeCards(deck.dealCards(3));}}

    public int[] play(){

        for (Player player: players) {


            player.makeChoice(cardsInPlay);



        }

        return null;
    }




}
