package Sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class SoundManager {
    public static Music Background;
    public static Music MenuMoving;
    public static Music MenuSelection;
    public static Music MenuBack;
    public static Music MainTheme;
    public static Music SwordSlash;
    public static Music KeyFoundSound;

    public static Music BombDrop;
    public static Music BombBlow;

    public static Music Explosion;


    public static void create() {
        Background = Gdx.audio.newMusic(Gdx.files.internal("Sound/Background.mp3"));
        MenuMoving = Gdx.audio.newMusic(Gdx.files.internal("Sound/Menu_Moving.mp3"));
        MenuSelection = Gdx.audio.newMusic(Gdx.files.internal("Sound/Menu_Selection.mp3"));
        MenuBack = Gdx.audio.newMusic(Gdx.files.internal("Sound/Menu_Back.mp3"));
        MainTheme = Gdx.audio.newMusic(Gdx.files.internal("Sound/Main_Theme.mp3"));
        SwordSlash = Gdx.audio.newMusic(Gdx.files.internal("Sound/Sword_Slash.wav"));
        KeyFoundSound = Gdx.audio.newMusic(Gdx.files.internal("Sound/Key_Found_2.mp3"));
        BombDrop = Gdx.audio.newMusic(Gdx.files.internal("Sound/Bomb_Drop.wav"));
        BombBlow = Gdx.audio.newMusic(Gdx.files.internal("Sound/Bomb_Blow.wav"));
        Explosion = Gdx.audio.newMusic(Gdx.files.internal("Sound/Explosion.mp3"));
    }

    public static void dispose() {
        Background.dispose();
        MenuMoving.dispose();
        MenuSelection.dispose();
        MenuBack.dispose();
        MainTheme.dispose();
        SwordSlash.dispose();
        KeyFoundSound.dispose();
        BombDrop.dispose();
        BombBlow.dispose();
        Explosion.dispose();
    }
}
