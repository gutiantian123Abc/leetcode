<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
public class HelloWorld{
     public static void main(String []args){
         String s = "Hi,this is an example";
         String k = "4071321";
         String info = HackingTime(k, s);
        System.out.println(info);
     }
     public static boolean isAlph(char c) {
         return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
     }
     
     public static boolean isUpper(char c) {
         return c >= 'A' && c <= 'Z';
     }
     
     
     public static String HackingTime(String key, String message) {
         char[] digits = key.toCharArray();
         char[] M = message.toCharArray();
         int mLen = M.length;
         int digitsLen = digits.length;
             int j = 0;
             for(int i = 0; i < mLen; i++) {
                 char curChar = M[i];
                 j = j % digitsLen;
                 if(isAlph(curChar)) {
                     int rotateNum = digits[j] - '0';
                     if(isUpper(curChar)) { // 'A' ~ 'Z'
                        //System.out.println("here");
                         if(curChar + rotateNum <= 'Z') {
                             M[i] = (char)(curChar + rotateNum);
                             //System.out.println(M[i]);
                         }else {
                             int index = curChar + rotateNum - 'Z' - 1;
                             M[i] = (char)('A' + index);
                         }
                     }else {//'a' ~ 'z'
                         if(curChar + rotateNum <= 'z') {
                             M[i] = (char)(curChar + rotateNum);
                         }else {
                             int index = curChar + rotateNum - 'z' - 1;
                             M[i] = (char)('a' + index);
                         }                        
                     }
                     j++;
                 }
             }
         
         
         return String.copyValueOf(M);
     }
}














public class DataSorter {
 public static void main(String []args){
        String s = "Atvt hrqgse Cnikg";
        String k = "Your friend Alice";
        String info = getKey(k, s);
       System.out.println(info);
    }

   static String getKey(String orginal, String encyrpted){
    char[] e_arr = encyrpted.toCharArray(); 
    char[] o_arr = orginal.toCharArray(); 
    int letter_len = 0;
    for(char c : e_arr){
     if(Character.isLetter(c)) letter_len++;
     }
    char[] keys = new char[letter_len];
    int e_len = e_arr.length - 1; 
    int o_len = o_arr.length - 1; 
    letter_len--;
    while(o_len >= 0){
     if(Character.isLetter(o_arr[o_len])){
      char org = o_arr[o_len]; 
      char enp = e_arr[e_len];
      int tmp = org - enp;
      //System.out.println(-tmp);
      int offset = (enp - org) < 0 ? (enp + 26 - org) : (enp - org); 
      keys[letter_len] = (char)('0' + offset); 
      letter_len--;
      } 
     o_len--; 
     e_len--;
     } 
    
    String short_key = shortenKey(new String(keys));
    return short_key;
    //for(int i = 1; i < short_key.length(); i++){ 
    // StringBuilder sb = new StringBuilder();
    // sb.append(short_key.substring(i)); 
    // sb.append(short_key.substring(0, i));
    }
   
   
     //String new_tweets = decrypt(encyrpted, tmp_key); 
     //if(new_tweets.substring(new_tweets.length() - orginal.length()).equals(orginal)){
     // return tmp_key;
     // }
     //}
    //return ""; 
   // }
   static String shortenKey(String keys){

    String reverse_keys = reverse(keys); 
    int end = 1;
    //end == 7 
    String tmp_key = "";
    while(end < reverse_keys.length()){
     tmp_key = reverse_keys.substring(0, end);
     ////2802215 
     int tmp_len = tmp_key.length();
     //7 
     int tmp_begin = end ;//
     while(tmp_begin + tmp_len <= reverse_keys.length()){ 
      if(!tmp_key.equals(reverse_keys.substring(tmp_begin, tmp_begin + tmp_len))){
       break;
       }
      else{ 
       tmp_begin += tmp_len; 
       }
      }
     if(tmp_begin + tmp_len <= reverse_keys.length()){ 
      end++;
      }
     else{
      int i = 0; 
      while(tmp_begin < reverse_keys.length() && reverse_keys.charAt(tmp_begin) == tmp_key.charAt(i)){
       i++;
       tmp_begin++; 
       }
      if(tmp_begin == reverse_keys.length()){ 
       return reverse(tmp_key); 
       }
      else{ 
       end++;
       }
      }
     }
    return reverse(tmp_key); 
    }

   static String reverse(String s){ 
    char[] arr = s.toCharArray(); 
    int begin = 0, end = arr.length - 1; 
    while(begin < end){ 
     char tmp = arr[begin]; 
     arr[begin] = arr[end]; 
     arr[end] = tmp; begin++; 
     end--; 
     }
    return new String(arr); 
    }
}</code></pre>
</div>
</div>
