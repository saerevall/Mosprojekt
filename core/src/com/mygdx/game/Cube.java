package com.mygdx.game;

/**
 * Created by gabrielberthold on 16-03-03.
 */
public class Cube extends GameObject{

    public static final float CUBE_DIMENSION = 50;

    public static final int CUBE_STATE_STATIC = 0;

    public static final int CUBE_TYPE_NORMAL = 0;

    int state;
    int type;
    float stateTime;


    public Cube (int type, float posx, float posy){

        super(posx,posy);

        this.type = type;
        this.state = CUBE_STATE_STATIC;
        this.stateTime = 0;

    }

    public void update (float deltaTime) {

        stateTime += deltaTime;
    }
}
