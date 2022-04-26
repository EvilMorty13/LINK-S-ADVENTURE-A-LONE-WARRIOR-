package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

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

    boolean RightStand=true;
    boolean LeftStand=false;
    boolean UpStand=false;
    boolean DownStand=false;

    float time;

    float HeroX=70;
    float HeroY=70;

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

    public InsideStart(MainGame game){
        this.game=game;

        //Character Animation

        //Texture img33 = new Texture("Movement.png");
        TextureRegion[][] tempRight = TextureRegion.split(new Texture("Movement_Right.png"),100,100);
        TextureRegion[][] tempLeft = TextureRegion.split(new Texture("Movement_Left.png"),100,100);
        TextureRegion[][] tempDown = TextureRegion.split(new Texture("Movement_Down.png"),100,100);
        TextureRegion[][] tempUp = TextureRegion.split(new Texture("Movement_Up.png"),100,100);

        TextureRegion[] moveRight = new TextureRegion[6];
        TextureRegion[] moveLeft = new TextureRegion[6];
        TextureRegion[] moveUp = new TextureRegion[8];
        TextureRegion[] moveDown = new TextureRegion[8];

        int indx=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                moveRight[indx]=tempRight[i][j];
                moveLeft[indx]=tempLeft[i][j];
                ++indx;
            }
        }
        indx=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                moveUp[indx]=tempUp[i][j];
                moveDown[indx]=tempDown[i][j];
                ++indx;
            }
        }

        RightMovement = new Animation(0.08f,moveRight);
        LeftMovement = new Animation(0.08f,moveLeft);
        UpMovement = new Animation(0.08f,moveUp);
        DownMovement = new Animation(0.08f,moveDown);

    }
    @Override
    public void show() {
        gameMap=new Texture("Final_Map2.png");
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
                    obs3.limitX-=4;
                    obs4.limitX1-=4;
                    obs4.limitX2-=4;
                    obs5.limitX1-=4;
                    obs5.limitX2-=4;
                    HeroLeftLimit-=4;
                }

            }
            else HeroX+=4;
            if(HeroX>HeroRightLimit) HeroX=HeroRightLimit;
            else if(HeroY>obs5.limitY1 && HeroY<obs5.limitY2 && HeroX<obs5.limitX2 && HeroX>=obs5.limitX1) HeroX=obs5.limitX1;
            System.out.println("HeroX :: "+HeroX+" HeroY :: "+HeroY);
            System.out.println("gameMapX :: "+gameMapX+" gameMapY :: "+gameMapY);
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
                    obs3.limitX+=4;
                    obs4.limitX1+=4;
                    obs4.limitX2+=4;
                    obs5.limitX1+=4;
                    obs5.limitX2+=4;
                    HeroLeftLimit+=4;
                }

            }
            else HeroX-=4;
            if(HeroX< HeroLeftLimit) HeroX=HeroLeftLimit;
            else if(HeroY>obs3.limitY && HeroX<=obs3.limitX) HeroX=obs3.limitX;
            else if(HeroY>obs4.limitY1 && HeroY<obs4.limitY2 && HeroX<=obs4.limitX2) HeroX=obs4.limitX2;
            else if(HeroY>obs5.limitY1 && HeroY<obs5.limitY2 && HeroX>obs5.limitX1 && HeroX<=obs5.limitX2) HeroX=obs5.limitX2;
            System.out.println("HeroX :: "+HeroX+" HeroY :: "+HeroY);
            System.out.println("gameMapX :: "+gameMapX+" gameMapY :: "+gameMapY);
            game.batch.draw((TextureRegion) LeftMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){

            RightStand=false;
            LeftStand=false;
            UpStand=true;
            DownStand=false;
            HeroY+=4;
            if(HeroY>=obs2.limitY) HeroY=obs2.limitY;
            else if(HeroX<obs3.limitX && HeroY>=obs3.limitY) HeroY=obs3.limitY;
            else if(HeroX>=obs4.limitX1 && HeroX<obs4.limitX2 && HeroY<obs4.limitY2 && HeroY>=obs4.limitY1) HeroY= obs4.limitY1;
            else if(HeroX>obs5.limitX1 && HeroX<obs5.limitX2 && HeroY<obs5.limitY2 && HeroY>=obs5.limitY1) HeroY=obs5.limitY1;
            System.out.println("HeroX :: "+HeroX+" HeroY :: "+HeroY);
            System.out.println("gameMapX :: "+gameMapX+" gameMapY :: "+gameMapY);
            game.batch.draw((TextureRegion) UpMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){

            RightStand=false;
            LeftStand=false;
            UpStand=false;
            DownStand=true;
            HeroY-=4;
            if(HeroY<=obs1.limitY) HeroY=obs1.limitY;
            else if(HeroX>=obs4.limitX1 && HeroX<obs4.limitX2 && HeroY>obs4.limitY1 && HeroY<=obs4.limitY2) HeroY=obs4.limitY2;
            else if(HeroX>obs5.limitX1 && HeroX<obs5.limitX2 && HeroY>obs5.limitY1 && HeroY<=obs5.limitY2) HeroY=obs5.limitY2;
            System.out.println("HeroX :: "+HeroX+" HeroY :: "+HeroY);
            System.out.println("gameMapX :: "+gameMapX+" gameMapY :: "+gameMapY);
            game.batch.draw((TextureRegion) DownMovement.getKeyFrame(time,true),HeroX,HeroY);
        }

        else if(RightStand) game.batch.draw(new Texture("Stand_Right.png"),HeroX,HeroY);
        else if(LeftStand) game.batch.draw(new Texture("Stand_Left.png"),HeroX,HeroY);
        else if(UpStand) game.batch.draw(new Texture("Stand_Up.png"),HeroX,HeroY);
        else if(DownStand) game.batch.draw(new Texture("Stand_Down.png"),HeroX,HeroY);

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

    }
}
