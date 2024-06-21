<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
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
public class BlackJackCard extends Card{

    public BlackJackCard(Suit suit, int faceValue) {
        super(suit, faceValue);

    }

    public int value() {
        if(isAce()) {
            return 1;
        }else if(is_face_Value()) {
            return 10;
        }
        return faceValue;
    }

    private boolean isAce() {
        return faceValue == 1;
    }

    private boolean is_face_Value() {
        return faceValue >= 11 && faceValue <= 13;
    }

    public int min_value() {
        if(isAce()) {
            return 1;
        }
        return value();
    }

    //hahaahahahahahahahahahaahahahahahahahxxxxxxxxxxxxx
    }
}
</code></pre>
</div>
</div>
