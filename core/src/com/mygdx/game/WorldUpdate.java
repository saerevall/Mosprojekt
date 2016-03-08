package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {
    World world;
    public final Ball ball;
    public final Floor floor;
    Body ballBody, floorBody;
    public static final Vector2 worldGravity = new Vector2(0, -10);

    public WorldUpdate(){

        world = new World(worldGravity, true);
        this.ball = new Ball(300,300);
        this.floor = new Floor();
        ballBody = world.createBody(ball.circleBody);
        floorBody = world.createBody(floor.floorBody);
        Fixture fixtureBall = ballBody.createFixture(ball.circleDef);
        floorBody.createFixture(floor.floorShape, 0.0f);
    }

    public void update(float dt){
        world.step(dt, 6, 2);
        updateBall(dt);
        updateObstacles(dt);
        updateSolids(dt);
    }
    private void updateBall(float dt){

        //ball.update(dt);
    }
    private void updateObstacles(float dt){

    }

    private void updateSolids(float dt){

    }
}