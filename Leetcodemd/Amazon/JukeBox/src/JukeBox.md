<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
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
import java.util.HashSet;
import java.util.Set;

public class JukeBox {
    private CD_Player cd_player;
    private Set<CD> cd_collections;

    public JukeBox(CD_Player cd_player, Set<CD> cd_collections) {
        this.cd_player = cd_player;
        this.cd_collections = cd_collections;
    }

    public Set<CD> getAllCDsByGenera(String genera) {
        Set<CD> answer = new HashSet<>();
        for(CD cd : cd_collections) {
            if(cd.getGenera().equalsIgnoreCase(genera)) {
                answer.add(cd);
            }
        }
        return answer;
    }

    public Set<Song> getAllSongByGenera(String genera) {
        Set<Song> answer = new HashSet<>();
        for(CD cd : getAllCDsByGenera(genera)) {
            for(Song song : cd.getSongs()) {
                answer.add(song);
            }
        }

        return answer;
    }

    public void playSong(Song song) {
        cd_player.playSong(song);
    }

    public void play_playList(PlayList playList) {
        for(Song song : playList.getPlaylist()) {
            cd_player.playSong(song);
        }
    }

    public void play_cd(CD cd) {
        for(Song song : cd.getSongs()) {
            cd_player.playSong(song);
        }
    }

    public CD_Player getCd_player() {
        return cd_player;
    }

    public void setCd_player(CD_Player cd_player) {
        this.cd_player = cd_player;
    }

    public Set<CD> getCd_collections() {
        return cd_collections;
    }

    public void setCd_collections(Set<CD> cd_collections) {
        this.cd_collections = cd_collections;
    }


}
</code></pre>
</div>
</div>
