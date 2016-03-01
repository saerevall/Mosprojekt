package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;


public class Ball {

    public Vector2 vel;
    public Vector2 acc;
    public Vector2 pos;
    public final Circle bounds;
    public Ball(float x, float y, float rad){

            this.pos = new Vector2(x, y);
            this.bounds = new Circle(x, y, rad);
            this.acc = new Vector2(0, 0);
            this.vel = new Vector2(0,0);

    }
    public void update(float dt){

        vel = new Vector2((acc.x + WorldUpdate.gravity.x)*dt, (acc.y + WorldUpdate.gravity.y)*dt);
        pos = new Vector2(vel.x * dt, vel.y * dt);


    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
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

        return pos;
    }



}
