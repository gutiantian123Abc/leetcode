import java.util.ArrayList;

/**
 * Created by xiangtiangu on 4/26/17.
 */
public class Hand {
    protected ArrayList<Card> cards;
    public Hand() {
        cards = new ArrayList<>();
    }
    public int score() {
        int score = 0;
        for(Card card : cards) {
            score += card.getValue();
        }
        return score;
    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public ArrayList<Card> all_Cards() {
        return cards;
    }
}
