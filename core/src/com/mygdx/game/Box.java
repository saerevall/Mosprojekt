package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;


/**
 * Created by Cricka on 3/3/2016.
 */

public class Box {

    BodyDef boxBody;
    PolygonShape boxShape;

    public static float x;
    public static float y;
    public static final float PIXELS_TO_METERS = 100f;

    public Box(float lengthX,float lengthY, Vector2 position){

        x = lengthX;
        y = lengthY;
        boxBody = new BodyDef();
        boxBody.position.set(position.scl(1/PIXELS_TO_METERS));

        boxShape = new PolygonShape();
        boxShape.setAsBox(x / PIXELS_TO_METERS, y / PIXELS_TO_METERS);




    }
}
