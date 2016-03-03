package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;
import java.lang.Math;


public class Ball extends DynamicGameObject {


    public Vector2 acceleration = new Vector2(0, -500);
    public final Circle bounds;
    public static final float FORCE = 2000;
    public static final float RADIUS = 2;
    public static final float MAX_VELOCITY = 1000;
    public static final float AIR_RESISTANCE = 0.9f;
    public static final float FRICTION = 0.90f;

    public Ball(float posx, float posy, float velx, float vely){

            super(posx, posy, velx, vely);
            this.bounds = new Circle(posx, posy, RADIUS);


    }
    public void update(float dt){

        velocity.y = acceleration.y * dt + velocity.y;
        /*Gdx.app.log("Debug", "velX:: " + acceleration.x + " accY::" + acceleration.y);

        Gdx.app.log("Debug", "posX:: " + position.x + " posY::" + position.y);*/

        if (velocity.x > MAX_VELOCITY)
            velocity.x = MAX_VELOCITY;

        if (velocity.x < -MAX_VELOCITY)
            velocity.x = -MAX_VELOCITY;

        if (velocity.y > MAX_VELOCITY)
            velocity.y = MAX_VELOCITY;

        if (velocity.y < -MAX_VELOCITY)
            velocity.y = -MAX_VELOCITY;
        Gdx.app.log("Debug", "velocityX:: " + velocity.x + " velocityY::" + velocity.y);
        setPos(new Vector2((velocity.x * dt) + position.x, (velocity.y * dt) + position.y));

    }

    public void setPos(Vector2 pos) {

        if (pos.x < 0 && velocity.x < 0) {
            velocity.x = -velocity.x * FRICTION;
        }
        if (pos.y < 0 && velocity.y < 0) {
            velocity.y = -velocity.y * FRICTION;
        }
        if (pos.x > 1920 && velocity.x > 0) {
            velocity.x = -velocity.x * FRICTION;
        }
        if (pos.y > 1080 && velocity.y > 0){

            velocity.y = -velocity.y * FRICTION;
        }
        position = pos;
        bounds.setPosition(position);
    }

  /*  public void setAcceleration(Vector2 acc) {

        acc = acc.nor();
        acceleration.x = acc.x * FORCE;
        acceleration.y = acc.y * FORCE;

        Gdx.app.log("Debug", "X:: " + acceleration.x + " Y::" + acceleration.y);
        Gdx.app.log("Debug", "Normalized vec:: " + acc.x + ", " + acc.y);

    }
    */

    public Vector2 getPos(){

        return position;

    }

    public void setVelocity(Vector2 diffPos){
        Gdx.app.log("Debug", "diffvelX:: " + diffPos.x + " diffaccY::" + diffPos.y);
        Vector2 velChange = diffPos.nor();
        Gdx.app.log("Debug", "diffvelX:: " + velChange.x + " diffaccY::" + velChange.y);
        velocity.add(velocity.x + velChange.x * FORCE, velocity.y + velChange.y * FORCE);
        Gdx.app.log("Debug", "diffvelX:: " + velocity.x + " diffvelY::" + velocity.y);
    }

}
