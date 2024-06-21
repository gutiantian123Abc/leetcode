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
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;
public class RequestCommandCenter implements Runnable{
    private List<Request> requests;
    private static volatile RequestCommandCenter instance = null;
    private RequestCommandCenter() {
        requests = new ArrayList<>();
    }

    public static RequestCommandCenter getInstance() {
        if(instance == null) {
            synchronized (RequestCommandCenter.class) {
                instance = new RequestCommandCenter();
            }
        }
        return instance;
    }


    public void addRequest(Request request) {
        requests.add(request);
    }

    private void removeRequest(Request request) {
        requests.remove(request);
    }

    private Request getNextRequest() {
        Request next = null;
        int currentFloor = Elevator.getInstance().getCurrentFloor();
        int shortestDis = Integer.MAX_VALUE;
        for(Request request : requests) {
            if(Math.abs(request.getTarget() - currentFloor) < shortestDis) {
                shortestDis = Math.abs(request.getTarget() - currentFloor);
                next = request;
            }
        }
        return next;
    }

    private void processRequest() {
        Request request = getNextRequest();
        if(request != null) {
            Elevator.getInstance().move_to_target(request.getTarget());
            removeRequest(request);
        }
    }

    public void run() {
        while(true) {
            processRequest();
        }
    }
}
</code></pre>
</div>
</div>
