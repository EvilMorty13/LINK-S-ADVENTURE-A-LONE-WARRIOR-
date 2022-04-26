package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import java.security.Key;

public class MenuScreen implements Screen {

    MainGame game;

    Texture mainMenuImg;
    Texture circleImg;

    private static final int circleWidth=22;
    private static final int circleHight=13;


    int count=0;

    final int[] circleX = new int[]{1160,1144,1068,1132};
    final int[] circleY = new int[]{272,224,176,128};

    int circleIndx=0;

    public MenuScreen(MainGame game){
        this.game=game;

    }
    @Override
    public void show() {
        mainMenuImg=new Texture("Menu.png");
        circleImg = new Texture("Circle.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        game.batch.begin();
        game.batch.draw(mainMenuImg,0,0);
        game.batch.draw(circleImg,circleX[circleIndx],circleY[circleIndx],circleWidth,circleHight);

        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            circleIndx++;
            if(circleIndx>=4) circleIndx=0;
        }

        else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            circleIndx--;
            if(circleIndx<0) circleIndx=3;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==0){
            this.dispose();
            game.setScreen(new InsideStart(game));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==3){
            this.dispose();
            game.setScreen(new CreditsScreen(game));
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
