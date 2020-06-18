package com.pmrelvas.udamatematica.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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

public class HelpScreen implements Screen {

    private static final String HELP_LABEL_TEXT = "Este jogo é constituído por 8 níveis.\n" +
            "Para desbloqueares o próximo nível, terás de \n" +
            "ajudar o Gui a calcular o resultado da operação.\n" +
            "Move o Gui clicando nas setas esquerda e direita\n" +
            "do teu teclado, e use a tecla de cima para saltar.\n" +
            "Vamos fazer contas!";

    private final MathUGame game;

    private Stage stage;
    private Viewport viewport;
    private ImageButton btnReturn;
    private Label lblTitle;
    private Label lblHelp;

    public HelpScreen(MathUGame game) {
        this.game = game;
        viewport = new FitViewport(MathUGame.TSV_WIDTH, MathUGame.TSV_HEIGHT, new OrthographicCamera());
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
        btnReturn.setPosition(MathUGame.TSV_WIDTH - 75, 20);
        btnReturn.setSize(50, 50);
        btnReturn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.mainMenuScreen);
            }
        });
        stage.addActor(btnReturn);
    }

    private void initLabels() {
        lblTitle = new Label("Ajuda", new Label.LabelStyle(game.font40Bold, Color.BLACK));
        lblTitle.setSize(MathUGame.TSV_WIDTH, 20);
        lblTitle.setPosition(0, MathUGame.TSV_HEIGHT - 50);
        lblTitle.setAlignment(Align.center);

        lblHelp = new Label(HELP_LABEL_TEXT, new Label.LabelStyle(game.font34, Color.BLACK));
        lblHelp.setSize(MathUGame.TSV_WIDTH, 100);
        lblHelp.setPosition(40, MathUGame.TSV_HEIGHT - 280);
        lblHelp.setAlignment(Align.left);

        stage.addActor(lblTitle);
        stage.addActor(lblHelp);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        game.batch.begin();
        game.batch.end();
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
