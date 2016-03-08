package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by gabrielberthold on 16-03-03.
 */
public class Cube {

    BodyDef cubeBody;
    PolygonShape cubeShape;
    Vector2 Position;

    public Cube(int posx, int posy){

        Position = new Vector2(posx,posy);
        cubeBody = new BodyDef();
        cubeBody.position.set(new Vector2(posx, posy));
        cubeShape = new PolygonShape();
        cubeShape.setAsBox(10.0f, 10.0f);
    }

    public Vector2 getPosition() {

        return Position;
    }
}