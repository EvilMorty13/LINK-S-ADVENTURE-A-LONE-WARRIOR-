package Credit;

import Menu.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MainGame;
import Sound.*;

public class CreditsScreen implements Screen {
    MainGame game;
    Texture Credits;
    public boolean soundState;
    public CreditsScreen(MainGame game,boolean soundState){
        this.game=game;
        this.soundState=soundState;
    }

    @Override
    public void show() {
        SoundManager.create();
        Credits = new Texture("Credits.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(Credits,0f,0f);

        if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            this.dispose();
            SoundManager.MenuBack.play();
            game.setScreen(new MenuScreen(game,soundState));
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        SoundManager.dispose();
    }
}
