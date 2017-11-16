package com.example.geomatmatzi.tichu.Combinations;

import java.util.ArrayList;
import com.example.geomatmatzi.tichu.Cards.*;

public class OneCard extends CardCombination {
    
    /**
     * constructor
     * pre:Mia opoiadhpote karta mporei na einai monofullia
     * post:dhmiourgia gurou apo OneCard
     * @param c
     */
    public OneCard(ArrayList<Card> tmp) throws Exception{
        super(tmp);
        if(tmp.size() != 1 ) {
            throw new Exception("Wrong Combination-OneCard!");
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
     * Etsi wste na kseroume to mege8os pou prepei na exoun kai oi upoloipes
     * Edw mporoume na epistrefoume 1 afou exoume onecard
     * @return int 
     */
    @Override
    public int sizeOfSet() {
        return 1;
    }

    @Override
    public boolean ispowerOfSetGreaterThan(CardCombination other) {
        if(this.getCards().get(0) instanceof Phoenix){
            if(other.getCards().get(0) instanceof Drache ){
                return false;
            }
            else{
                this.getCards().get(0).setValue(other.getCards().get(0).getValue());
                return true;
            }
        }
        else{
            if(this.getCards().get(0).getValue() > other.getCards().get(0).getValue()){
                return true;
            }
            return false;
        }
    }
    
}
