/** A deck or pile of cards. */
import java.util.concurrent.ThreadLocalRandom;
public class Deck {
    /**
     * Dylan Balata
     * CS152L-001
     * 5-2-16
     */
    

    /** Stores the cards in this deck. */
    private Card[] cards;

    /** The number of cards currently in this deck. */
    private int numCards;

    /** A new deck is initially empty, but has the capacity to hold
     * all the cards in a standard deck. */
    public Deck() {
        this.cards = new Card[52];
        numCards = 0;
    }

    /** Adds card to the top of this deck. */
    public void add(Card card) {
        this.cards[numCards]=card;
        this.numCards++;
    }

    /** Adds all cards in a standard deck. */
    public void fill() {
        int i=0;
        for(Rank r : Rank.values()){
            for(Suit s : Suit.values()){
                cards[i]= new Card(r,s);
                i++;
            }
        }
        numCards=52;
    }

    /**
     * Returns the ith card in this deck, where card 0 is the one on the bottom.
     * Assumes the deck is not empty.
     * Does not modify the deck.
     */
    public Card get(int i) {
        return cards[i];
    }

    /** Moves one card from the top of this deck to the top of that deck. */
    public void move(Deck that) {
        Card c = cards[numCards-1];
        that.add(c);
        this.cards[numCards-1]=null;
        this.numCards--;
        
    }

    /**
     * Moves the top n cards from the top of this deck to the top of that deck.
     * They maintain their order, so that the card that used to be on top of
     * this becomes the top of that.
     */
    public void move(Deck that, int n) {
        Deck cardsToMove = new Deck();
        for(int i=0;i<n;i++){
            move(cardsToMove);
        }
        for(int i=0;i<n;i++){
            cardsToMove.move(that);
        }
    }


    /**
     * Randomly reorders the cards in this deck.
     */
    //Idea for shuffleBetween deck from Thomas at http://gamedev.stackexchange.com/
    //questions/26551/how-do-i-shuffle-cards-for-a-card-game
    //Random number generator from poster Greg Case at http://stackoverflow.com/
    //questions/363681/generating-random-integers-in-a-specific-range
    public void shuffle() {
        Deck shuffleBetween = new Deck();
        int x = 52;
        while(x!=0){
            int rand = ThreadLocalRandom.current().nextInt(0, 52);
            if(cards[rand]!=null){
                shuffleBetween.cards[shuffleBetween.size()]=cards[rand];
                cards[rand]=null;
                x--;
            }
        }
        //System.out.println(shuffleBetween.size());
        this.cards = shuffleBetween.cards;
    }

    /** Returns the number of cards in this deck. */
    public int size() {
        int x = 0;
        for(int i=0;i<52;i++){
            if(cards[i]!=null){
                x++;
            }
        }
        return x;
    }

    /**
     * Returns the top card on this deck (but does not modify the deck).
     * 
     * @return null if this deck is empty.
     */
    public Card getTop() {
        if(numCards!=0){
            return cards[numCards-1];
        }
        return null;
    }

}