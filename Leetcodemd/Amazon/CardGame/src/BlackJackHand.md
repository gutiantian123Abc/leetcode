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

public class BlackJackHand extends Hand {
    public BlackJackHand() {
        super();
    }

    public ArrayList<Integer> possibleScores() {
        //...
        return new ArrayList<Integer>();
    }

    public int score() {
        ArrayList<Integer> scores = possibleScores();

        int Max_Under = Integer.MIN_VALUE;
        int Min_over = Integer.MAX_VALUE;

        for(Integer score : scores) {
            if(score <= 21 && score > Max_Under) {
                Max_Under = score;
            }else if(score > 21 && score < Min_over) {
                Min_over = score;
            }
        }

        return Max_Under == Integer.MIN_VALUE ? Min_over : Max_Under;
    }

    public boolean win() {
        return score() == 21;
    }

    public boolean lose() {
        return score() > 21;
    }





}</code></pre>
</div>
</div>
