package com.pmrelvas.udamatematica;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pmrelvas.udamatematica.screens.LoadingScreen;
import com.pmrelvas.udamatematica.screens.MainMenuScreen;
import com.pmrelvas.udamatematica.screens.PlayScreen;
import com.pmrelvas.udamatematica.screens.RightScreen;

import java.util.Arrays;
import java.util.List;

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

	public static final int NUM_LEVELS = 8;
	public static final int LEVEL_1 = 0;
	public static final int LEVEL_2 = 1;
	public static final int LEVEL_3 = 2;
	public static final int LEVEL_4 = 3;
	public static final int LEVEL_5 = 4;
	public static final int LEVEL_6 = 5;
	public static final int LEVEL_7 = 6;
	public static final int LEVEL_8 = 7;

	public List<Boolean> levelAvailable = Arrays.asList(true, false, false, false, false, false, false, false);

	public MainMenuScreen mainMenuScreen;
	public PlayScreen playScreen;
	public RightScreen rightScreen;

	public SpriteBatch batch;
	public AssetManager assets;

	public boolean levelEnded = false;

	private int currentLevel = 1;

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int level) {
		this.currentLevel = level;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		assets = new AssetManager();

		mainMenuScreen = new MainMenuScreen(this);
		playScreen = new PlayScreen(this);
		rightScreen = new RightScreen(this);
		setScreen(new LoadingScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assets.dispose();
	}

	public void levelCompleted() {
		levelAvailable.set(++currentLevel, true);
	}
}
