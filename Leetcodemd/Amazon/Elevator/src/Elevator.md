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
 * Created by xiangtiangu on 4/25/17.
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
public class Elevator {
    private int currentFloor;
    private int status;
    private static volatile Elevator instance = null;
    private Elevator() {
        currentFloor = 0;
        status = 0;
    }

    public static Elevator getInstance() {
        if(instance == null) {
            synchronized(Elevator.class) {
                instance = new Elevator();
            }
        }
        return instance;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getStatus() {
        return status;
    }
    private void moveUp() {
        status = 1;
        currentFloor += 1;
    }

    private void moveDown() {
        status = -1;
        currentFloor -= 1;
    }

    public void move_to_target(int targetFloor) {
        while(currentFloor > targetFloor) {
            moveDown();
        }

        while(currentFloor < targetFloor) {
            moveUp();
        }
    }
}</code></pre>
</div>
</div>
