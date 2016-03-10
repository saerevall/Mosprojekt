package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by Cricka on 3/3/2016.
 */

public class Floor {

    BodyDef floorBody;
    PolygonShape floorShape;
    public static final float PIXELS_TO_METERS = 100f;

    public Floor(float _shapex,float _shapey, Vector2 pos){

        floorBody = new BodyDef();
        floorBody.position.set(pos.scl(1/PIXELS_TO_METERS));
        floorShape = new PolygonShape();
        floorShape.setAsBox(_shapex / PIXELS_TO_METERS, _shapey / PIXELS_TO_METERS);
    }
}
