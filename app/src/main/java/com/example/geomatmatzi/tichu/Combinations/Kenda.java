package com.example.geomatmatzi.tichu.Combinations;

import java.util.ArrayList;
import com.example.geomatmatzi.tichu.Cards.Card;

public class Kenda extends CardCombination {


    /**
     * Constructor
     * pre:na dw8oun toulaxiston 5 fulla, kata 1 ayksanomenou ari8mou
     *      dn mporoume na exoume Drache,Hund
     * post:dhmiourgia kentas apo >=5 fulla
     * @param c
     */
    public Kenda(ArrayList<Card> tmp) throws Exception{
        super(tmp);
        if(tmp.size() < 5 ) {
            throw new Exception("Wrong Combination-Kenda!");
        }
    }
    

    /**
     * accessors
     * Elegxei an o tupos tou CardCombination einai Bomb
     * @return boolean
     */
    @Override
    public boolean isBomb() {
        return false;
    }

    /**
     * accessors
     * Epistrefei to mege8os ths kendas, dld apo posa cards apoteleitai
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
