<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 500px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
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
}</code></pre>
</div>
</div>
