package test.music;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> music = new ArrayList<>();
    private String name;
    private int value;

    public void playMusic() {
        System.out.print("Music playing : \n");
        music.forEach(Music::playMusic);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(MusicList music) {
        this.music = music.getListOfMusic();
    }
}

