package Play;

import Menu.MenuScreen;
import Sound.SoundManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MainGame;
import Sound.*;

public class endingLose implements Screen {
    MainGame game;
    boolean soundState;
    Texture loseImg;
    Animation dialogue;
    float time;

    Texture circleImg;

    private static final int circleWidth=22;
    private static final int circleHight=13;

    final int[] circleX = new int[]{1105,1085};
    final int[] circleY = new int[]{375,328};

    int circleIndex=0;

    public endingLose(MainGame game,boolean soundState){
        this.game=game;
        this.soundState=soundState;
        TextureRegion[][] tempLuck = TextureRegion.split(new Texture("Text/Luck.png"),500,100);
        TextureRegion[] luckArray = new TextureRegion[18];
        for(int i=0;i<18;i++){
            luckArray[i]=tempLuck[i][0];
        }
        dialogue = new Animation(0.2f,luckArray);
    }

    @Override
    public void show() {
        loseImg = new Texture("Menu/Lose.png");
        circleImg = new Texture("Others/Circle.png");
        SoundManager.create();
    }

    @Override
    public void render(float delta) {
        time+=delta;
        game.batch.begin();
        ScreenUtils.clear(0,0,0,0);
        game.batch.draw(loseImg,0,0);
        game.batch.draw(circleImg,circleX[circleIndex],circleY[circleIndex],circleWidth,circleHight);
        game.batch.draw((TextureRegion) dialogue.getKeyFrame(time,false),50f,540f);
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            SoundManager.MenuMoving.stop();
            SoundManager.MenuMoving.play();
            circleIndex--;
            if(circleIndex<0) circleIndex=1;
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            SoundManager.MenuMoving.stop();
            SoundManager.MenuMoving.play();
            circleIndex++;
            if(circleIndex>1) circleIndex=0;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
            this.dispose();
            SoundManager.MenuSelection.play();
            if(circleIndex==0) game.setScreen(new InsideStart(game,soundState));
            else game.setScreen(new MenuScreen(game,soundState));
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
