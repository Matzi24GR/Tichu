package com.example.geomatmatzi.tichu.Cards;

public class SimpleCard extends Card {

        private int rank, suit;

	private static String[] suits = { "a", "b", "c", "d" };
	private static String[] ranks  = { "-1","-1" , "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13","14" };


	public SimpleCard(int suit, int rank)
	{
		this.rank=rank;
                this.setValue(rank);
		this.suit=suit;
                this.setCredits(0);
                
                if(ranks[rank].equals("5")){
                    this.setValue(5);
                    this.setCredits(5);
                }
                else if(ranks[rank].equals("10")){
                    this.setValue(10);
                    this.setCredits(10);
                }
                else if(ranks[rank].equals("11")){
                    this.setValue(11);
                    this.setCredits(0);
                }
                else if(ranks[rank].equals("12")){
                    this.setValue(12);
                    this.setCredits(0);
                }
                else if(ranks[rank].equals("13")){
                    this.setValue(13);
                    this.setCredits(10);
                }
                else if(ranks[rank].equals("14")){
                    this.setValue(14);
                    this.setCredits(0);
                }
                
	}

    /**
     * @return the rank
     */
    public String getRank() {
        return ranks[rank];
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return the suit
     */
    public String getSuit() {
        return suits[suit];
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(int suit) {
        this.suit = suit;
    }
    public @Override String toString(){
	return ranks[this.rank] + suits[this.suit] + ".png";
    }
        
    
}
