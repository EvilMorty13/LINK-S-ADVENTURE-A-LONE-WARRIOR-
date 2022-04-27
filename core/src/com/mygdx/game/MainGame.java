package com.mygdx.game;

import Menu.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
	public SpriteBatch batch;
	Texture img;
	public static final int ScreenWidth = 1280;
	public static final int ScreenHeight = 720;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
