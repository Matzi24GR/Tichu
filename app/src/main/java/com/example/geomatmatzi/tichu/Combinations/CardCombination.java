package com.example.geomatmatzi.tichu.Combinations;

import com.example.geomatmatzi.tichu.Cards.Card;
import com.example.geomatmatzi.tichu.Cards.Mahjong;
import com.example.geomatmatzi.tichu.Cards.Phoenix;

import java.util.ArrayList;


public abstract class CardCombination {
    
    
    private ArrayList<Card> Collection;
    /**
     * Constructor
     */
    public CardCombination(ArrayList<Card> tmp){
        this.Collection = tmp;
    }
    public CardCombination(){
        this.Collection = new ArrayList<Card>();
    }
    
    /**
     * accessor
     * Epistrefei thn megisth dinamh tou set etsi wste na ginei elegxos oti
     * oi epomenes cards 8a einai megaluteres apo ayth
     * @return float
     */
    public abstract boolean ispowerOfSetGreaterThan(CardCombination other);
    
    /**
     * accessors
     * Elegxei an o tupos tou CardCombination einai Bomb
     * @return boolean
     */
    public abstract boolean isBomb();
    
    /**
     * accessors
     * Epistrefei to mege8os tou set px 5 gia kenda mege8ous 5
     * Etsi wste na kseroume to mege8os pou prepei na exoun kai oi upoloipes
     * @return int
     */
    public int sizeOfSet(){
        return this.Collection.size();
    }
    
    public ArrayList<Card> getCards(){
        return this.Collection;
    }
    public void setCards(ArrayList<Card> tmp){
        this.Collection = tmp;
    }
    public boolean HasMajong(){
        for(Card tmp : this.Collection){
            if(tmp instanceof Mahjong){
                return true;
            }
            
        }
        return false;
    }
    public boolean HasPhoenix(){
        for(Card tmp: this.Collection){
            if(tmp instanceof Phoenix){
                return true;
            }
        }
        return false;
    }
    
    public boolean hasCardWithValue(int val){
        for(Card tmp : this.getCards()){
            if(tmp.getValue() == val)
                return true;
        }
        return false;
        
    }
    public static int compareCards(Card c1, Card c2) {

	// first compare the suits
	if (c1.getValue() >= c2.getValue()) return 1;
	if (c1.getValue() < c2.getValue()) return -1;

	return 0;
    }
     public static void swapCards(ArrayList<Card> deck, int i, int j) {
	Card temp = deck.get(i);
	deck.set(i, deck.get(j));
        deck.set(j, temp);
    }


    /*
     * Sorts a deck from low to high.
     */
    public static void sortDeck(ArrayList<Card> deck) {
	for (int i=0; i<deck.size(); i++) {
	    int j = indexLowestCard(deck, i, deck.size()-1);
	    swapCards(deck, i, j);
	}
    }

    /*
     * Finds the index of the lowest card between low and high,
     * including both.
     */
    public static int indexLowestCard(ArrayList<Card> deck, int low, int high) {
	int winner = low;
	for (int i=low+1; i<=high; i++) {
	    if (CardCombination.compareCards(deck.get(i), deck.get(winner)) < 0) {
		winner = i;
	    }
	}
	return winner;
    }
    
    
}
