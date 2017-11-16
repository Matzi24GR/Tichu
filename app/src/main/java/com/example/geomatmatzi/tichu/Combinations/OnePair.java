package com.example.geomatmatzi.tichu.Combinations;

import java.util.ArrayList;
import com.example.geomatmatzi.tichu.Cards.Card;

public class OnePair extends CardCombination {
    
    /**
     * constructor
     * pre:na dw8oun 2 kartes idio noumero, dn mporei na einai skulaki,oute Majhong oute Drache
     * post:dhmiourgia onepair apo 2 idies kartes
     * @param c1
     * @param c2 
     */
    public OnePair(ArrayList<Card> tmp) throws Exception{
        super(tmp);
        if(tmp.size() != 2 ) {
            throw new Exception("Wrong Combination-OnePair!");
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
     * Epistrefei to mege8os tou set px 5 gia kenda mege8ous 5
     * Mporoume na mhn th xrhsimopoihsoume edw afou exoume 2cards
     * @return int
     */
    @Override
    public int sizeOfSet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean ispowerOfSetGreaterThan(CardCombination other) {
              com.example.geomatmatzi.tichu.Combinations.CardCombination.sortDeck(this.getCards());
        com.example.geomatmatzi.tichu.Combinations.CardCombination.sortDeck(other.getCards());
        if(this.getCards().get(1).getValue() > other.getCards().get(1).getValue()){
            return true;
        }
        return false;
    }
    
    
    
}
