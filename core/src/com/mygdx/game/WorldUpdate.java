package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {

    public int rand;
    int t ;

    Random randGenerate = new Random();


    World world;
    public final Ball ball;
    public final Floor floor;
    Body ballBody, floorBody, cubeBody;
    public static final Vector2 worldGravity = new Vector2(0, -10);
    public ArrayList<Cube> cubes = new ArrayList<Cube>();
    private Vector3 camPos;


    public WorldUpdate(){



        world = new World(worldGravity, true);
        this.ball = new Ball(300,300);
        this.floor = new Floor();
        ballBody = world.createBody(ball.circleBody);
        floorBody = world.createBody(floor.floorBody);
        Fixture fixtureBall = ballBody.createFixture(ball.circleDef);
        floorBody.createFixture(floor.floorShape, 0.0f);



    }

        private void generateCubes() {

            if (t%25==0) {

                rand = randGenerate.nextInt(Gdx.graphics.getHeight()-20) + 20;

                Cube cube = new Cube(Gdx.graphics.getWidth() + 5 * t, rand);

                if (cubes.size() > 15) {
                    cubes.remove(0);
                }
                Gdx.app.log("" + camPos, "Kamera pos");

                cubes.add(cube);

            }

            t++;

    }

    public void update(float dt, Vector3 camPos){
        world.step(dt, 6, 2);
        updateBall(dt);
        updateObstacles(dt);
        updateSolids(dt);
        this.camPos = camPos;

    }
    private void updateBall(float dt){

        //ball.update(dt);
    }
    private void updateObstacles(float dt){
        generateCubes();

    }

    private void updateSolids(float dt){

    }
}