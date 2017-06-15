/**
 * Created by xiangtiangu on 4/26/17.
 */
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
