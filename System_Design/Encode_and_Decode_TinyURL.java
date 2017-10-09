/* Encode and Decode TinyURL
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/

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
// codec.decode(codec.encode(url));