package com.pmrelvas.udamatematica.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pmrelvas.udamatematica.MathUGame;

public class MainMenuScreen implements Screen {

    private static final int LEVEL_BOX_SIZE = 50;
    private static final int LEVEL_BOX_SPACING = 10;
    private static final int LEVEL_BOX_HMARGIN = 90;
    private static final int LEVEL1_X = LEVEL_BOX_HMARGIN;
    private static final int LEVEL1_Y = 3 * LEVEL_BOX_SPACING + 2 * LEVEL_BOX_SIZE;
    private static final int LEVEL2_X = LEVEL_BOX_HMARGIN;
    private static final int LEVEL2_Y = 2 * LEVEL_BOX_SPACING + LEVEL_BOX_SIZE;
    private static final int LEVEL3_X = LEVEL_BOX_HMARGIN;
    private static final int LEVEL3_Y = LEVEL_BOX_SPACING;
    private static final int LEVEL4_X = LEVEL_BOX_HMARGIN + LEVEL_BOX_SIZE + LEVEL_BOX_SPACING;
    private static final int LEVEL4_Y = LEVEL_BOX_SPACING;
    private static final int LEVEL5_X = LEVEL_BOX_HMARGIN + 2 * LEVEL_BOX_SIZE + 2 * LEVEL_BOX_SPACING;
    private static final int LEVEL5_Y = LEVEL_BOX_SPACING;
    private static final int LEVEL6_X = LEVEL_BOX_HMARGIN + 3 * LEVEL_BOX_SIZE + 3 * LEVEL_BOX_SPACING;
    private static final int LEVEL6_Y = LEVEL_BOX_SPACING;
    private static final int LEVEL7_X = LEVEL_BOX_HMARGIN + 3 * LEVEL_BOX_SIZE + 3 * LEVEL_BOX_SPACING;
    private static final int LEVEL7_Y = 2 * LEVEL_BOX_SPACING + LEVEL_BOX_SIZE;
    private static final int LEVEL8_X = LEVEL_BOX_HMARGIN + 3 * LEVEL_BOX_SIZE + 3 * LEVEL_BOX_SPACING;
    private static final int LEVEL8_Y = 3 * LEVEL_BOX_SPACING + 2 * LEVEL_BOX_SIZE;

    private final MathUGame game;

    private Stage stage;
    private Viewport viewport;

    private Label lblTitle;

    private ImageButton btnLevel1, btnLevel2, btnLevel3 ,btnLevel4 ,btnLevel5 ,btnLevel6, btnLevel7, btnLevel8;
    private ImageButton btnHelp;
    private ImageButton btnAbout;

    public MainMenuScreen(MathUGame game) {
        this.game = game;
        viewport = new FitViewport(MathUGame.V_WIDTH, MathUGame.V_HEIGHT, new OrthographicCamera());
        this.stage = new Stage(viewport);
    }

    private void initLabels() {
        lblTitle = new Label("U da Matemática", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        lblTitle.setSize(MathUGame.V_WIDTH, 20);
        lblTitle.setPosition(0, MathUGame.V_HEIGHT - 20);
        lblTitle.setAlignment(Align.center);

        stage.addActor(lblTitle);
    }

    private void initButtons() {
        btnLevel1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get(game.levelAvailable.get(MathUGame.LEVEL_1) ? "lvl1.png" : "lvlBlocked.png", Texture.class))));
        btnLevel1.setPosition(LEVEL1_X, LEVEL1_Y);
        btnLevel1.setSize(LEVEL_BOX_SIZE, LEVEL_BOX_SIZE);
        btnLevel1.setDisabled(!game.levelAvailable.get(MathUGame.LEVEL_1));
        btnLevel1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setCurrentLevel(MathUGame.LEVEL_1);
                game.setScreen(game.playScreen);
            }
        });

        btnLevel2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get(game.levelAvailable.get(MathUGame.LEVEL_2) ? "lvl2.png" : "lvlBlocked.png", Texture.class))));
        btnLevel2.setPosition(LEVEL2_X, LEVEL2_Y);
        btnLevel2.setSize(LEVEL_BOX_SIZE, LEVEL_BOX_SIZE);
        btnLevel2.setDisabled(!game.levelAvailable.get(MathUGame.LEVEL_2));
        btnLevel2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setCurrentLevel(MathUGame.LEVEL_2);
                game.setScreen(game.playScreen);
            }
        });

        btnLevel3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get(game.levelAvailable.get(MathUGame.LEVEL_3) ? "lvl3.png" : "lvlBlocked.png", Texture.class))));
        btnLevel3.setPosition(LEVEL3_X, LEVEL3_Y);
        btnLevel3.setSize(LEVEL_BOX_SIZE, LEVEL_BOX_SIZE);
        btnLevel3.setDisabled(!game.levelAvailable.get(MathUGame.LEVEL_3));
        btnLevel3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setCurrentLevel(MathUGame.LEVEL_3);
                game.setScreen(game.playScreen);
            }
        });

        btnLevel4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get(game.levelAvailable.get(MathUGame.LEVEL_4) ? "lvl4.png" : "lvlBlocked.png", Texture.class))));
        btnLevel4.setPosition(LEVEL4_X, LEVEL4_Y);
        btnLevel4.setSize(LEVEL_BOX_SIZE, LEVEL_BOX_SIZE);
        btnLevel4.setDisabled(!game.levelAvailable.get(MathUGame.LEVEL_4));
        btnLevel4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setCurrentLevel(MathUGame.LEVEL_4);
                game.setScreen(game.playScreen);
            }
        });

        btnLevel5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get(game.levelAvailable.get(MathUGame.LEVEL_5) ? "lvl5.png" : "lvlBlocked.png", Texture.class))));
        btnLevel5.setPosition(LEVEL5_X, LEVEL5_Y);
        btnLevel5.setSize(LEVEL_BOX_SIZE, LEVEL_BOX_SIZE);
        btnLevel5.setDisabled(!game.levelAvailable.get(MathUGame.LEVEL_5));
        btnLevel5.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setCurrentLevel(MathUGame.LEVEL_5);
                game.setScreen(game.playScreen);
            }
        });

        btnLevel6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get(game.levelAvailable.get(MathUGame.LEVEL_6) ? "lvl6.png" : "lvlBlocked.png", Texture.class))));
        btnLevel6.setPosition(LEVEL6_X, LEVEL6_Y);
        btnLevel6.setSize(LEVEL_BOX_SIZE, LEVEL_BOX_SIZE);
        btnLevel6.setDisabled(!game.levelAvailable.get(MathUGame.LEVEL_6));
        btnLevel6.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setCurrentLevel(MathUGame.LEVEL_6);
                game.setScreen(game.playScreen);
            }
        });

        btnLevel7 = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get(game.levelAvailable.get(MathUGame.LEVEL_7) ? "lvl7.png" : "lvlBlocked.png", Texture.class))));
        btnLevel7.setPosition(LEVEL7_X, LEVEL7_Y);
        btnLevel7.setSize(LEVEL_BOX_SIZE, LEVEL_BOX_SIZE);
        btnLevel7.setDisabled(!game.levelAvailable.get(MathUGame.LEVEL_7));
        btnLevel7.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setCurrentLevel(MathUGame.LEVEL_7);
                game.setScreen(game.playScreen);
            }
        });

        btnLevel8 = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get(game.levelAvailable.get(MathUGame.LEVEL_8) ? "lvl8.png" : "lvlBlocked.png", Texture.class))));
        btnLevel8.setPosition(LEVEL8_X, LEVEL8_Y);
        btnLevel8.setSize(LEVEL_BOX_SIZE, LEVEL_BOX_SIZE);
        btnLevel8.setDisabled(!game.levelAvailable.get(MathUGame.LEVEL_8));
        btnLevel8.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setCurrentLevel(MathUGame.LEVEL_8);
                game.setScreen(game.playScreen);
            }
        });

        btnAbout = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get("about.png", Texture.class))));
        btnAbout.setPosition(MathUGame.V_WIDTH - 50, 10);
        btnAbout.setSize(25, 25);
        btnAbout.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.aboutScreen);
            }
        });

        btnHelp = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get("help.png", Texture.class))));
        btnHelp.setPosition(MathUGame.V_WIDTH - 75, 10);
        btnHelp.setSize(25, 25);
        btnHelp.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.helpScreen);
            }
        });

        stage.addActor(btnLevel1);
        stage.addActor(btnLevel2);
        stage.addActor(btnLevel3);
        stage.addActor(btnLevel4);
        stage.addActor(btnLevel5);
        stage.addActor(btnLevel6);
        stage.addActor(btnLevel7);
        stage.addActor(btnLevel8);
        stage.addActor(btnAbout);
        stage.addActor(btnHelp);
    }

    @Override
    public void show() {
        stage.clear();

        initLabels();
        initButtons();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
