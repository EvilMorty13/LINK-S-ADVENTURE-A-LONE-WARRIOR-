package Play;

import Menu.MenuScreen;
import ObstacleDetection.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MainGame;
import obstacleCordinateChange.*;
import obstacleDetectionConditon.*;
import HerosAnimation.*;
import Sound.*;
import BombAnimation.*;
import BombCordinateChange.*;
import EnemyHorizontalMovesCollections.*;
import EnemyVerticalMovesCollections.*;
import EnemyMovement.*;
import EnemiesCordinateChange.*;
import obstacles.*;
import Enemies.*;

import java.util.ArrayList;

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
    obstaclesCollection obs = new obstaclesCollection();

    //Animation of Hero
    LinksAnimation link = new LinksAnimation();

    //Bomb animation
    ArrayList<Bomb> bombs;
    BombCoordinateChangePos bombPosChange = new BombCoordinateChangePos();
    BombCoordinateChangeNeg bombNegChange = new BombCoordinateChangeNeg();

    //Enemies Horizontal moves
    ArrayList<enemiesHorizontalMovement> enemies;
    enemiesPosChange enPosChange = new enemiesPosChange();
    enemiesNegChange enNegChange = new enemiesNegChange();

    //Enemies Vertical moves
    ArrayList<enemiesVerticalMovement> enemies2;

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
        bombs = new ArrayList<Bomb>();
        enemies = new ArrayList<enemiesHorizontalMovement>();
        enemies2 = new ArrayList<enemiesVerticalMovement>();

        //Horizontal Enemies
        enemies = new HorizontalEnemies().get();

        //Vertical Enemies
        enemies2 = new VerticalEnemies().get();
    }

    @Override
    public void show() {
        gameMap=new Texture("FM.png");
    }

    @Override
    public void render(float delta) {

        time+=delta;
        ScreenUtils.clear(0,1,1,1);
        game.batch.begin();
        game.batch.draw(gameMap,gameMapX,gameMapY,gameMapWidth,gameMapHight);

        if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            this.dispose();
            SoundManager.MenuBack.play();
            game.setScreen(new MenuScreen(game,soundState));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            bombs.add(new Bomb(HeroX,HeroY));
        }
        ArrayList<Bomb> toRemove = new ArrayList<Bomb>();
        for(Bomb b : bombs){
            b.update(0.02f);
            if(b.remove) toRemove.add(b);
        }
        bombs.removeAll(toRemove);
        for(Bomb b : bombs){
            b.render(game.batch);
        }

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
                    negChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26);
                    bombPosChange.change(bombs);
                    enPosChange.change(enemies);
                    enPosChange.change2(enemies2);
                    HeroLeftLimit-=4;
                }

            }
            else HeroX+=4;
            if(HeroX>HeroRightLimit) HeroX=HeroRightLimit;
            else HeroX = rightCheck.check(HeroX, HeroY, obs.obs5, obs.obs6, obs.obs7, obs.obs8, obs.obs9, obs.obs10, obs.obs11, obs.obs12, obs.obs14, obs.obs15, obs.obs16, obs.obs17, obs.obs17_bridge, obs.obs18, obs.obs19, obs.obs20, obs.obs21, obs.obs22, obs.obs23, obs.obs24, obs.obs25, obs.obs26);

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
                    posChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26);
                    bombNegChange.change(bombs);
                    enNegChange.change(enemies);
                    enNegChange.change2(enemies2);
                    HeroLeftLimit+=4;
                }
            }
            else HeroX-=4;
            if(HeroX< HeroLeftLimit) HeroX=HeroLeftLimit;
            else HeroX = leftCheck.check(HeroX,HeroY,obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs26);

            game.batch.draw((TextureRegion) link.LeftMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){

            RightStand=false;
            LeftStand=false;
            UpStand=true;
            DownStand=false;
            HeroY+=4;
            HeroY=upCheck.check(HeroX,HeroY,obs.obs2,obs.obs3,obs.obs4,obs.obs5,obs.obs7,obs.obs8,obs.obs9,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26);
            game.batch.draw((TextureRegion) link.UpMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){

            RightStand=false;
            LeftStand=false;
            UpStand=false;
            DownStand=true;
            HeroY-=4;
            HeroY = downCheck.check(HeroX,HeroY,obs.obs1,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26);
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

        for(enemiesHorizontalMovement e : enemies){
            e.update(0.1f);
            e.render(game.batch);
        }
        for(enemiesVerticalMovement e : enemies2){
            e.update(0.1f);
            e.render(game.batch);
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
