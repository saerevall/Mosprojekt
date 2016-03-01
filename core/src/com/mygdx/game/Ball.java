package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;



public class Ball extends GameObject {

    public Vector2 velocity;
    public Vector2 acceleration;

    public final Circle bounds;
    public static final float RADIUS = 2;



    public Ball(float x, float y){

            super(x,y);
            this.bounds = new Circle(x, y, RADIUS);


    }
    public void update(float dt){

        velocity = new Vector2((acceleration.x + WorldUpdate.gravity.x)*dt, (acceleration.y + WorldUpdate.gravity.y)*dt);
        position = new Vector2(velocity.x * dt, velocity.y * dt);


    }

    public void setPos(Vector2 pos) {
        position = pos;
    }

//    public void setAcc(Vector2 Acc) {
//
//        this.acc = Acc;
//    }
//
//    public void setVel(Vector2 Vel){
//        this.vel = Vel;
//    }

    public Vector2 getPos(){
        
        return position;

    }



}
