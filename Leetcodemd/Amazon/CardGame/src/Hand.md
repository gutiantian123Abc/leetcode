<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
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
</div>
