package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;

public class Ball extends GameObject {

    //public final Vector2 vel;
    //public final Vector2 accel;
    public final Circle bounds;
    public static final float RADIUS = 2;



    public Ball(float x, float y){

            super(x,y);
            this.bounds = new Circle(x, y, RADIUS);

    }
    public void update(float dt){

    }

    public void setPos(Vector2 pos) {
        position = pos;
    }

    public Vector2 getPos(){
        return position;
    }



}
