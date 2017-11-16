package com.example.geomatmatzi.tichu..Combinations;

import java.util.ArrayList;
import com.example.geomatmatzi.tichu..Cards.Card;

public class Steps extends CardCombination{

    
    /**
     * constructor
     * pre:na dw8oun zeugaria apo kartes idiou noumerou,kai ta zeugaria
     * na auksanoun kata 1 to noumero tous.Den 8eloume perito plh8os,dn mporoume
     * na exoume Drache,Hund,Mahjong
     * post:dhmiourgia zugou ari8mou zeugariwn idiwn kartwn, auksanomena kata 1
     * @param c 
     */
    public Steps(ArrayList<Card> tmp) throws Exception{
        super(tmp);
        if(tmp.size() < 4 ) {
            throw new Exception("Wrong Combination-Pairs!");
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
     * Epistrefei to mege8os tou set px an exoume riksei 6-6,7-7,8-8
     * 8a mas epistrepsei 3
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
        if(this.getCards().size() != other.getCards().size()){
            return false;
        }
        else{
            if(this.getCards().get(this.getCards().size()-1).getValue() > other.getCards().get(other.getCards().size()-1).getValue()){
                return true;
            }
            return false;
        }
    }
    
    
}
