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
    public static final int BALL_STATE_YOLO = 0;

    int state;
    float stateTime;

    public Ball(float y, float x, float rad){

            state = BALL_STATE_YOLO;
            stateTime = 0.0f;
            this.pos = new Vector2(x, y);
            this.bounds = new Circle(x, y, rad);

    }
    public void update(float dt){

        stateTime += dt;

    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getPos(){
        return pos;
    }



}
