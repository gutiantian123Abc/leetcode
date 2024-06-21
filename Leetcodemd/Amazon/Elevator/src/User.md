## Problem Description
```
/**
 * Created by xiangtiangu on 4/25/17.
 */
## Solution
```java
public class User {
    public void pressButton(int toFloor) {
        Request request = new Request(toFloor);
        RequestCommandCenter.getInstance().addRequest(request);
    }
}