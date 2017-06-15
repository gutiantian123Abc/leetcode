/**
 * Created by xiangtiangu on 4/26/17.
 */
public class Card {
    protected Suit suit;
    protected int faceValue;
    protected boolean avaliable = true;
    public Card(Suit suit, int faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public boolean isAvaliable() {
        return this.avaliable;
    }

    public void mark_Avaliable() {
        this.avaliable = true;
    }

    public void mark_Unavaliable() {
        this.avaliable = false;
    }

    public Suit suit() {
        return suit;
    }
    public int getValue() {
        return this.faceValue;
    }
}