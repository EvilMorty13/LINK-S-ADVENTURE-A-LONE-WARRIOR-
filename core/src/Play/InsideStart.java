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
import obstacleCordinateChange.*;
import obstacleDetectionConditon.*;

public class InsideStart implements Screen {
    MainGame game;
    Texture gameMap;

    float gameMapX=0;
    float gameMapY=0;
    float gameMapWidth=2000;
    float gameMapHight=720;

    Animation RightMovement;
    Animation LeftMovement;
    Animation UpMovement;
    Animation DownMovement;


    Animation RightSwordMovement;
    Animation LeftSwordMovement;

    Animation UpSwordMovement;
    Animation DownSwordMovement;


    boolean RightStand=true;
    boolean LeftStand=false;
    boolean UpStand=false;
    boolean DownStand=false;

    Music MenuBack;
    Music MainTheme;

    float time;

    public float HeroX=1008;
    public float HeroY=102;

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

    public InsideStart(MainGame game){
        this.game=game;

        //Character Movement Animation

        TextureRegion[][] tempRight = TextureRegion.split(new Texture("Movement_Right.png"),100,100);
        TextureRegion[][] tempLeft = TextureRegion.split(new Texture("Movement_Left.png"),100,100);
        TextureRegion[][] tempDown = TextureRegion.split(new Texture("Movement_Down.png"),100,100);
        TextureRegion[][] tempUp = TextureRegion.split(new Texture("Movement_Up.png"),100,100);

        //Character Sword Animation

        TextureRegion[][] tempRightSword = TextureRegion.split(new Texture("Right_Sword.png"),100,100);
        TextureRegion[][] tempLeftSword = TextureRegion.split(new Texture("Left_Sword.png"),100,100);
        TextureRegion[][] tempUpSword = TextureRegion.split(new Texture("Up_Sword.png"),100,100);
        TextureRegion[][] tempDownSword = TextureRegion.split(new Texture("Down_Sword.png"),100,100);



        TextureRegion[] moveRight = new TextureRegion[6];
        TextureRegion[] moveLeft = new TextureRegion[6];
        TextureRegion[] moveUp = new TextureRegion[8];
        TextureRegion[] moveDown = new TextureRegion[8];

        TextureRegion[] RightSword = new TextureRegion[5];
        TextureRegion[] LeftSword = new TextureRegion[5];
        TextureRegion[] UpSword = new TextureRegion[5];
        TextureRegion[] DownSword = new TextureRegion[6];

        int indx=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                moveRight[indx]=tempRight[i][j];
                moveLeft[indx]=tempLeft[i][j];

                DownSword[indx]=tempDownSword[i][j];
                if(indx<5){
                    RightSword[indx]=tempRightSword[i][j];
                    LeftSword[indx]=tempLeftSword[i][j];
                    UpSword[indx]=tempUpSword[i][j];
                }
                indx++;
            }
        }

        indx=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                moveUp[indx]=tempUp[i][j];
                moveDown[indx]=tempDown[i][j];
                indx++;
            }
        }

        RightMovement = new Animation(0.08f,moveRight);
        LeftMovement = new Animation(0.08f,moveLeft);
        UpMovement = new Animation(0.08f,moveUp);
        DownMovement = new Animation(0.08f,moveDown);


        RightSwordMovement = new Animation(0.08f,RightSword);
        LeftSwordMovement = new Animation(0.08f,LeftSword);
        UpSwordMovement = new Animation(0.08f,UpSword);
        DownSwordMovement = new Animation(0.08f,DownSword);

        MenuBack = Gdx.audio.newMusic(Gdx.files.internal("Menu_Back.mp3"));
        MainTheme = Gdx.audio.newMusic(Gdx.files.internal("Main_Theme.mp3"));
        MainTheme.setLooping(true);
        MainTheme.setVolume(0.1f);
        MainTheme.play();

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
                    new obstacleCordinateChangeXneg().change(obs3,obs4,obs5,obs6,obs7,obs8,obs9,obs10,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs25,obs26);
                    HeroLeftLimit-=4;
                }

            }
            else HeroX+=4;
            if(HeroX>HeroRightLimit) HeroX=HeroRightLimit;
            else{
                obstacleDetectionConditionRight rightCheck = new obstacleDetectionConditionRight();
                HeroX = rightCheck.check(HeroX, HeroY, obs5, obs6, obs7, obs8, obs9, obs10, obs11, obs12, obs14, obs15, obs16, obs17, obs17_bridge, obs18, obs19, obs20, obs21, obs22, obs23, obs24, obs25, obs26);
            }
            game.batch.draw((TextureRegion) RightMovement.getKeyFrame(time,true),HeroX,HeroY);
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
                    new obstacleCordinateChangeXpos().change(obs3,obs4,obs5,obs6,obs7,obs8,obs9,obs10,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs25,obs26);
                    HeroLeftLimit+=4;
                }
            }
            else HeroX-=4;
            if(HeroX< HeroLeftLimit) HeroX=HeroLeftLimit;
            else{
                obstacleDetectionCondtionLeft leftCheck = new obstacleDetectionCondtionLeft();
                HeroX = leftCheck.check(HeroX,HeroY,obs3,obs4,obs5,obs6,obs7,obs8,obs9,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs26);
            }
            game.batch.draw((TextureRegion) LeftMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){

            RightStand=false;
            LeftStand=false;
            UpStand=true;
            DownStand=false;
            HeroY+=4;
            obstacleDetectionConditionUp upCheck = new obstacleDetectionConditionUp();
            HeroY=upCheck.check(HeroX,HeroY,obs2,obs3,obs4,obs5,obs7,obs8,obs9,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs25,obs26);
            game.batch.draw((TextureRegion) UpMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){

            RightStand=false;
            LeftStand=false;
            UpStand=false;
            DownStand=true;
            HeroY-=4;
            obstacleDetectionCondtionDown downCheck = new obstacleDetectionCondtionDown();
            HeroY = downCheck.check(HeroX,HeroY,obs1,obs4,obs5,obs6,obs7,obs8,obs9,obs11,obs12,obs14,obs15,obs16,obs17,obs17_bridge,obs18,obs19,obs20,obs21,obs22,obs23,obs24,obs25,obs26);
            game.batch.draw((TextureRegion) DownMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.A)){ // sword animation
            if(RightStand) game.batch.draw((TextureRegion)RightSwordMovement.getKeyFrame(time,true),HeroX,HeroY);
            else if(LeftStand) game.batch.draw((TextureRegion)LeftSwordMovement.getKeyFrame(time,true),HeroX,HeroY);
            else if(UpStand) game.batch.draw((TextureRegion)UpSwordMovement.getKeyFrame(time,true),HeroX,HeroY);
            else if(DownStand) game.batch.draw((TextureRegion)DownSwordMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(RightStand) game.batch.draw(new Texture("Stand_Right.png"),HeroX,HeroY);
        else if(LeftStand) game.batch.draw(new Texture("Stand_Left.png"),HeroX,HeroY);
        else if(UpStand) game.batch.draw(new Texture("Stand_Up.png"),HeroX,HeroY);
        else if(DownStand) game.batch.draw(new Texture("Stand_Down.png"),HeroX,HeroY);

        if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            this.dispose();
            MenuBack.play();
            game.setScreen(new MenuScreen(game));
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
        MainTheme.dispose();
        MenuBack.dispose();
    }
}
