/** A standard playing card. */
public class Card {
    /**
     * Dylan Balata
     * CS152L-001
     * 5-2-16
     */

    /** True if this card is face-up. */
    private boolean faceUp;

    /** Rank of the card. */
    private Rank rank;

    /** Suit of the card. */
    private Suit suit;

    /**
     * Newly-created cards are face-up by default.
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.faceUp = true;
    }

    /**
     * Returns the rank of this card: one of ACE through KING.
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Returns the suit of this card, one of CLUBS, SPADES, HEARTS, or DIAMONDS.
     */
    public Suit getSuit() {
        return this.suit;
    }

    /** Returns true if this card is face-up. */
    public boolean isFaceUp() {
        if(this.faceUp){
            return true;
        }
        return false;
    }

    /** Returns true if this card is black. */
    public boolean isBlack() {
        if(this.getSuit().equals(Suit.SPADES)
                || this.getSuit().equals(Suit.CLUBS)){
            return true;
        }
        return false;
    }

    /** Sets the face-up status of this card. */
    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

}