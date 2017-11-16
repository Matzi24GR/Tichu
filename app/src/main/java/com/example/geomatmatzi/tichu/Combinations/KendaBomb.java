package com.example.geomatmatzi.tichu.Combinations;

import com.example.geomatmatzi.tichu.Cards.Card;

import java.util.ArrayList;


public class KendaBomb extends CardCombination {

    /**
     * constructor
     * precondition:Den mporei na exei mesa ton foinika,Hund,Drache,Majhong
     *              Den mporei na pesei se nekro xrono,ara ta card mporei
     *              na einai mono Simple,auksanomenhs dunamhs kata 1 kai >=5
     * post:dhmiourgia kendaBomb apo >=5 fullwn auksanomena kata 1.
     */
    public KendaBomb(ArrayList<Card> tmp) throws Exception{
        super(tmp);
        if(tmp.size() != 4 ) {
            throw new Exception("Wrong Combination-KentaBomb!");
        }
    }
   
      
    /**
     * accessor
     * Epistrefei panta true giati einai bomb
     * @return 
     */
    @Override
    public boolean isBomb() { return true;}
    
    /**
     * accessor
     * Elegxei an h kenta einai swsth dld sunexomenh kai me idio xrwma cards
     * @return boolean
     */
    public boolean isKendaBombCorrect(){return false;};

    @Override
    public boolean ispowerOfSetGreaterThan(CardCombination other) {
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
