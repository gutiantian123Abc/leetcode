<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/**
 * Created by xiangtiangu on 4/26/17.
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
import java.util.LinkedList;
import java.util.Queue;

public class PlayList {
    private Queue<Song> playlist;

    public Queue<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Queue<Song> playlist) {
        this.playlist = playlist;
    }


    public PlayList() {
        playlist = new LinkedList<Song>();

    }

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void deleteSong(Song song) {
        if(playlist.contains(song)) {
            playlist.remove(song);
        }
    }

    public Song getNextSong() {
        Song song = playlist.peek();
        addSong(song);
        return song;
    }
}
</code></pre>
</div>
</div>
