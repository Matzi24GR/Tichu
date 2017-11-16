
package com.example.geomatmatzi.tichu.Cards;

public abstract class Card {

    private int value;//gia thn katametrhsh twn pontwn
    private int credits;//ka8e karta sumvolizetai me enan ari8mo px Mahjong=1,2=2,J=11,Q=12,K=13, A=14,
    
    
    /**
     * constructor
     * 
     */
    public Card( ) {
        this.value = 0;
        this.credits=0;
    }
   
    /**
     * accessors
     * Epistrefei ton ari8mo ka8e card 1:Mahjong,2:2,...,J:11,Q:12,K:13,A:14
     * Epistrefei double giati o Phoenix dinei 0.5+previous number
     * @return double 
     */
    public int getCredits() {
        return this.credits;
    }

    /**
     * transformers
     * Dinei se ka8e card thn aksia tou 1:Mahjong,2:2,...,J:11,Q:12,K:13,A:14
     * @param number 
     * @return void
     */
    public void setCredits(int number) {
        this.credits = number;
    }

    /**
     * accessors
     * Epistrefei tous pontous pou metraei ka8e card gia thn katametrhsh twn pontwn,
     * K=10 pontoi,10=10 pontoi,5=5 pontoi ktl
     * Den exoun ola ta cards pontous
     * @return int 
     */
    public int getValue() {
        return value;
    }

    /**
     * transformers
     * Vazei se ka8e card tous pontous pou metraei, 0 gia osa dn exoun pontous
     * @param value 
     * @return void
     */
    public void setValue(int value) {
        this.value = value;
    }
}