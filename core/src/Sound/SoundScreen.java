package Sound;

import Menu.MenuScreen;
import Play.InsideStart;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MainGame;

public class SoundScreen implements Screen {
    MainGame game;
    Texture Sound_Screen;
    Texture SoundCircleImg;
    Texture mute;
    private static final int SoundCircleWidth=22;
    private static final int SoundCircleHight=13;

    final int[] SoundCircleX = new int[]{1112,1192};
    final int[] SoundCircleY = new int[]{272,272};

    public int SoundCircleIndx=0;

    public boolean SoundState = true;

    public SoundScreen(MainGame game){
        this.game=game;
    }

    @Override
    public void show() {
        SoundManager.create();
        Sound_Screen = new Texture("Sound_Screen.png");
        SoundCircleImg = new Texture("Circle.png");
        mute = new Texture("Mute.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(Sound_Screen,0f,0f);
        game.batch.draw(SoundCircleImg,SoundCircleX[SoundCircleIndx],SoundCircleY[SoundCircleIndx],SoundCircleWidth,SoundCircleHight);


        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            SoundManager.MenuMoving.stop();
            SoundManager.MenuMoving.play();
            SoundCircleIndx++;
            if(SoundCircleIndx>=2) SoundCircleIndx=0;
        }

        else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            SoundManager.MenuMoving.stop();
            SoundManager.MenuMoving.play();
            SoundCircleIndx--;
            if(SoundCircleIndx<0) SoundCircleIndx=1;
        }


        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && SoundCircleIndx==0){
            SoundState = true;
            this.dispose();
            SoundManager.MenuSelection.play();
            game.setScreen(new MenuScreen(game,SoundState));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && SoundCircleIndx==1){
            SoundState = false;
            this.dispose();
            SoundManager.MenuSelection.play();
            game.setScreen(new MenuScreen(game,SoundState));
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
