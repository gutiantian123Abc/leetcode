## Problem Description
```
/**
 * Created by xiangtiangu on 4/26/17.
 */
## Solution
```java
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
