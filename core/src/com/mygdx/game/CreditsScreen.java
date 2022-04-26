package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class CreditsScreen implements Screen {
    MainGame game;
    Texture Credits;

    public CreditsScreen(MainGame game){
        this.game=game;
    }

    @Override
    public void show() {
        Credits = new Texture("Credits.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(Credits,0f,0f);

        if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            this.dispose();
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

    }
}
