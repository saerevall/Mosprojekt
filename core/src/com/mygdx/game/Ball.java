package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;
import java.lang.Math;


public class Ball extends DynamicGameObject {


    public Vector2 acceleration = new Vector2(0,0);
    public final Circle bounds;
    public static final float FORCE = 100000;
    public static final float RADIUS = 2;
    public static final float MAX_VELOCITY_X = 1000;
    public static final float MAX_VELOCITY_Y = 1000;
    public static final float AIR_RESISTANCE = 0.9f;
    public static final float FRICTION = 0.95f;






    public Ball(float posx, float posy, float velx, float vely){

            super(posx, posy, velx, vely);
            this.bounds = new Circle(posx, posy, RADIUS);


    }
    public void update(float dt){

        updateAcceleration();

        velocity.add(acceleration.x * dt + velocity.x, acceleration.y * dt + velocity.y);

        if (velocity.x > MAX_VELOCITY_X)
            velocity.x = MAX_VELOCITY_X;

        if (velocity.x < -MAX_VELOCITY_X)
            velocity.x = -MAX_VELOCITY_X;

        if (velocity.y > MAX_VELOCITY_Y)
            velocity.y = MAX_VELOCITY_Y;

        if (velocity.y < MAX_VELOCITY_Y)
            velocity.y = -MAX_VELOCITY_Y;

        setPos(new Vector2((velocity.x * dt) + position.x, (velocity.y * dt) + position.y));

    }

    public void setPos(Vector2 pos) {

        if(pos.x < 0)
            pos.x = 1920;
        if(pos.y < 0)
            pos.y = 1080;
        if(pos.x > 1920)
            pos.x = 0;
        if(pos.y > 1080)
            pos.y = 0;

        position = pos;
        bounds.setPosition(position);
    }

    public void setAcceleration(Vector2 acc) {

        acc = acc.nor();
        acceleration.x = acc.x * FORCE;
        acceleration.y = acc.y * FORCE;

        Gdx.app.log("Debug", "X:: " + acceleration.x + " Y::" + acceleration.y);
        Gdx.app.log("Debug", "Normalized vec:: " + acc.x + ", " + acc.y);

    }

    public void updateAcceleration(){

        acceleration.x = acceleration.x * AIR_RESISTANCE + WorldUpdate.gravity.x;
        acceleration.y = (acceleration.y + WorldUpdate.gravity.y ) * AIR_RESISTANCE;
    }

    public Vector2 getPos(){
        
        return position;

    }

    public void setVelocity(Vector2 velo){

        velocity = velo;
    }

}
