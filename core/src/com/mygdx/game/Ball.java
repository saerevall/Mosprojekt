package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;

public class Ball extends DynamicGameObject {


    //public final Vector2 accel;
    public final Circle bounds;
    public static final float RADIUS = 2;



    public Ball(float posx, float posy, float velx, float vely){

            super(posx, posy, velx, vely);
            this.bounds = new Circle(posx, posy, RADIUS);

    }
    public void update(float dt){

    }

    public void setPos(Vector2 pos) {
        position = pos;
        bounds.setPosition(position);
    }

    public Vector2 getPos(){
        return position;
    }



}
