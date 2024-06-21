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
/* High Five
There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, 
find the average of 5 highest scores for each person.

Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]
Return
*/
/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> answer = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(Record record : results) {
            if(!map.containsKey(record.id)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(record.score);
                map.put(record.id, list);
            }else {
                //记住， 这里一定是用map.get().set......不可以用list = map.get(); list.set........
                if(map.get(record.id).size() < 5) {
                    map.get(record.id).add(record.score);
                }else {

                	//很好的在ArrayList里面存储top K 的例子：
                    int index = 0;
                    for(int i = 0; i < 5; i++) {
                        if(map.get(record.id).get(i) < map.get(record.id).get(index)) {
                            index = i;
                        }
                    }
                    
                    if(map.get(record.id).get(index) < record.score) {
                        map.get(record.id).set(index, record.score);
                    }
                }
            }
        }
        
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            ArrayList<Integer> scores = entry.getValue();
            double average = 0;
            for (int i = 0; i < 5; ++i)
                average += scores.get(i);
            average /= 5.0;
            answer.put(id, average);
        }
        return answer;        

    }
}</code></pre>
</div>
</div>
