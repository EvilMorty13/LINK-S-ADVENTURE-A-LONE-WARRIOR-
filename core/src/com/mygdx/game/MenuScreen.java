package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import java.security.Key;

public class MenuScreen implements Screen {

    MainGame game;

    Texture mainMenuImg;
    Texture circleImg;

    private static final int circleWidth=22;
    private static final int circleHight=13;

    private static final int startX=1165;
    private static final int startY=358;

    int count=0;

    final int[] circleDiffX = new int[]{0,17,17,82,95,30};
    final int[] circleDiffY = new int[]{0,46,91,133,182,226};
    int circleDiffIndx=0;

    public MenuScreen(MainGame game){
        this.game=game;
    }
    @Override
    public void show() {
        mainMenuImg=new Texture("Menu_Demo.png");
        circleImg = new Texture("Circle.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        game.batch.begin();
        game.batch.draw(mainMenuImg,0,0);
        game.batch.draw(circleImg,startX-circleDiffX[circleDiffIndx],startY-circleDiffY[circleDiffIndx],circleWidth,circleHight);
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            circleDiffIndx++;
            if(circleDiffIndx>=6) circleDiffIndx=0;
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            circleDiffIndx--;
            if(circleDiffIndx<0) circleDiffIndx=5;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleDiffIndx==0){
            this.dispose();
            game.setScreen(new InsideStart(game));
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

    }
}
