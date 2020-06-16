package com.pmrelvas.udamatematica.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pmrelvas.udamatematica.MathUGame;

public class RightScreen implements Screen {

    private final MathUGame game;

    private Stage stage;
    private Viewport viewport;
    private ImageButton btnReturn;

    public RightScreen(MathUGame game) {
        this.game = game;
        viewport = new FitViewport(MathUGame.V_WIDTH, MathUGame.V_HEIGHT, new OrthographicCamera());
        this.stage = new Stage(viewport);
    }

    @Override
    public void show() {
        stage.clear();

        initReturnButton();

        Gdx.input.setInputProcessor(stage);
    }

    private void initReturnButton() {
        btnReturn = new ImageButton(new TextureRegionDrawable(new TextureRegion(game.assets.get("return.png", Texture.class))));
        btnReturn.setPosition(MathUGame.V_WIDTH/2 - 25, 20);
        btnReturn.setSize(50, 50);
        btnReturn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.levelCompleted();
                game.setScreen(game.mainMenuScreen);
            }
        });
        stage.addActor(btnReturn);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        game.batch.begin();
        game.batch.draw(game.assets.get("certo.png", Texture.class), 0, 0);
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
