package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
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

            rand = randGenerate.nextInt(Gdx.graphics.getHeight());

            Cube cube = new Cube(Gdx.graphics.getWidth()+20*t,rand);


            cubes.add(cube);



            for (int i = 0; i < cubes.size();i++) {

                if(cubes.get(i).getPosition().x < GameScreen.){
                    cubes.remove(i);
                }


            t++;

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
        generateCubes();

    }

    private void updateSolids(float dt){

    }
}