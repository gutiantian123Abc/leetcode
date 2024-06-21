<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Number of Airplanes in the SkyGiven an interval list which are flying and landing time of the flight. Howmany airplanes are on the sky at most?ExampleFor interval list[  (1,10),  (2,3),  (5,8),  (4,7)]Return 3NoticeIf landing and flying happens at the same time, we consider landing shouldhappen at first.*//* 知识要点：Sweep Line扫描线算法 区间问题巧妙解法扫描问题的特点1. 事件往往是以区间的形式存在2. 区间两端代表事件的开始和结束3. 按照区间起点排序，起点相同的按照终点排序扫描线要点将起点和终点打散排序[[1,3], [2,4]] => [[1,start],[2,start],[3,end],[4,end]]*//** * Definition of Interval: * public classs Interval { *     int start, end; *     Interval(int start, int end) { *         this.start = start; *         this.end = end; *     } * } */    /**     * @param airplanes: An interval array     * @return: Count of airplanes are in the sky.     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Solution {
    class Point {
        int time;
        int flag;
        public Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    
    public Comparator<Point> cmp = new Comparator<Point>() {
        public int compare(Point a, Point b) {
            if(a.time == b.time) {
                return a.flag - b.flag;
            }
            
            return a.time - b.time;
        }
    };
    
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        ArrayList<Point> list = new ArrayList<>(airplanes.size() * 2);
        for(Interval interval : airplanes) {
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, 0 ));
        }
        Collections.sort(list, cmp);
        int count = 0, ans = 0;
        for(Point point : list) {
            if(point.flag == 1) {
                count++;
            }else {
                count--;
            }
            
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}</code></pre>
</div>
</div>
