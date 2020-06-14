package com.pmrelvas.udamatematica.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.pmrelvas.udamatematica.MathUGame;
import com.pmrelvas.udamatematica.screens.PlayScreen;

public class Hero extends Sprite {

    private final int PLAYER_SPRITE_WIDTH = 16;
    private final int PLAYER_SPRITE_HEIGHT = 17;

    public enum State {
        FALLING, JUMPING, STANDING, RUNNING
    };
    public State currentState;
    private State previousState;

    public World world;
    public Body b2Body;

    private TextureRegion heroStand;

    private Animation heroRun;
    private Animation heroJump;
    private float stateTimer;
    private boolean runningRight;

    public Hero(World world, PlayScreen screen) {
        super(screen.getAtlas().findRegion("umath-flatboy"));
        this.world = world;

        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        // running animation
        for (int i = 1; i <= 5; i++) {
            frames.add(new TextureRegion(getTexture(), i * PLAYER_SPRITE_WIDTH, 0, PLAYER_SPRITE_WIDTH, PLAYER_SPRITE_HEIGHT));
        }
        heroRun = new Animation(0.1f, frames);
        frames.clear();

        // jump animation
        for (int i = 6; i <= 8; i++) {
            frames.add(new TextureRegion(getTexture(), i * PLAYER_SPRITE_WIDTH, 0, PLAYER_SPRITE_WIDTH, PLAYER_SPRITE_HEIGHT));
        }
        heroJump = new Animation(0.1f, frames);
        frames.clear();

        defineHero();

        heroStand = new TextureRegion(getTexture(), 0, 0, 16, 20);
        setBounds(0, 0, PLAYER_SPRITE_WIDTH/MathUGame.PPM, PLAYER_SPRITE_HEIGHT/MathUGame.PPM);
        setRegion(heroStand);
    }

    public void update(float dt) {
        setPosition(b2Body.getPosition().x - getWidth()/2, b2Body.getPosition().y - getHeight()/2);
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt) {
        currentState = getState();

        TextureRegion region;
        switch (currentState) {
            case JUMPING:
                region = (TextureRegion) heroJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = (TextureRegion) heroRun.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
            default:
                region = heroStand;
                break;
        }

        if ((b2Body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()) {
            region.flip(true, false);
            runningRight = false;
        } else if ((b2Body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()) {
            region.flip(true, false);
            runningRight = true;
        }

        stateTimer = currentState == previousState ? stateTimer + dt : 0;
        previousState = currentState;
        return region;
    }

    public State getState() {
        if (b2Body.getLinearVelocity().y > 0 || (b2Body.getLinearVelocity().y < 0 && previousState == State.JUMPING)) {
            return State.JUMPING;
        }
        if (b2Body.getLinearVelocity().y < 0) {
            return State.FALLING;
        }
        if (b2Body.getLinearVelocity().x != 0) {
            return State.RUNNING;
        }
        return State.STANDING;
    }

    public void defineHero() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32/ MathUGame.PPM, 32/MathUGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2Body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(9/MathUGame.PPM);
        fdef.shape = shape;
        b2Body.createFixture(fdef);

        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-2/MathUGame.PPM, 8/MathUGame.PPM), new Vector2(2/MathUGame.PPM, 8/MathUGame.PPM));
        fdef.shape = head;
        fdef.isSensor = true;

        b2Body.createFixture(fdef).setUserData("head");

    }
}
