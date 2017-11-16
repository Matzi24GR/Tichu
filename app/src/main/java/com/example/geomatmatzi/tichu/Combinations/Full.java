package com.example.geomatmatzi.tichu.Combinations;

import com.example.geomatmatzi.tichu.Cards.Card;
import com.example.geomatmatzi.tichu.Cards.Phoenix;

import java.util.ArrayList;

public class Full extends CardCombination {

    
    public Full(ArrayList<Card> tmp) throws Exception{
        super(tmp);
        if(tmp.size() != 5 ) {
            throw new Exception("Wrong Combination-Full!");
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
     * Edw exoyme standar mege8os 1 pair kai 3 fulla
     * @return int 
     */
    @Override
    public int sizeOfSet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean ispowerOfSetGreaterThan(CardCombination other) {
        //we have to find the 3 same cards first
        com.example.geomatmatzi.tichu.Combinations.CardCombination.sortDeck(this.getCards());
        com.example.geomatmatzi.tichu.Combinations.CardCombination.sortDeck(other.getCards());
        int counta ,countb, valuea = 0, valueb = 0;
        if(this.HasPhoenix()){
            //couples
            if((this.getCards().get(1).getValue() == this.getCards().get(2).getValue() )&&(this.getCards().get(3).getValue()== this.getCards().get(4).getValue())){
                    for(Card tmp : this.getCards()){
                        if(tmp instanceof Phoenix){
                            tmp.setValue(this.getCards().get(3).getValue());
                        }
                    }
            }
            //three-one
            boolean flag = false;
            for(int j= 0 ;  j < this.getCards().size() ;j++){
                for(int i =1; i < this.getCards().size(); i++){
                    if(this.getCards().get(j).getValue() == this.getCards().get(i).getValue()){
                        flag = true;
                    }
                        
                }
                if(flag == false){
                    this.getCards().get(0).setValue(this.getCards().get(j).getValue());
                }
            }
            counta = 1;
            countb =1;
            for(int j= 0 ;  j < this.getCards().size() ;j++){
                for(int i =1; i < this.getCards().size(); i++){
                    if(this.getCards().get(j).getValue() == this.getCards().get(i).getValue()){
                      counta++;  
                    }
                }
                if(counta==3){
                    valuea = this.getCards().get(j).getValue();
                    break;
                }
            }
            for(int j= 0 ;  j < other.getCards().size() ;j++){
                for(int i =1; i < other.getCards().size(); i++){
                    if(other.getCards().get(j).getValue() == other.getCards().get(i).getValue()){
                      countb++;  
                    }
                }
                if(countb==3){
                    valueb = other.getCards().get(j).getValue();
                    break;
                }
            }
            if(valuea > valueb){
                return true;
            }
            else{
                return false;
            }
            
        }
        else{
            //no mahjong
            counta = 1;
            countb =1;
            for(int j= 0 ;  j < this.getCards().size() ;j++){
                for(int i =1; i < this.getCards().size(); i++){
                    if(this.getCards().get(j).getValue() == this.getCards().get(i).getValue()){
                      counta++;  
                    }
                }
                if(counta==3){
                    valuea = this.getCards().get(j).getValue();
                    break;
                }
            }
            for(int j= 0 ;  j < other.getCards().size() ;j++){
                for(int i =1; i < other.getCards().size(); i++){
                    if(other.getCards().get(j).getValue() == other.getCards().get(i).getValue()){
                      countb++;  
                    }
                }
                if(countb==3){
                    valueb = other.getCards().get(j).getValue();
                    break;
                }
            }
            if(valuea > valueb){
                return true;
            }
            else{
                return false;
            }
            
            
        }
        
        
    }
    
}
