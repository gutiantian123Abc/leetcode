## Problem Description
```
/**
 * Created by xiangtiangu on 4/26/17.
 */
## Solution
```java
public class Song {
    private String singer;
    private String genera;
    private CD cd;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Song(String singer, String genera, CD cd) {
        this.singer = singer;
        this.genera = genera;
        this.cd = cd;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenera() {
        return genera;
    }

    public void setGenera(String genera) {
        this.genera = genera;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }
}
