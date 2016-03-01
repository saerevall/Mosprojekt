package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {

    public final Ball ball;
    public static final Vector2 gravity = new Vector2(0,-10);

    public WorldUpdate(){
        this.ball = new Ball(0,0,2);
    }

    public void update(float dt){
        updateBall(dt);
        updateObstacles(dt);
        updateSolids(dt);
    }
    private void updateBall(float dt){
        ball.update(dt);
    }
    private void updateObstacles(double dt){

    }

    private void updateSolids(double dt){

    }
}