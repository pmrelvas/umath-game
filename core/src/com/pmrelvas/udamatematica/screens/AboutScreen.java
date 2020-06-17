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

public class AboutScreen implements Screen {

    private static final String ABOUT_LABEL_TEXT = "Este jogo foi desenvolvido por:\n" +
            "    - Prof. Carla Gonçalves;\n" +
            "    - Guilherme Andrade;\n" +
            "    - Andreia Andrade;\n" +
            "    - Pedro Relvas;";

    private final MathUGame game;

    private Stage stage;
    private Viewport viewport;
    private ImageButton btnReturn;
    private Label lblTitle;
    private Label lblAbout;

    public AboutScreen(MathUGame game) {
        this.game = game;
        viewport = new FitViewport(MathUGame.V_WIDTH, MathUGame.V_HEIGHT, new OrthographicCamera());
        this.stage = new Stage(viewport);
    }

    @Override
    public void show() {
        stage.clear();
        initReturnButton();
        initLabels();
        Gdx.input.setInputProcessor(stage);
    }

    private void initReturnButton() {
        btnReturn = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get("return-dark.png", Texture.class))));
        btnReturn.setPosition(MathUGame.V_WIDTH - 50, 10);
        btnReturn.setSize(25, 25);
        btnReturn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.mainMenuScreen);
            }
        });
        stage.addActor(btnReturn);
    }

    private void initLabels() {
        lblTitle = new Label("Sobre", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        lblTitle.setSize(MathUGame.V_WIDTH, 20);
        lblTitle.setPosition(0, MathUGame.V_HEIGHT - 20);
        lblTitle.setAlignment(Align.center);

        lblAbout = new Label(ABOUT_LABEL_TEXT, new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        lblAbout.setSize(MathUGame.V_WIDTH, 100);
        lblAbout.setPosition(110, MathUGame.V_HEIGHT - 140);
        lblAbout.setAlignment(Align.left);

        stage.addActor(lblTitle);
        stage.addActor(lblAbout);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        game.batch.begin();
        game.batch.end();
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
