<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/**
 * Created by xiangtiangu on 4/26/17.
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
import java.util.ArrayList;

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
</code></pre>
</div>