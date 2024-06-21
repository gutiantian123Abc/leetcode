<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/**
 * Created by xiangtiangu on 4/25/17.
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
public class User {
    public void pressButton(int toFloor) {
        Request request = new Request(toFloor);
        RequestCommandCenter.getInstance().addRequest(request);
    }
}</code></pre>
</div>
</div>
