package com.pmrelvas.udamatematica.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pmrelvas.udamatematica.MathUGame;
import com.pmrelvas.udamatematica.logic.Calculations;

import static com.pmrelvas.udamatematica.MathUGame.TILE_SIZE_PX;

public class Hud implements Disposable {

    private final int RESULT_LABEL_Y_OFFSET = 64;
    private final int RESULT_LABEL_A_X_OFFSET = 48;
    private final int RESULT_LABEL_B_X_OFFSET = 144;
    private final int RESULT_LABEL_C_X_OFFSET = 240;
    private final int RESULT_LABEL_D_X_OFFSET = 336;
    private final float RESULT_LABEL_SCALE = 0.8f;
    public static final int NUM_RESULTS = 4;

    private final MathUGame game;
    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private static Integer score;
    private Calculations calculations;

    Label lblCountdown;
    static Label lblOperation;
    Label lblTime;
    Label lblLevel;
    Label lblWorld;
    Label lblMario;

    Label lblAnswerA;
    Label lblAnswerB;
    Label lblAnswerC;
    Label lblAnswerD;

    private Image imgGray, imgYouWin;

    public Hud(SpriteBatch sb, MathUGame game) {
        this.game = game;
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(MathUGame.V_WIDTH, MathUGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        calculations = Calculations.getInstance();
        generateGameResults();

        initTopRowLabel();
        initAnswerLabels();
        setResultsLabels();

    }



    private void initTopRowLabel() {
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        lblCountdown = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblOperation = new Label(calculations.getOperationStr(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblTime = new Label("TEMPO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblLevel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblWorld = new Label("NIVEL", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lblMario = new Label("OPERACAO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(lblMario).expandX().padTop(10);
        table.add(lblWorld).expandX().padTop(10);
        table.add(lblTime).expandX().padTop(10);
        table.row();
        table.add(lblOperation).expandX();
        table.add(lblLevel).expandX();
        table.add(lblCountdown).expandX();

        stage.addActor(table);
    }

    private void initAnswerLabels() {
        lblAnswerA = new Label("A", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        lblAnswerB = new Label("B", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        lblAnswerC = new Label("C", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        lblAnswerD = new Label("D", new Label.LabelStyle(new BitmapFont(), Color.BLACK));

        lblAnswerA.setPosition(RESULT_LABEL_A_X_OFFSET, RESULT_LABEL_Y_OFFSET);
        lblAnswerA.setSize(TILE_SIZE_PX, TILE_SIZE_PX);
        lblAnswerA.setAlignment(Align.center);
        lblAnswerA.setFontScale(RESULT_LABEL_SCALE);
        lblAnswerB.setPosition(RESULT_LABEL_B_X_OFFSET, RESULT_LABEL_Y_OFFSET);
        lblAnswerB.setSize(TILE_SIZE_PX, TILE_SIZE_PX);
        lblAnswerB.setAlignment(Align.center);
        lblAnswerB.setFontScale(RESULT_LABEL_SCALE);
        lblAnswerC.setPosition(RESULT_LABEL_C_X_OFFSET, RESULT_LABEL_Y_OFFSET);
        lblAnswerC.setSize(TILE_SIZE_PX, TILE_SIZE_PX);
        lblAnswerC.setAlignment(Align.center);
        lblAnswerC.setFontScale(RESULT_LABEL_SCALE);
        lblAnswerD.setPosition(RESULT_LABEL_D_X_OFFSET, RESULT_LABEL_Y_OFFSET);
        lblAnswerD.setSize(TILE_SIZE_PX, TILE_SIZE_PX);
        lblAnswerD.setAlignment(Align.center);
        lblAnswerD.setFontScale(RESULT_LABEL_SCALE);

        stage.addActor(lblAnswerA);
        stage.addActor(lblAnswerB);
        stage.addActor(lblAnswerC);
        stage.addActor(lblAnswerD);
    }

    public void update(float dt) {
        timeCount += dt;
        if (timeCount >= 1) { // 1s
            worldTimer --;
            lblCountdown.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }
    }

    private void generateGameResults() {
        calculations.buildGameResults();
    }

    private void setResultsLabels() {
        lblAnswerA.setText(calculations.getResults().get(0));
        lblAnswerB.setText(calculations.getResults().get(1));
        lblAnswerC.setText(calculations.getResults().get(2));
        lblAnswerD.setText(calculations.getResults().get(3));
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public void drawWriteAnswer() {
        game.setScreen(game.rightScreen);
    }
}
