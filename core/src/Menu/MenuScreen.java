package Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import Credit.CreditsScreen;
import Play.InsideStart;
import Instructions.InstructionScreen;
import com.mygdx.game.MainGame;
import Sound.*;

public class MenuScreen implements Screen {

    MainGame game;

    Texture mainMenuImg;
    Texture circleImg;

    private static final int circleWidth=22;
    private static final int circleHight=13;


    int count=0;

    final int[] circleX = new int[]{1160,1144,1068,1132,1176};
    final int[] circleY = new int[]{320,272,224,176,130};

    int circleIndx=0;




    public MenuScreen(MainGame game){
        this.game=game;
    }
    @Override
    public void show() {

        SoundManager.create();

        SoundManager.Background.setLooping(true);
        SoundManager.Background.setVolume(0.2f);
        SoundManager.Background.play();

        mainMenuImg=new Texture("Menu2.png");
        circleImg = new Texture("Circle.png");
    }

    @Override
    public void render(float delta) {


        ScreenUtils.clear(0,0,0,1);
        game.batch.begin();
        game.batch.draw(mainMenuImg,0,0);
        game.batch.draw(circleImg,circleX[circleIndx],circleY[circleIndx],circleWidth,circleHight);

        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            SoundManager.MenuMoving.stop();
            SoundManager.MenuMoving.play();
            circleIndx++;
            if(circleIndx>=5) circleIndx=0;
        }

        else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            SoundManager.MenuMoving.stop();
            SoundManager.MenuMoving.play();
            circleIndx--;
            if(circleIndx<0) circleIndx=4;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==0){
            this.dispose();
            SoundManager.MenuSelection.play();
            game.setScreen(new InsideStart(game));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==1){
            this.dispose();
            SoundManager.MenuSelection.play();
            game.setScreen(new SoundScreen(game));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==2){
            this.dispose();
            SoundManager.MenuSelection.play();
            game.setScreen(new InstructionScreen(game));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==3){
            this.dispose();
            SoundManager.MenuSelection.play();
            game.setScreen(new CreditsScreen(game));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==4){
            this.dispose();
            SoundManager.MenuSelection.play();
            Gdx.app.exit();
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
