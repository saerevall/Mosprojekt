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
    public Floor(){
        floorBody = new BodyDef();
        floorBody.position.set(new Vector2(0, 10));
        floorShape = new PolygonShape();
        floorShape.setAsBox(Gdx.graphics.getWidth(), 10.0f);
    }
}
