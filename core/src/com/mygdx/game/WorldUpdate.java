package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {

    public final Ball ball;
<<<<<<< HEAD
    public final Floor floor;
=======
>>>>>>> ea0de869a31524cdb350fa15dcff190ce057ef91
    public static final Vector2 gravity = new Vector2(0, -1);

    public WorldUpdate(){
        this.ball = new Ball(300,300,0,0);
<<<<<<< HEAD
        this.floor = new Floor( 0, 0, 1920, 20);
=======
>>>>>>> ea0de869a31524cdb350fa15dcff190ce057ef91
    }

    public void update(float dt){

        updateBall(dt);
        updateObstacles(dt);
        updateSolids(dt);
    }
    private void updateBall(float dt){

        ball.update(dt);
    }
    private void updateObstacles(float dt){

    }

    private void updateSolids(float dt){

        floor.update(dt);

    }
}