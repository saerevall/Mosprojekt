package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
public class WorldRenderer {

    WorldUpdate update;
    SpriteBatch batch;
    public WorldRenderer(WorldUpdate update, SpriteBatch batch){
        this.update = update;
        this.batch = batch;
    }

    public void render(){

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
        Vector2 pos = update.ball.getPos();
        batch.begin();
        batch.draw(Assets.ball ,pos.x, pos.y);
        batch.end();
    }

    private void renderObstacles() {

    }
    private void renderSolids() {

    }
}