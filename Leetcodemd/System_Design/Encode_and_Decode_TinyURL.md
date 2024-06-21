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
/* Encode and Decode TinyURLNote: This is a companion problem to the System Design problem: DesignTinyURL.TinyURL is a URL shortening service where you enter a URL such ashttps://leetcode.com/problems/design-tinyurland it returns a short URL such as http://tinyurl.com/4e9iAk.Design the encode and decode methods for the TinyURL service.There is no restriction on how your encode/decode algorithm should work.You just need to ensure that a URL can be encoded to a tiny URL and thetiny URL can be decoded to the original URL.*//*Design TinyURLNote: For the coding companion problem, please see: Encode and DecodeTinyURL.How would you design a URL shortening service that is similar to TinyURL?Background:TinyURL is a URL shortening service where you enter a URL such ashttps://leetcode.com/problems/design-tinyurland it returns a short URL such as http://tinyurl.com/4e9iAk.Requirements:For instance, "http://tinyurl.com/4e9iAk" is the tiny url for the page"https://leetcode.com/problems/design-tinyurl".The identifier (the highlighted part) can be any string with 6 alphanumericcharacters containing 0-9, a-z, A-Z.Each shortened URL must be unique; that is, no two different URLs can beshortened to the same URL.Note about Questions:Below are just a small subset of questions to get you started.In real world, there could be many follow ups and questions possible andthe discussion is open-ended (No one true or correct way to solve aproblem). If you have more ideas or questions, please ask in Discuss and we maycompile it here!Questions:How many unique identifiers possible? Will you run out of unique URLs?Should the identifier be increment or not? Which is easier to design? Prosand cons?Mapping an identifier to an URL and its reversal - Does this problem ring abell to you?How do you store the URLs? Does a simple flat file database work?What is the bottleneck of the system? Is it read-heavy or write-heavy?Estimate the maximum number of URLs a single machine can store.Estimate the maximum number of queries per second (QPS) for decoding ashortened URL in a single machine.How would you scale the service?For example, a viral link which is shared in social media could result in apeak QPS at a moment's notice.How could you handle redundancy? i,e, if a server is down, how could youensure the service is still operational?Keep URLs forever or prune, pros/cons? How we do pruning? (Contributed by@alex_svetkin)What API would you provide to a third-party developer? (Contributed by@alex_svetkin)If you can enable caching, what would you cache and what's the expiry time?(Contributed by @Humandroid)Solution:S: ScenarioLong URL to short URL and reversed.N: Need (Assume the system is not massive if you are not sure)QPS (queries per second)Daily User: 100MDaily usage per person: (Write) long2short 0.1, (Read) short2long 1Daily request: Write 10M, Read 100MQPS: Since a day is 86400s approximately 100K.Write 100, Read 1KPeak QPS: Write 200, Read 2K(Thousand level can be handled by a single SSD MySQL Machine)Storage10M new mappings (long URL to short URL) per dayassume each mapping takes 100B in average1GB every day. 1 TB hard drive could stand for 3 years.Storage is not the problem for this kind of system. Service like Netflixmay have storage issues.Through SN analysis, we could have a big picture of the system. In general,this system is not hard and could be handled by a single SSD Machine.A: APIOnly one service: URLServiceCore (Business Logic) Layer:Class: URLServiceInterface:URLService.encode(String long_url)URLService.decode(String short_url)Web Layer:REST API:GET: /{short_url}, return a http redirect response(301)POST: goo.gl method - google shorten URLRequest Body: {url=longUrl} e.g. {"longUrl": "http://www.google.com/"}Return OK(200), short_url is included in the dataK: Data AccessStep 1: Pick a storage structureSQL VS NOSQL?Does it need to support transactions? NoSQL does not support transaction.Do we need rich SQL query? NoSQL does not support as many queries as SQL.Pursue development efficiency? Most Web Framework supports SQL databasevery well (with ORM).It means fewer codes for the system.Do we need to use AUTO_INCREMENT ID? NoSQL couldn't do this. It only has aglobal unique Object_id.Does the system has a high requirement for QPS? NoSQL has high performance.For example, Memcached's QPS could reach million level, MondoDB does 10Klevel, MySQL only supports K level.How high is the system's scalability? SQL requires developers write theircodes to scale, while NoSQL comes with them (sharding, replica).ANSWER:No -> NoSQLNo -> NoSQLDoesn't matter because there are only a few codes. -> NoSQLOur algorithm needs AUTO_INCREMENT ID. -> SQLWrite 200, Read 2K. Not high. -> SQLNot high. -> SQLStep 2: Database SchemaOne table (id, long_url). id is the primary key, ordered by long_urlThe basic system architecture:Browser <-> Web <-> Core <-> DBO: optimizeHow to improve the response speed?IMPROVE THE RESPONSE SPEED BETWEEN WEB SERVER AND DATABASEUse Memcached to improve response speed. When getting long_url, search inthe cache first, then database.We could put 90% read request on the cache.IMPROVE THE RESPONSE SPEED BETWEEN WEB SERVER AND USER'S BROWSERDifferent locations use different web server and cache server.All the areas share a DB used to match the users to the closest web server(through DNS) when they have a miss on the cache.More OptimizationPut Chinese DB in China, American DB in the United States. Use geographicalinformation as the sharding key,e.g. 0 for Chinese websites, 1 for American websites.*/</pre>
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
