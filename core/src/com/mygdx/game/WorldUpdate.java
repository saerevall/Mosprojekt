package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldUpdate {


    public static final float WORLD_WIDTH = 10;
    public static final float WORLD_HEIGHT = 15 * 20;

    public final Ball ball;
    public final Floor floor;

    public final Random rand;

    public final List<Cube> cubes;



    public static final Vector2 gravity = new Vector2(0, -1);



    public WorldUpdate(){

        this.ball = new Ball(300,300,0,0);
        this.floor = new Floor( 0, 0, 1920, 20);

        rand = new Random();
        cubes = new ArrayList<Cube>();
        generateLevel();

    }

    private void generateLevel(){

        float y = Cube.CUBE_DIMENSION / 2;

        while (y < WORLD_HEIGHT - WORLD_WIDTH / 2) {

            int type = rand.nextFloat() > 0.5f ? Cube.CUBE_TYPE_NORMAL : null;
            float x = rand.nextFloat() * (WORLD_WIDTH - Cube.CUBE_DIMENSION) + Cube.CUBE_DIMENSION / 2;

            Cube cube = new Cube(type, x, y);
            cubes.add(cube);
        }

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