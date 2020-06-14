package com.pmrelvas.udamatematica.sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.pmrelvas.udamatematica.MathUGame;

import static com.pmrelvas.udamatematica.MathUGame.TILE_SIZE_PX;

public abstract class InteractiveTileObject {

    protected Body body;
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Fixture fixture;

    public InteractiveTileObject(World world, TiledMap map, Rectangle bounds) {
        this.world = world;
        this.map = map;
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/ MathUGame.PPM, (bounds.getY() + bounds.getHeight()/2)/MathUGame.PPM);

        body = world.createBody(bdef);

        shape.setAsBox(bounds.getWidth()/2/MathUGame.PPM, bounds.getHeight()/2/MathUGame.PPM);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
    }

    public abstract void onHeadHit();

    public void setCategoryFilter(short filterBit) {
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        fixture.setFilterData(filter);
    }

    public TiledMapTileLayer.Cell getCell() {
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
        return layer.getCell((int)(body.getPosition().x * MathUGame.PPM / TILE_SIZE_PX),
                (int)(body.getPosition().y * MathUGame.PPM / TILE_SIZE_PX));
    }

}
