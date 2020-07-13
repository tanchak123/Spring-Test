package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.music.ClassicMusic;
import test.music.MusicPlayer;
import test.music.RockMusic;

public class AppContext {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "appContext.xml"
        );
        applicationContext.getBean(RockMusic.class).playMusic();
        MusicPlayer musicPlayer = applicationContext.getBean(MusicPlayer.class);
        musicPlayer.playMusic();
        System.out.println("name : " + musicPlayer.getName()
                + "\nvalue : " + musicPlayer.getValue());
    }
}
