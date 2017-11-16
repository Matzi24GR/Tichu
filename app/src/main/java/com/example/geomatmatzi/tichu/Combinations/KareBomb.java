package com.example.geomatmatzi.tichu.Combinations;

import java.util.ArrayList;
import com.example.geomatmatzi.tichu.Cards.Card;

public class KareBomb extends CardCombination{
    
    
    /**
     * constructor
     * precondition:na dw8oun 4 kartes idiou(2maures,2kokkines),dn mporoume na
     * exoume Phoinix,Drache,Hund,Mahjong mono SimpleCard
     * post:dhmiourgia kare apo 4 idia fulla
     * @param c 
     */
    public KareBomb(ArrayList<Card> tmp) throws Exception{
        super(tmp);
        if(tmp.size() != 4 ) {
            throw new Exception("Wrong Combination-KareBomb!");
        }
    }
    

    /**
     * accessors
     * Einai tupou Bomb
     * @return boolean
     */
    @Override
    public boolean isBomb() {
        return true;
    }

    /**
     * accessors
     * Epistrefei 4 to mhkos tou kare
     * @return int 
     */
    @Override
    public int sizeOfSet() {
        return 4;
    }

    @Override
    public boolean ispowerOfSetGreaterThan(CardCombination other) {
        if(this.getCards().get(0).getValue() > other.getCards().get(0).getValue()){
            return true;
        }
        return false;
    }
    
}
