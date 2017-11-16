
package com.example.geomatmatzi.tichu..Combinations;

import java.util.ArrayList;
import com.example.geomatmatzi.tichu..Cards.Card;


public class TreeCards extends CardCombination{
    /**
     * constructor
     * pre:3 kartes idiou ari8mou, dn mporoume na exoume Mahjong,Drache,Hund
     * post:dhmiourgia gurou apo TreeCards
     * @param c Card[]
     */
    public TreeCards(ArrayList<Card> tmp) throws Exception{
        super(tmp);
        if(tmp.size() != 3 ) {
            throw new Exception("Wrong Combination-ThreeCards!");
        }
        
    }

    /**
     * accessors
     * Elegxei an o tupos tou CardCombination einai Bomb
     * @return boolean
     */
    @Override
    public boolean isBomb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * accessors
     * Edw exoyme standar mege8os afou apoteleitai apo 3 cards
     * @return int 
     */
    @Override
    public int sizeOfSet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean ispowerOfSetGreaterThan(CardCombination other) {
              com.example.geomatmatzi.tichu..Combinations.CardCombination.sortDeck(this.getCards());
        com.example.geomatmatzi.tichu..Combinations.CardCombination.sortDeck(other.getCards());
        if(this.getCards().get(2).getValue() > other.getCards().get(2).getValue()){
            return true;
        }
        return false;
    }
    
}
