package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;



public class Ball extends DynamicGameObject {


    public Vector2 acceleration;
    public final Circle bounds;
    public static final float RADIUS = 2;



    public Ball(float posx, float posy, float velx, float vely){

            super(posx, posy, velx, vely);
            this.bounds = new Circle(posx, posy, RADIUS);


    }
    public void update(float dt){

        velocity = new Vector2((acceleration.x + WorldUpdate.gravity.x)*dt, (acceleration.y + WorldUpdate.gravity.y)*dt);
        setPos(new Vector2(velocity.x * dt, velocity.y * dt));

    }

    public void setPos(Vector2 pos) {
        position = pos;
        bounds.setPosition(position);
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
