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

import java.lang.Math;


public class Ball {

    CircleShape circle;
    BodyDef circleBody;
    FixtureDef circleDef;
    public static final float RADIUS = 2;


    public Ball(float posx, float posy){


            circleBody = new BodyDef();
            circleBody.type = BodyDef.BodyType.DynamicBody;
            circleBody.position.set(posx, posy);
            circle = new CircleShape();
            circle.setRadius(RADIUS);
            circleDef = new FixtureDef();
            circleDef.restitution = 0.9f;
            circleDef.shape = circle;


    }


}
