package com.pmrelvas.udamatematica.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.pmrelvas.udamatematica.MathUGame;
import com.pmrelvas.udamatematica.logic.Calculations;
import com.pmrelvas.udamatematica.scenes.Hud;

public class ResultBox extends InteractiveTileObject {

    private final int RESULT_A_X_OFFSET = 3;
    private final int RESULT_B_X_OFFSET = 9;
    private final int RESULT_C_X_OFFSET = 15;
    private final int RESULT_D_X_OFFSET = 21;

    private final Hud hud;
    private final Calculations calculations;

    private Sound hitSound, missSound;

    public ResultBox(World world, TiledMap map, Rectangle bounds, Hud hud) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MathUGame.RESULT_BOX_BIT);
        this.hud = hud;
        this.calculations = Calculations.getInstance();
        initSounds();
    }

    private void initSounds() {
        hitSound = Gdx.audio.newSound(Gdx.files.internal("sound/hitSound.ogg"));
        missSound = Gdx.audio.newSound(Gdx.files.internal("sound/missSound.ogg"));
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Result Box", "Collision");
        int position = getResultBoxIdxFromCellPosition(getCellPosition());
        if (position == calculations.getResultIdx()) {
            hitSound.play();
            hud.drawWriteAnswer();
        } else {
            missSound.play();
        }
    }

    public int getResultBoxIdxFromCellPosition(Vector2 position) {
        Gdx.app.log("idx", position.toString());
        if (position.x == RESULT_A_X_OFFSET) {
            return 0;
        } else if (position.x == RESULT_B_X_OFFSET) {
            return 1;
        } else if (position.x == RESULT_C_X_OFFSET) {
            return 2;
        } else if (position.x == RESULT_D_X_OFFSET) {
            return 3;
        }
        return -1;
    }
}
