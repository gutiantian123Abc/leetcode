<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
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
public class CD_Player {
    private PlayList playlist;
    private CD cd;

    public CD_Player(PlayList playlist) {
        this.playlist = playlist;
        this.cd = null;
    }

    public CD_Player(CD cd) {
        this.cd = cd;
        this.playlist = null;
    }

    public void play() {
        if(cd != null) {
            for(Song song : cd.getSongs()){
                System.out.println("Playing " + song.getName() + " By " + song.getSinger());
            }
        }

        if(playlist != null) {
            for(Song song : playlist.getPlaylist()) {
                System.out.println("Playing " + song.getName() + " By " + song.getSinger());
            }
        }
    }

    public void playSong(Song song) {
        System.out.println("Playing " + song.getName() + " By " + song.getSinger());
    }

    public PlayList getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlayList playlist) {
        this.playlist = playlist;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

}
</code></pre>
</div>
</div>
