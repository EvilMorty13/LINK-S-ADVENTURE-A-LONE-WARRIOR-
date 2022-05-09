package Instructions;

import Menu.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MainGame;
import Sound.*;

public class InstructionScreen implements Screen {
    MainGame game;
    Texture Instructions;

    public boolean soundState;
    public InstructionScreen(MainGame game,boolean soundState){
        this.game=game;
        this.soundState=soundState;
    }
    @Override
    public void show() {
        SoundManager.create();
        Instructions = new Texture("Menu/Instructions.png");

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(Instructions,0f,0f);

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
