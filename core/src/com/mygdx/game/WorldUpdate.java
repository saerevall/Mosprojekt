package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {

    public final Ball ball;

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