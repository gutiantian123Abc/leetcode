import java.util.Set;

/**
 * Created by xiangtiangu on 4/26/17.
 */
public class CD {
    private Set<Song> songs;
    private String genera;
    private String singer;

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public String getGenera() {
        return genera;
    }

    public void setGenera(String genera) {
        this.genera = genera;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

}
