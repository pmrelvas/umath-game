package com.pmrelvas.udamatematica;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pmrelvas.udamatematica.screens.PlayScreen;

public class MathUGame extends Game {

	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100;
	public static final int TILE_SIZE_PX = 16;

	public static final short DEFAULT_BIT = 1;
	public static final short HERO_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short RESULT_BOX_BIT = 8;
	public static final short DESTROYED_BIT = 16;

	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
