package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Random;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {

    Random rand;
    World world;
    Box[] boxes;
    public final Ball ball;
    public final Box floor;
    public final Box roof;
    public final Box wall;
    Body ballBody, floorBody, roofBody, wallBody;
    Body[] boxesBody;
    public static Vector2 worldGravity = new Vector2(0, -10);
    public static final float FORCE = 10f;
    public static final float PIXELS_TO_METERS = 100f;
    public static final int BOXES = 5;

    public WorldUpdate(){

        rand = new Random();
        world = new World(worldGravity, true);
        boxes = new Box[BOXES];
        boxesBody = new Body[BOXES];
        ball = new Ball(300,300);
        floor = new Box(Gdx.graphics.getWidth(), 20f ,new Vector2(0, 10));
        roof = new Box(Gdx.graphics.getWidth(), 20f ,new Vector2(0, Gdx.graphics.getHeight() -10));
        wall = new Box(20f, Gdx.graphics.getHeight() ,new Vector2(Gdx.graphics.getWidth() - 10, 0));

        ballBody = world.createBody(ball.circleBody);
        floorBody = world.createBody(floor.boxBody);
        roofBody = world.createBody(roof.boxBody);
        wallBody = world.createBody(wall.boxBody);

        ballBody.createFixture(ball.circleDef);
        floorBody.createFixture(floor.boxShape, 0.0f);
        roofBody.createFixture(roof.boxShape, 0.0f);
        wallBody.createFixture(wall.boxShape, 0.0f);

        for (int i = 0; i < BOXES; i++)
        {
            boxes[i] = new Box(20f, 400f, new Vector2(rand.nextFloat() * 1800, rand.nextFloat() * 900));
            boxesBody[i] = world.createBody(boxes[i].boxBody);
            boxesBody[i].createFixture(boxes[i].boxShape, 0.0f);
        }
    }

    public void update(float dt){
        world.step(1 / 45f, 6, 2);
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