## Problem Description
```
/**
 * Created by xiangtiangu on 4/25/17.
 */
## Solution
```java
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
}