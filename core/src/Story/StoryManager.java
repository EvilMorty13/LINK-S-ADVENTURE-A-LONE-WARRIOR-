package Story;

import Menu.MenuScreen;
import Play.InsideStart;
import Sound.SoundManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MainGame;
import Sound.*;

public class StoryManager implements Screen {
    MainGame game;
    public boolean soundState;

    Texture[] st = new Texture[17];
    int stIndex=0;

    public StoryManager(MainGame game, boolean soundState){
        this.game=game;
        this.soundState=soundState;
    }

    @Override
    public void show() {
        SoundManager.create();
        for(int i=0;i<17;i++){
            st[i] = new Texture("Story/Story_"+(i+1)+".png");
        }
    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        game.batch.draw(st[stIndex],0,0);

        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            this.dispose();
            SoundManager.MenuSelection.stop();
            SoundManager.MenuSelection.play();
            game.setScreen(new InsideStart(game,soundState));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
            SoundManager.MenuSelection.stop();
            SoundManager.MenuSelection.play();
            if(stIndex==16){
                this.dispose();
                SoundManager.MenuSelection.stop();
                SoundManager.MenuSelection.play();
                game.setScreen(new InsideStart(game,soundState));
            }
            stIndex++;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            SoundManager.MenuBack.stop();
            SoundManager.MenuBack.play();
            if(stIndex==0){
                this.dispose();
                SoundManager.MenuBack.stop();
                SoundManager.MenuBack.play();
                game.setScreen(new MenuScreen(game,soundState));
            }
            stIndex--;
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
