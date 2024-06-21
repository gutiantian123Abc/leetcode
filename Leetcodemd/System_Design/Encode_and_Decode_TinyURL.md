<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 50%; margin: auto; padding: 20px; }
  .comment-block { max-width: 50%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Encode and Decode TinyURL
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/
/*
Design TinyURL
Note: For the coding companion problem, please see: Encode and Decode TinyURL.
How would you design a URL shortening service that is similar to TinyURL?

Background:
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
and it returns a short URL such as http://tinyurl.com/4e9iAk.

Requirements:
For instance, "http://tinyurl.com/4e9iAk" is the tiny url for the page "https://leetcode.com/problems/design-tinyurl". 
The identifier (the highlighted part) can be any string with 6 alphanumeric characters containing 0-9, a-z, A-Z.
Each shortened URL must be unique; that is, no two different URLs can be shortened to the same URL.
Note about Questions:
Below are just a small subset of questions to get you started. 
In real world, there could be many follow ups and questions possible and the discussion is open-ended (No one true or correct way to solve a problem).
 If you have more ideas or questions, please ask in Discuss and we may compile it here!

Questions:
How many unique identifiers possible? Will you run out of unique URLs?
Should the identifier be increment or not? Which is easier to design? Pros and cons?
Mapping an identifier to an URL and its reversal - Does this problem ring a bell to you?
How do you store the URLs? Does a simple flat file database work?
What is the bottleneck of the system? Is it read-heavy or write-heavy?
Estimate the maximum number of URLs a single machine can store.
Estimate the maximum number of queries per second (QPS) for decoding a shortened URL in a single machine.
How would you scale the service? 
For example, a viral link which is shared in social media could result in a peak QPS at a moment's notice.
How could you handle redundancy? i,e, if a server is down, how could you ensure the service is still operational?
Keep URLs forever or prune, pros/cons? How we do pruning? (Contributed by @alex_svetkin)
What API would you provide to a third-party developer? (Contributed by @alex_svetkin)
If you can enable caching, what would you cache and what's the expiry time? (Contributed by @Humandroid)



Solution:
S: Scenario
Long URL to short URL and reversed.

N: Need (Assume the system is not massive if you are not sure)
QPS (queries per second)

Daily User: 100M
Daily usage per person: (Write) long2short 0.1, (Read) short2long 1
Daily request: Write 10M, Read 100M
QPS: Since a day is 86400s approximately 100K.
Write 100, Read 1K

Peak QPS: Write 200, Read 2K
(Thousand level can be handled by a single SSD MySQL Machine)

Storage

10M new mappings (long URL to short URL) per day
assume each mapping takes 100B in average
1GB every day. 1 TB hard drive could stand for 3 years.
Storage is not the problem for this kind of system. Service like Netflix may have storage issues.

Through SN analysis, we could have a big picture of the system. In general, this system is not hard and could be handled by a single SSD Machine.

A: API
Only one service: URLService

Core (Business Logic) Layer:
Class: URLService
Interface:
URLService.encode(String long_url)
URLService.decode(String short_url)
Web Layer:
REST API:
GET: /{short_url}, return a http redirect response(301)
POST: goo.gl method - google shorten URL
Request Body: {url=longUrl} e.g. {"longUrl": "http://www.google.com/"}
Return OK(200), short_url is included in the data

K: Data Access
Step 1: Pick a storage structure

SQL VS NOSQL?
Does it need to support transactions? NoSQL does not support transaction.
Do we need rich SQL query? NoSQL does not support as many queries as SQL.
Pursue development efficiency? Most Web Framework supports SQL database very well (with ORM). 
It means fewer codes for the system.
Do we need to use AUTO_INCREMENT ID? NoSQL couldn't do this. It only has a global unique Object_id.
Does the system has a high requirement for QPS? NoSQL has high performance. 
For example, Memcached's QPS could reach million level, MondoDB does 10K level, MySQL only supports K level.
How high is the system's scalability? SQL requires developers write their codes to scale, while NoSQL comes with them (sharding, replica).
ANSWER:

No -> NoSQL
No -> NoSQL
Doesn't matter because there are only a few codes. -> NoSQL
Our algorithm needs AUTO_INCREMENT ID. -> SQL
Write 200, Read 2K. Not high. -> SQL
Not high. -> SQL



Step 2: Database Schema

One table (id, long_url). id is the primary key, ordered by long_url
The basic system architecture:
Browser <-> Web <-> Core <-> DB


O: optimize
How to improve the response speed?

IMPROVE THE RESPONSE SPEED BETWEEN WEB SERVER AND DATABASE

Use Memcached to improve response speed. When getting long_url, search in the cache first, then database. 
We could put 90% read request on the cache.

IMPROVE THE RESPONSE SPEED BETWEEN WEB SERVER AND USER'S BROWSER

Different locations use different web server and cache server. 
All the areas share a DB used to match the users to the closest web server (through DNS) when they have a miss on the cache.


More Optimization
Put Chinese DB in China, American DB in the United States. Use geographical information as the sharding key, 
e.g. 0 for Chinese websites, 1 for American websites.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Codec {

    // Encodes a URL to a shortened URL.
    public String dic = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public HashMap<String, String> short_to_long = new HashMap<String, String>(); //这些东西可以放在Database或Cache里面
    public HashMap<String, String> long_to_short = new HashMap<String, String>(); //这些东西可以放在Database或Cache里面
    public String BASE_HOST = "http://tinyurl.com/";
    public String encode(String longUrl) {    
        if(long_to_short.containsKey(longUrl)) {
            return BASE_HOST + long_to_short.get(longUrl);
        }
        String key = null;
        do{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 6; i++) {
                sb.append(dic.charAt((int)(Math.random() * dic.length())));
            }
            key = sb.toString();
        }while(short_to_long.containsKey(key));

        short_to_long.put(key, longUrl);
        long_to_short.put(longUrl, key);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short_to_long.get(shortUrl.replace(BASE_HOST, ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));</code></pre>
</div>
</div>
