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
/*Load Balancer

Implement a load balancer for web servers. It provide the following functionality:

Add a new server to the cluster => add(server_id).
Remove a bad server from the cluster => remove(server_id).
Pick a server in the cluster randomly with equal probability => pick().
Example
At beginning, the cluster is empty => {}.

add(1)
add(2)
add(3)
pick()
>> 1         // the return value is random, it can be either 1, 2, or 3.
pick()
>> 2
pick()
>> 1
pick()
>> 3
remove(1)
pick()
>> 2
pick()
>> 3
pick()
>> 3

*/
    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//此题跟Insert_Delete_GetRandom_O_1一样

public class LoadBalancer {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> servers;
    Random rand;
    
    public LoadBalancer() {
        // do intialization if necessary
        map = new HashMap<>();
        servers = new ArrayList<>();
        rand = new Random();
    }

     
     //O(1)
    public void add(int server_id) {
        // write your code here
        if(map.containsKey(server_id)) {
            return;
        }
        
        //Update servers
        servers.add(server_id);
        
        //Update map
        map.put(server_id, servers.size() - 1);
    }

     
          //O(1)
    public void remove(int server_id) {
        // write your code here
        if(!map.containsKey(server_id)) {
            return;
        }
        
        
        //server_id 和 最后一位互换:
        //1. Update servers
        int index = map.get(server_id);
        int lastEle = servers.get(servers.size() - 1);
        servers.set(index, lastEle);
        servers.remove(servers.size() - 1);
        
        //2. Update map
        //2.1 for vol
        map.remove(server_id);
        
        //2.2 for lastEle
        map.put(lastEle, index);
        
    }

    public int pick() {
        // write your code here
        return servers.get(rand.nextInt(servers.size()));
    }
}</code></pre>
</div>
</div>
