package test.music;

import java.util.ArrayList;
import java.util.List;

public class MusicList {
    List<Music> listOfMusic = new ArrayList<>();

    public List<Music> getListOfMusic() {
        return listOfMusic;
    }

    public void setListOfMusic(List<Music> listOfMusic) {
        this.listOfMusic = listOfMusic;
    }
}
