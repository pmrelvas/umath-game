package com.pmrelvas.udamatematica.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.pmrelvas.udamatematica.MathUGame;

public class ResultBox extends InteractiveTileObject {

    public ResultBox(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MathUGame.RESULT_BOX_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Result Box", "Collision");
    }
}
