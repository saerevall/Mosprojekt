package com.mygdx.game;

/**
 * Created by Cricka on 2/25/2016.
 */

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject{

    public Vector2 position;
   // public final Rectangle bounds;

    public GameObject(float x, float y) {

        this.position = new Vector2(x, y);

    }

}