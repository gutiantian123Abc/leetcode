<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 1000px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* My Calendar I
Implement a MyCalendar class to store your events. 
A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). 
Formally, this represents a booking on the half open interval [start, end), 
the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection 
(ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, 
return true if the event can be added to the calendar successfully without causing a double booking. 
Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: 
MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  
The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, 
but not including 20.
Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
*/
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
/* My Calendar II
Implement a MyCalendarTwo class to store your events. 
A new event can be added if adding the event will not cause a triple booking.

Your class will have one method, book(int start, int end). 
Formally, this represents a booking on the half open interval [start, end), 
the range of real numbers x such that start <= x < end.

A triple booking happens when three events have some non-empty intersection 
(ie., there is some time that is common to all 3 events.)

For each call to the method MyCalendar.book, return true if the event 
can be added to the calendar successfully without causing a triple booking. Otherwise, 
return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(50, 60); // returns true
MyCalendar.book(10, 40); // returns true
MyCalendar.book(5, 15); // returns false
MyCalendar.book(5, 10); // returns true
MyCalendar.book(25, 55); // returns true
Explanation: 
The first two events can be booked.  The third event can be double booked.
The fourth event (5, 15) can't be booked, because it would result in a triple booking.
The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
*/
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class MyCalendar {
    private class Pair {
        int start = 0;
        int end = 0;
        
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private ArrayList<Pair> list;
    public MyCalendar() {
        list = new ArrayList<Pair>();
    }
    
    public boolean book(int start, int end) {
        for(Pair a : list) {
            Pair b = new Pair(start, end);
            if(!seperated(a, b)) {
                return false;
            }
        }
        
        list.add(new Pair(start, end));
        return true;
    }
    
    private boolean seperated(Pair a, Pair b) {
        if(a.end <= b.start || b.end <= a.start) {
            return true;
        }
        
        return false;
    }
}








class MyCalendarTwo {
    private class Pair {
        int start = 0;
        int end = 0;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private ArrayList<Pair> one;
    private ArrayList<Pair> two;

    public MyCalendarTwo() {
        one = new ArrayList<Pair>();
        two = new ArrayList<Pair>();
    }
    
    public boolean book(int start, int end) {
        Pair curr = new Pair(start, end);
        for(Pair t : two) {
            if(!seperated(curr, t)) {
                return false;
            }
        }
        
        for(Pair o : one) {
            if(!seperated(o, curr)) {
                two.add(new Pair(Math.max(start, o.start), Math.min(end, o.end)));
            }
        }
        
        one.add(curr);
        
        return true;   
    }
    
    private boolean seperated(Pair a, Pair b) {
        if(a.end <= b.start || b.end <= a.start) {
            return true;
        }
        
        return false;
    }
}


</code></pre>
</div>
</div>
