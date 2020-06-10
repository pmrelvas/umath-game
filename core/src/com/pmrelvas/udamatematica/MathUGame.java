package com.pmrelvas.udamatematica;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pmrelvas.udamatematica.screens.PlayScreen;

public class MathUGame extends Game {

	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;

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
