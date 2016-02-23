package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */
public class WorldRenderer {

    public void render(double dt){

        renderBackground();
        renderObjects();

    }

    private void renderBackground(){
        //här ska rendering av bakgrund ske
    }
    private void renderObjects(){
        renderBall();
        renderSolids();
        renderObstacles();
    }

    private void renderBall() {

    }

    private void renderObstacles() {

    }
    private void renderSolids() {

    }
}