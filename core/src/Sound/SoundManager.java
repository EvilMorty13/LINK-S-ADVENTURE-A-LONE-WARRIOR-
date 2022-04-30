package Sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class SoundManager {
    public static Music Background;
    public static Music MenuMoving;
    public static Music MenuSelection;
    public static Music MenuBack;
    public static Music MainTheme;

    public static void create() {
        Background = Gdx.audio.newMusic(Gdx.files.internal("Background.mp3"));
        MenuMoving = Gdx.audio.newMusic(Gdx.files.internal("Menu_Moving.mp3"));
        MenuSelection = Gdx.audio.newMusic(Gdx.files.internal("Menu_Selection.mp3"));
        MenuBack = Gdx.audio.newMusic(Gdx.files.internal("Menu_Back.mp3"));
        MainTheme = Gdx.audio.newMusic(Gdx.files.internal("Main_Theme.mp3"));
    }

    public static void dispose() {
        Background.dispose();
        MenuMoving.dispose();
        MenuSelection.dispose();
        MenuBack.dispose();
        MainTheme.dispose();
    }
}
