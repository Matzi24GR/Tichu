/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geomatmatzi.tichu..Combinations;

import java.util.ArrayList;
import com.example.geomatmatzi.tichu..Cards.Card;

/**
 *
 * @author Win7User
 */
public class CardSet extends CardCombination{
    
    public CardSet(ArrayList<Card> tmp){
        super(tmp);
        
    }

    @Override
    public boolean ispowerOfSetGreaterThan(CardCombination other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isBomb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
