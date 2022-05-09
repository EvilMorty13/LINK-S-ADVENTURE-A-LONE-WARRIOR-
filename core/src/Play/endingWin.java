package Play;

import Menu.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MainGame;
import Sound.*;

public class endingWin implements Screen {
    MainGame game;
    Texture backgroundImg;
    float time;
    Animation dialogue1;
    boolean done=false;
    boolean done2=false;
    float time2;
    endingWin2 endWin2;
    boolean soundState;

    Texture circleImg;

    private static final int circleWidth=22;
    private static final int circleHight=13;

    final int[] circleX = new int[]{1087,1085};
    final int[] circleY = new int[]{377,328};

    int circleIndex=0;

    public endingWin(MainGame game,boolean soundState){
        this.soundState=soundState;
        this.game=game;
        TextureRegion[][] tempDialogue1 = TextureRegion.split(new Texture("Text/Ending.png"),500,100);

        TextureRegion[] dialogueArray = new TextureRegion[18];

        for(int i=0;i<18;i++){
            dialogueArray[i]=tempDialogue1[i][0];
        }
        dialogue1=new Animation(0.2f,dialogueArray);

        endWin2=new endingWin2();
    }
    @Override
    public void show() {
        backgroundImg=new Texture("Menu/Win.png");
        circleImg = new Texture("Others/Circle.png");
        SoundManager.create();
    }


    @Override
    public void render(float delta) {
        time+=delta;
        time2+=0.5f;
        game.batch.begin();
        ScreenUtils.clear(0,0,0,0);
        game.batch.draw(backgroundImg,0,0);
        game.batch.draw(circleImg,circleX[circleIndex],circleY[circleIndex],circleWidth,circleHight);
        if(dialogue1.isAnimationFinished(time)) done=true;
        game.batch.draw((TextureRegion) dialogue1.getKeyFrame(time,false),600f,40f);
        if(done){
            endWin2.update(0.2f);
            endWin2.render(game.batch);
        }
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
