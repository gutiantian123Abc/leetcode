import java.util.ArrayList;

/**
 * Created by xiangtiangu on 4/26/17.
 */
public abstract class Deck {
    protected ArrayList<Card> cards;
    public void dealCard(int index) {
        //....
    }


    public void shuffle() {
        //....
    }

    public int remaining_card() {
        return cards.size();
    }
}