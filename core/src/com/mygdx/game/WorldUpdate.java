package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {
    World world;
    public final Ball ball;
    public final Floor floor;
    public final Floor roof;
    public final Floor wall;
    Body ballBody, floorBody, roofBody, wallBody;
    public static final Vector2 worldGravity = new Vector2(0, -10);
    public static final float FORCE = 10f;
    public static final float PIXELS_TO_METERS = 100f;
    public WorldUpdate(){

        world = new World(worldGravity, true);
        this.ball = new Ball(300,300);
        this.floor = new Floor(Gdx.graphics.getWidth(), 20f ,new Vector2(0, 10));
        this.roof = new Floor(Gdx.graphics.getWidth(), 20f ,new Vector2(0, Gdx.graphics.getHeight() -10));
        this.wall = new Floor(20, Gdx.graphics.getHeight() ,new Vector2(Gdx.graphics.getWidth() - 10, 0));
        ballBody = world.createBody(ball.circleBody);
        floorBody = world.createBody(floor.floorBody);
        roofBody = world.createBody(floor.floorBody);
        wallBody = world.createBody(floor.floorBody);
        ballBody.createFixture(ball.circleDef);
        floorBody.createFixture(floor.floorShape, 0.0f);
        roofBody.createFixture(floor.floorShape, 0.0f);
        wallBody.createFixture(floor.floorShape, 0.0f);
    }

    public void update(float dt){
        world.step(1/45f, 6, 2);
        updateBall(dt);
        updateObstacles(dt);
        updateSolids(dt);
    }
    private void updateBall(float dt){

        //ball.update(dt);
    }
    private void updateObstacles(double dt){

    }

    private void updateSolids(double dt){

    }
    public void ballForce(Vector2 Force){
        Force = Force.nor().scl(FORCE);
        Gdx.app.log("Suge mig röv", "x :" + Force.x + " y :" + Force.y);

        ballBody.applyLinearImpulse(Force, ballBody.getWorldCenter(), true);
    }

}