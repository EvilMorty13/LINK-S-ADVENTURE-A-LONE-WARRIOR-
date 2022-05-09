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

    Texture[] st = new Texture[5];
    int stIndex=0;

    public StoryManager(MainGame game, boolean soundState){
        this.game=game;
        this.soundState=soundState;
    }

    @Override
    public void show() {
        SoundManager.create();
        st[0] = new Texture("Story_1.png");
        st[1] = new Texture("Story_2.png");
        st[2] = new Texture("Story_3.png");
        st[3] = new Texture("Story_4.png");
        st[4] = new Texture("Story_5.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        game.batch.draw(st[stIndex],0,0);

        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
            SoundManager.MenuSelection.stop();
            SoundManager.MenuSelection.play();
            if(stIndex==4){
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
