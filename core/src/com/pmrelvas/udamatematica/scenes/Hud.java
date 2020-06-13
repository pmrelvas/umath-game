package com.pmrelvas.udamatematica.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pmrelvas.udamatematica.MathUGame;

public class Hud implements Disposable {

    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    Label lblCountdown;
    Label lblScore;
    Label lblTime;
    Label lblLevel;
    Label lblWorld;
    Label lblMario;

    public Hud(SpriteBatch sb) {
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(MathUGame.V_WIDTH, MathUGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        lblCountdown = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblScore = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblTime = new Label("TEMPO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblLevel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblWorld = new Label("NIVEL", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblMario = new Label("OPERACAO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(lblMario).expandX().padTop(10);
        table.add(lblWorld).expandX().padTop(10);
        table.add(lblTime).expandX().padTop(10);
        table.row();
        table.add(lblScore).expandX();
        table.add(lblLevel).expandX();
        table.add(lblCountdown).expandX();

        stage.addActor(table);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
