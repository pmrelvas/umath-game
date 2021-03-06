package com.pmrelvas.udamatematica.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.pmrelvas.udamatematica.MathUGame;
import com.pmrelvas.udamatematica.scenes.Hud;
import com.pmrelvas.udamatematica.sprites.Brick;
import com.pmrelvas.udamatematica.sprites.ResultBox;

public class B2WorldCreator {

    private final Hud hud;

    public B2WorldCreator(World world, TiledMap map, Hud hud) {
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;
        this.hud = hud;

        // create ground bodies/fixtures
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth()/2)/ MathUGame.PPM, (rect.getY() + rect.getHeight()/2)/MathUGame.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2/MathUGame.PPM, rect.getHeight()/2/MathUGame.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        // create brick bodies/fixtures
        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Brick(world, map, rect);
        }

        // create number bodies/fixtures
        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new ResultBox(world, map, rect, hud);
        }
    }
}
