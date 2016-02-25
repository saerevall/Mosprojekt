package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;
public class Ball {

    //public final Vector2 vel;
    //public final Vector2 accel;
    public Vector2 pos;
    public final Circle bounds;
    public Ball(float y, float x, float rad){

            this.pos = new Vector2(x, y);
            this.bounds = new Circle(x, y, rad);

    }
    public void update(float dt){

    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getPos(){
        return pos;
    }



}
