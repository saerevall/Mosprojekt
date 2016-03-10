package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;


public class Ball {

    CircleShape circle;
    BodyDef circleBody;
    FixtureDef circleDef;
    public static final float RADIUS = 1;
    public static final float PIXELS_TO_METERS = 100f;

    public Ball(float posx, float posy){

            circleBody = new BodyDef();
            circleBody.type = BodyDef.BodyType.DynamicBody;
            circleBody.position.set(posx/PIXELS_TO_METERS, posy/PIXELS_TO_METERS);
            circle = new CircleShape();
            circle.setRadius(RADIUS);
            circleDef = new FixtureDef();
            circleDef.density = 0.5f;
            circleDef.restitution = 0.8f;
            circleDef.shape = circle;

    }


}
