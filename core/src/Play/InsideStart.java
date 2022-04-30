package Play;

import Menu.MenuScreen;
import ObstacleDetection.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MainGame;
import jdk.tools.jmod.Main;
import obstacleCordinateChange.*;
import obstacleDetectionConditon.*;
import HerosAnimation.*;
import Sound.*;

public class InsideStart implements Screen {
    MainGame game;
    Texture gameMap;

    float gameMapX=0;
    float gameMapY=0;
    float gameMapWidth=2000;
    float gameMapHight=720;

    boolean RightStand=true;
    boolean LeftStand=false;
    boolean UpStand=false;
    boolean DownStand=false;


    float time;

    public float HeroX=70;
    public float HeroY=70;

    float playX1=30;
    float playX2=1140;

    float HeroLeftLimit=-30;
    float HeroRightLimit=1210;

    float MapLimitX1=0;
    float MapLimitX2=-712;

    //Obstacle Part
    obstacle1 obs1=new obstacle1();
    obstacle2 obs2=new obstacle2();
    obstacle3 obs3=new obstacle3();
    obstacle4 obs4=new obstacle4();
    obstacle5 obs5=new obstacle5();
    obstacle6 obs6=new obstacle6();
    obstacle7 obs7=new obstacle7();
    obstacle8 obs8=new obstacle8();
    obstacle9 obs9=new obstacle9();
    obstacle10 obs10=new obstacle10();
    obstacle11 obs11=new obstacle11();
    obstacle12 obs12=new obstacle12();
    obstacle14 obs14=new obstacle14();
    obstacle15 obs15=new obstacle15();
    obstacle16 obs16=new obstacle16();
    obstacle17 obs17=new obstacle17();
    obstacle17_bridge obs17_bridge = new obstacle17_bridge();
    obstacle18 obs18=new obstacle18();
    obstacle19 obs19=new obstacle19();
    obstacle20 obs20=new obstacle20();
    obstacle21 obs21=new obstacle21();
    obstacle22 obs22=new obstacle22();
    obstacle23 obs23=new obstacle23();
    obstacle24 obs24=new obstacle24();
    obstacle25 obs25=new obstacle25();
    obstacle26 obs26=new obstacle26();

    //Animation of Hero
    LinksAnimation link = new LinksAnimation();

    //obstacle coordinate change
    obstacleCordinateChangeXneg negChange = new obstacleCordinateChangeXneg();
    obstacleCordinateChangeXpos posChange = new obstacleCordinateChangeXpos();

    //obstacle Detection
    obstacleDetectionConditionRight rightCheck = new obstacleDetectionConditionRight();
    obstacleDetectionCondtionLeft leftCheck = new obstacleDetectionCondtionLeft();
    obstacleDetectionConditionUp upCheck = new obstacleDetectionConditionUp();
    obstacleDetectionCondtionDown downCheck = new obstacleDetectionCondtionDown();

    public boolean soundState;
    public InsideStart(MainGame game,boolean soundState){
        this.game=game;
        this.soundState=soundState;

        SoundManager.create();
        SoundManager.MainTheme.setLooping(true);
        SoundManager.MainTheme.setVolume(0.1f);
        if(soundState) SoundManager.MainTheme.play();

    }

    @Override
    public void show() {
        gameMap=new Texture("ultraFinalMap.png");
    }

    @Override
    public void render(float delta) {

        time+=delta;
        ScreenUtils.clear(0,1,1,1);
        game.batch.begin();
        game.batch.draw(gameMap,gameMapX,gameMapY,gameMapWidth,gameMapHight);

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){

            RightStand=true;
            LeftStand=false;
            UpStand=false;
            DownStand=false;
            if(HeroX>=playX1){
                gameMapX-=4;
                if(gameMapX<MapLimitX2){
                    gameMapX=MapLimitX2;
                    HeroX+=4;
                }
                else{
                    negChange.change(obs3,obs4,obs5,obs6,obs7,obs8,obs9,obs10,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs25,obs26);
                    HeroLeftLimit-=4;
                }

            }
            else HeroX+=4;
            if(HeroX>HeroRightLimit) HeroX=HeroRightLimit;
            else HeroX = rightCheck.check(HeroX, HeroY, obs5, obs6, obs7, obs8, obs9, obs10, obs11, obs12, obs14, obs15, obs16, obs17, obs17_bridge, obs18, obs19, obs20, obs21, obs22, obs23, obs24, obs25, obs26);

            game.batch.draw((TextureRegion) link.RightMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){

            RightStand=false;
            LeftStand=true;
            UpStand=false;
            DownStand=false;
            if(HeroX<=playX2){
                gameMapX+=4;
                if(gameMapX>MapLimitX1){
                    gameMapX=MapLimitX1;
                    HeroX-=4;
                }
                else{
                    posChange.change(obs3,obs4,obs5,obs6,obs7,obs8,obs9,obs10,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs25,obs26);
                    HeroLeftLimit+=4;
                }
            }
            else HeroX-=4;
            if(HeroX< HeroLeftLimit) HeroX=HeroLeftLimit;
            else HeroX = leftCheck.check(HeroX,HeroY,obs3,obs4,obs5,obs6,obs7,obs8,obs9,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs26);

            game.batch.draw((TextureRegion) link.LeftMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){

            RightStand=false;
            LeftStand=false;
            UpStand=true;
            DownStand=false;
            HeroY+=4;
            HeroY=upCheck.check(HeroX,HeroY,obs2,obs3,obs4,obs5,obs7,obs8,obs9,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs25,obs26);
            game.batch.draw((TextureRegion) link.UpMovement.getKeyFrame(time,true),HeroX,HeroY);
            //game.batch.draw((TextureRegion) UpMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){

            RightStand=false;
            LeftStand=false;
            UpStand=false;
            DownStand=true;
            HeroY-=4;
            HeroY = downCheck.check(HeroX,HeroY,obs1,obs4,obs5,obs6,obs7,obs8,obs9,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs25,obs26);
            game.batch.draw((TextureRegion) link.DownMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.A)){ // sword animation
            if(RightStand) game.batch.draw((TextureRegion)link.RightSwordMovement.getKeyFrame(time,true),HeroX,HeroY);
            else if(LeftStand) game.batch.draw((TextureRegion)link.LeftSwordMovement.getKeyFrame(time,true),HeroX,HeroY);
            else if(UpStand) game.batch.draw((TextureRegion)link.UpSwordMovement.getKeyFrame(time,true),HeroX,HeroY);
            else if(DownStand) game.batch.draw((TextureRegion)link.DownSwordMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(RightStand) game.batch.draw(new Texture("Stand_Right.png"),HeroX,HeroY);
        else if(LeftStand) game.batch.draw(new Texture("Stand_Left.png"),HeroX,HeroY);
        else if(UpStand) game.batch.draw(new Texture("Stand_Up.png"),HeroX,HeroY);
        else if(DownStand) game.batch.draw(new Texture("Stand_Down.png"),HeroX,HeroY);

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
