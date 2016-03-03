package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cricka on 3/1/2016.
 */
public class DynamicGameObject extends GameObject {

    public Vector2 velocity;
    public static final float MAX_VELOCITY = 800;

    public DynamicGameObject(float posx, float posy, float velx, float vely) {
        super(posx, posy);

        this.velocity = new Vector2(velx, vely);
        this.velocity.limit(MAX_VELOCITY);

    }
}
