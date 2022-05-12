package Play;

import EnemyDeath.Death;
import Menu.MenuScreen;
import ObstacleDetection.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MainGame;
import obstacleCordinateChange.*;
import obstacleDetectionConditon.*;
import HerosAnimation.*;
import Sound.*;
import BombAnimation.*;
import BombCordinateChange.*;
import EnemyMovement.*;
import EnemiesCordinateChange.*;
import obstacles.*;
import Enemies.*;
import BombCounter.*;
import HeartCounter.*;
import KeysCollect.*;
import EnemyDeath.*;

import java.util.ArrayList;

public class InsideStart implements Screen {
    MainGame game;
    Texture gameMap;
    Texture gameMap2;
    Texture mute;


    Texture StandRight;
    Texture StandLeft;
    Texture StandUp;
    Texture StandDown;

    float gameMapX=0;
    float gameMapY=0;
    float gameMapWidth=2000;
    float gameMapHight=720;

    boolean RightStand=true;
    boolean LeftStand=false;
    boolean UpStand=false;
    boolean DownStand=false;

    boolean DoorOpen=false;

    float time;

    public float HeroX=70;
    public float HeroY=70;
    public float checkPointX=70;
    public float checkPointY=70;
    boolean allClear=false;

    float playX1=30;
    float playX2=1140;

    float HeroLeftLimit=-30;
    float HeroRightLimit=1210;

    float MapLimitX1=0;
    float MapLimitX2=-712;

    //mute
    float muteX=1000;
    float muteY=2;

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

    //Enemies death
    //Death death;
    ArrayList<Death> deaths;
    soulCoordinateChange soul;

    //Soul collect
    Texture[] soulCollect;
    int totalEnemy=17;
    float soulX=1020;
    float soulY=-10;

    //Enemies Vertical moves
    ArrayList<enemiesVerticalMovement> enemies2;

    //Bomb counter
    ArrayList<showBomb> bombShow = new ArrayList<>();
    int bombCounter=5;

    //Heart counter
    ArrayList<showHeart> hearts = new ArrayList<>();
    int heartCounter=0;

    //keys
    ArrayList<showKeys> keys;
    keysCoordinateChange keysLocationChange=new keysCoordinateChange();

    //menuKeys
    ArrayList<menuKeys> mKeys;
    float mKeysCounter=0;
    public float mKeysX;
    public float mKeysY;
    float mKeysDiff=30;
    int keyChose=0;

    //princess
    princess Princess;
    float princessX=1066,princessY=270;

    //fog
    ArrayList<smoke> fog;
    smokeList fogList;

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

        //enemies death
        deaths = new ArrayList<>();
        soul = new soulCoordinateChange();

        //soul collect
        soulCollect = new Texture[18];

        //keys
        keys = new ArrayList<>();
        keys = new keysList().get();
        mKeys = new ArrayList<>();
        mKeysX=150;
        mKeysY=-28;

        //Bombs show
        bombShow = new bombList().get();

        //Heart show
        hearts = new heartList().get();

        //princess
        Princess = new princess(princessX,princessY);

        //smoke
        fog = new ArrayList<>();
        fogList=new smokeList();
        fog = fogList.get();

    }

    @Override
    public void show() {
        gameMap=new Texture("Map/Map.png");
        gameMap2=new Texture("Map/Map_2.png");
        mute = new Texture("Others/Mute.png");
        StandRight = new Texture("Stand/Stand_Right.png");
        StandLeft = new Texture("Stand/Stand_Left.png");
        StandUp = new Texture("Stand/Stand_Up.png");
        StandDown = new Texture("Stand/Stand_Down.png");
        for(int i=0;i<18;i++){
            if(i<10) soulCollect[i] = new Texture("Number/Number_0"+i+".png");
            else soulCollect[i] = new Texture("Number/Number_"+i+".png");
        }
    }

    @Override
    public void render(float delta) {

        time+=delta;
        ScreenUtils.clear(0,1,1,1);
        game.batch.begin();

        //game ending
        if(HeroX>=princessX-50 && HeroX<=princessX+50 && HeroY>=princessY-50 && HeroY<=princessY+50){
            this.dispose();
            game.setScreen(new endingWin(game,soundState));
        }

        if(heartCounter==3){
            this.dispose();
            game.setScreen(new endingLose(game,soundState));
        }
        if(keys.size()==0 && enemies.size()==0 && enemies2.size()==0){
            game.batch.draw(gameMap2,gameMapX,gameMapY,gameMapWidth,gameMapHight);
            if(!DoorOpen){SoundManager.Explosion.play();}
            allClear=true;
            DoorOpen=true;
            for(smoke s : fog){
                if(!s.done){
                    s.update(0.1f);
                    s.render(game.batch);
                }
            }
        }
        else game.batch.draw(gameMap,gameMapX,gameMapY,gameMapWidth,gameMapHight);

        Princess.update(0.2f,princessX,princessY);
        Princess.render(game.batch);

        ArrayList<showKeys> removeKeys = new ArrayList<>();
        for(showKeys k : keys){
            k.update(0.2f,HeroX,HeroY);
            if(k.remove){
                SoundManager.KeyFoundSound.stop();
                SoundManager.KeyFoundSound.play();
                checkPointX=k.x;
                checkPointY=k.y;
                removeKeys.add(k);
                mKeys.add(new menuKeys(mKeysX+mKeysCounter*mKeysDiff,mKeysY));
                mKeysCounter++;
                keyChose=k.index;
            }
            k.render(game.batch);
        }keys.removeAll(removeKeys);
        //System.out.println("keys :: "+keys.size());

        for(menuKeys k : mKeys){
            k.render(game.batch);
        }

        for(Bomb b : bombs){
            b.render(game.batch);
        }

        for(Death d : deaths){
            d.render(game.batch);
        }

        ArrayList<Death> deathRemove = new ArrayList<>();
        for(Death d : deaths){
            d.update(0.2f);
            if(d.remove) deathRemove.add(d);
        }deaths.removeAll(deathRemove);


        ArrayList<enemiesHorizontalMovement> Removed = new ArrayList<>();
        for(enemiesHorizontalMovement e : enemies){
            e.update(0.1f,HeroX,HeroY);
            if(e.remove){
                Removed.add(e);
                deaths.add(new Death(e.posX,e.posY));
            }
            if(e.enemyAttack>=100){
                heartCounter++;
                e.enemyAttack=0;
                if(keyChose<3){
                    while(gameMapX<MapLimitX1-50){
                        posChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26, obs.obsHome);
                        bombNegChange.change(bombs);
                        enNegChange.change(enemies);
                        enNegChange.change2(enemies2);
                        soul.negChange(deaths);
                        keysLocationChange.negChange(keys);
                        checkPointX+=4;
                        HeroLeftLimit+=4;
                        gameMapX+=4;
                        princessX+=4;
                        fogList.negativeChange();
                    }
                }
                else if(keyChose==3){
                    while(gameMapX>MapLimitX2+100){
                        negChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26, obs.obsHome);
                        bombPosChange.change(bombs);
                        enPosChange.change(enemies);
                        enPosChange.change2(enemies2);
                        keysLocationChange.posChange(keys);
                        soul.posChange(deaths);
                        checkPointX-=4;
                        HeroLeftLimit-=4;
                        princessX-=4;
                        gameMapX-=4;
                        fogList.positiveChange();
                    }
                }
                HeroX=checkPointX;
                HeroY=checkPointY;
            }
            e.render(game.batch);
        }
        enemies.removeAll(Removed);

        ArrayList<enemiesVerticalMovement> Removed2 = new ArrayList<>();
        for(enemiesVerticalMovement e : enemies2){
            e.update(0.1f,HeroX,HeroY);
            if(e.remove){
                Removed2.add(e);
                deaths.add(new Death(e.posX,e.posY));
            }
            if(e.enemyAttack>=100){
                heartCounter++;
                e.enemyAttack=0;
                if(keyChose<3){
                    while(gameMapX<MapLimitX1-50){
                        posChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26,obs.obsHome);
                        bombNegChange.change(bombs);
                        enNegChange.change(enemies);
                        enNegChange.change2(enemies2);
                        soul.negChange(deaths);
                        keysLocationChange.negChange(keys);
                        checkPointX+=4;
                        HeroLeftLimit+=4;
                        princessX+=4;
                        gameMapX+=4;
                        fogList.negativeChange();
                    }
                }
                else if(keyChose==3){
                    while(gameMapX>MapLimitX2+100){
                        negChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26, obs.obsHome);
                        bombPosChange.change(bombs);
                        enPosChange.change(enemies);
                        soul.posChange(deaths);
                        enPosChange.change2(enemies2);
                        keysLocationChange.posChange(keys);
                        checkPointX-=4;
                        HeroLeftLimit-=4;
                        princessX-=4;
                        fogList.positiveChange();
                        gameMapX-=4;
                    }
                }
                HeroX=checkPointX;
                HeroY=checkPointY;
            }
            e.render(game.batch);
        }
        enemies2.removeAll(Removed2);

        if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            this.dispose();
            SoundManager.MenuBack.play();
            game.setScreen(new MenuScreen(game,soundState));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            SoundManager.BombDrop.stop();
            SoundManager.BombDrop.play();
            if(bombCounter>0) bombs.add(new Bomb(HeroX,HeroY));
            bombCounter--;
        }
        ArrayList<Bomb> toRemove = new ArrayList<Bomb>();

        for(Bomb b : bombs){
            b.update(0.05f);
            for(enemiesHorizontalMovement e : enemies){
                if(e.posX>=b.x-b.damageLimit && e.posX<=b.x+b.damageLimit && e.posY>=b.y-b.damageLimit && e.posY<=b.y+b.damageLimit){
                    Removed.add(e);
                    if(b.remove) deaths.add(new Death(e.posX,e.posY));
                }
            }
            for(enemiesVerticalMovement e : enemies2){
                if(e.posX>=b.x-b.damageLimit && e.posX<=b.x+b.damageLimit && e.posY>=b.y-b.damageLimit && e.posY<=b.y+b.damageLimit){
                    Removed2.add(e);
                    if(b.remove) deaths.add(new Death(e.posX,e.posY));
                }
            }
            if(b.remove){
                toRemove.add(b);
                enemies.removeAll(Removed);

                enemies2.removeAll(Removed2);
                if(HeroX>=b.x-b.damageLimit && HeroX<=b.x+b.damageLimit && HeroY>=b.y-b.damageLimit && HeroY<=b.y+b.damageLimit){
                    if(keyChose<3){
                        while(gameMapX<MapLimitX1-50){
                            posChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26, obs.obsHome);
                            bombNegChange.change(bombs);
                            enNegChange.change(enemies);
                            enNegChange.change2(enemies2);
                            soul.negChange(deaths);
                            keysLocationChange.negChange(keys);
                            checkPointX+=4;
                            HeroLeftLimit+=4;
                            princessX+=4;
                            gameMapX+=4;
                            fogList.negativeChange();
                        }
                    }
                    else if(keyChose==3){
                        while(gameMapX>MapLimitX2+100){
                            negChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26, obs.obsHome);
                            bombPosChange.change(bombs);
                            enPosChange.change(enemies);
                            enPosChange.change2(enemies2);
                            soul.posChange(deaths);
                            keysLocationChange.posChange(keys);
                            checkPointX-=4;
                            HeroLeftLimit-=4;
                            princessX-=4;
                            gameMapX-=4;
                            fogList.positiveChange();
                        }
                    }
                    HeroX=checkPointX;
                    HeroY=checkPointY;
                    heartCounter++;
                }
            }
        }
        bombs.removeAll(toRemove);



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
                    negChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26, obs.obsHome);
                    bombPosChange.change(bombs);
                    enPosChange.change(enemies);
                    enPosChange.change2(enemies2);
                    soul.posChange(deaths);
                    keysLocationChange.posChange(keys);
                    checkPointX-=4;
                    HeroLeftLimit-=4;
                    fogList.positiveChange();
                    princessX-=4;
                }

            }
            else HeroX+=4;
            if(HeroX>HeroRightLimit) HeroX=HeroRightLimit;
            else HeroX = rightCheck.check(HeroX, HeroY, obs.obs5, obs.obs6, obs.obs7, obs.obs8, obs.obs9, obs.obs10, obs.obs11, obs.obs12, obs.obs14, obs.obs15, obs.obs16, obs.obs17, obs.obs17_bridge, obs.obs18, obs.obs19, obs.obs20, obs.obs21, obs.obs22, obs.obs23, obs.obs24, obs.obs25, obs.obs26, obs.obsHome, allClear);

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
                    posChange.change(obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs10,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26,obs.obsHome);
                    bombNegChange.change(bombs);
                    enNegChange.change(enemies);
                    enNegChange.change2(enemies2);
                    keysLocationChange.negChange(keys);
                    soul.negChange(deaths);
                    checkPointX+=4;
                    HeroLeftLimit+=4;
                    fogList.negativeChange();
                    princessX+=4;
                }
            }
            else HeroX-=4;
            if(HeroX< HeroLeftLimit) HeroX=HeroLeftLimit;
            else HeroX = leftCheck.check(HeroX,HeroY,obs.obs3,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs26,obs.obsHome,allClear);

            game.batch.draw((TextureRegion) link.LeftMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){

            RightStand=false;
            LeftStand=false;
            UpStand=true;
            DownStand=false;
            HeroY+=4;
            HeroY=upCheck.check(HeroX,HeroY,obs.obs2,obs.obs3,obs.obs4,obs.obs5,obs.obs7,obs.obs8,obs.obs9,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26,obs.obsHome,allClear);
            game.batch.draw((TextureRegion) link.UpMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){

            RightStand=false;
            LeftStand=false;
            UpStand=false;
            DownStand=true;
            HeroY-=4;
            HeroY = downCheck.check(HeroX,HeroY,obs.obs1,obs.obs4,obs.obs5,obs.obs6,obs.obs7,obs.obs8,obs.obs9,obs.obs11,obs.obs12,obs.obs14,obs.obs15,obs.obs16,obs.obs17,obs.obs17_bridge,obs.obs18,obs.obs19,obs.obs20,obs.obs21,obs.obs22,obs.obs23,obs.obs24,obs.obs25,obs.obs26, obs.obsHome);
            game.batch.draw((TextureRegion) link.DownMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.A)){ // sword animation
            SoundManager.SwordSlash.play();
            if(RightStand) {
                for(enemiesHorizontalMovement e : enemies){
                    if(e.attack && e.leftAttack && link.RightSwordMovement.isAnimationFinished(time)) e.linkAttack++;
                }
                for(enemiesVerticalMovement e : enemies2){
                    if(e.attack && e.leftAttack && link.RightSwordMovement.isAnimationFinished(time)) e.linkAttack++;
                }
                game.batch.draw((TextureRegion) link.RightSwordMovement.getKeyFrame(time, true), HeroX, HeroY);
            }
            else if(LeftStand) {
                for(enemiesHorizontalMovement e : enemies){
                    if(e.attack && e.rightAttack && link.LeftSwordMovement.isAnimationFinished(time)) e.linkAttack++;
                }
                for(enemiesVerticalMovement e : enemies2){
                    if(e.attack && e.rightAttack && link.LeftSwordMovement.isAnimationFinished(time)) e.linkAttack++;
                }
                game.batch.draw((TextureRegion) link.LeftSwordMovement.getKeyFrame(time, true), HeroX, HeroY);
            }
            else if(UpStand) {
                for(enemiesHorizontalMovement e : enemies){
                    if(e.attack && e.downAttack && link.UpSwordMovement.isAnimationFinished(time)) e.linkAttack++;
                }
                for(enemiesVerticalMovement e : enemies2){
                    if(e.attack && e.downAttack && link.UpSwordMovement.isAnimationFinished(time)) e.linkAttack++;
                }
                game.batch.draw((TextureRegion) link.UpSwordMovement.getKeyFrame(time, true), HeroX, HeroY);
            }
            else if(DownStand) {
                for(enemiesHorizontalMovement e : enemies){
                    if(e.attack && e.upAttack && link.DownSwordMovement.isAnimationFinished(time)) e.linkAttack++;
                }
                for(enemiesVerticalMovement e : enemies2){
                    if(e.attack && e.upAttack && link.DownSwordMovement.isAnimationFinished(time)) e.linkAttack++;
                }
                game.batch.draw((TextureRegion) link.DownSwordMovement.getKeyFrame(time, true), HeroX, HeroY);
            }
        }

        else if(RightStand) game.batch.draw(StandRight,HeroX,HeroY);
        else if(LeftStand) game.batch.draw(StandLeft,HeroX,HeroY);
        else if(UpStand) game.batch.draw(StandUp,HeroX,HeroY);
        else if(DownStand) game.batch.draw(StandDown,HeroX,HeroY);

        ArrayList<showHeart> removeHeart = new ArrayList<>();
        for(showHeart h : hearts){
            if(h.index==heartCounter) removeHeart.add(h);
            h.render(game.batch);
        }hearts.removeAll(removeHeart);

        ArrayList<showBomb> showBombRemove = new ArrayList<>();
        for(showBomb b : bombShow){
            if(b.index==bombCounter+1) showBombRemove.add(b);
            b.render(game.batch);
        }bombShow.removeAll(showBombRemove);

        if(!soundState){game.batch.draw(mute,muteX,muteY,30,30);}

        game.batch.draw(soulCollect[totalEnemy-(enemies.size()+enemies2.size())],soulX,soulY);

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
