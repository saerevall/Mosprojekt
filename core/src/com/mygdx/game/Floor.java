package com.mygdx.game;

/**
 * Created by gabrielberthold on 16-03-03.
 */

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Floor extends GameObject {

    public final Rectangle bounds;


    public Floor (float posx, float posy, float width, float height) {

        super(posx, posy);
        this.bounds = new Rectangle( posx, posy, width, height);


    }

    public void update(float dt){

        updatePos();
        bounds.set(position.x,position.y,1920,20);
    }

    public void updatePos(){

        //position.x  = position.x;

    }

    public Vector2 getPos(){

        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
