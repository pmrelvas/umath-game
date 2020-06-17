package com.pmrelvas.udamatematica.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.pmrelvas.udamatematica.MathUGame;

public class LoadingScreen implements Screen {

    private Stage stage;
    private ShapeRenderer shapeRenderer;
    private float progress = 0f;
    private OrthographicCamera gameCam;
    private final MathUGame game;

    public LoadingScreen(MathUGame game) {
        this.game = game;
        this.shapeRenderer = new ShapeRenderer();
        this.gameCam = new OrthographicCamera();
        this.stage = new Stage(new FitViewport(game.V_WIDTH, game.V_HEIGHT, gameCam));
        loadAssets();
    }

    private void loadAssets() {
        game.assets.load("certo.png", Texture.class);
        game.assets.load("lvl1.png", Texture.class);
        game.assets.load("lvl2.png", Texture.class);
        game.assets.load("lvl3.png", Texture.class);
        game.assets.load("lvl4.png", Texture.class);
        game.assets.load("lvl5.png", Texture.class);
        game.assets.load("lvl6.png", Texture.class);
        game.assets.load("lvl7.png", Texture.class);
        game.assets.load("lvl8.png", Texture.class);
        game.assets.load("lvlBlocked.png", Texture.class);
        game.assets.load("return.png", Texture.class);
        game.assets.load("return-dark.png", Texture.class);
        game.assets.load("about.png", Texture.class);
        game.assets.load("help.png", Texture.class);
    }

    @Override
    public void show() {

    }

    private void update(float dt) {
        // when finished updating all the assets, go to SplashScreen
        progress = MathUtils.lerp(progress, game.assets.getProgress(), .1f);
        if(game.assets.update() && progress >= game.assets.getProgress() -0.001f) {
            game.setScreen(game.mainMenuScreen);
        }
    }

    @Override
    public void render(float dt) {
        // clear screen
        Gdx.gl.glClearColor(0f, 0f ,0f ,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(dt);

        // draw progress bar
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(32, gameCam.viewportHeight/2, gameCam.viewportWidth - 64, 16);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(32, gameCam.viewportHeight/2, progress * (gameCam.viewportWidth - 64), 16);
        shapeRenderer.end();

        stage.draw();
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
        shapeRenderer.dispose();
    }
}
