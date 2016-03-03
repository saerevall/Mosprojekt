package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
public class WorldRenderer {

    WorldUpdate update;
    SpriteBatch batch;
    static final float FRUSTUM_WIDTH = 10;
    static final float FRUSTUM_HEIGHT = 15;
    OrthographicCamera cam;

    public WorldRenderer(WorldUpdate update, SpriteBatch batch){
        this.update = update;
        this.batch = batch;
    }

    public void render(){

        renderBackground();
        renderObjects();

    }

    private void renderBackground(){
        batch.begin();
        batch.draw(Assets.background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }
    private void renderObjects(){
        renderBall();
        renderSolids();
        renderObstacles();
    }

    private void renderBall() {
        TextureRegion keyFrame;
        keyFrame = Assets.ball.getKeyFrame(update.ball.stateTime, true);
        Vector2 pos = update.ball.getPos();
        batch.begin();
        batch.draw(keyFrame,pos.x, pos.y);
        batch.end();
    }

    private void renderObstacles() {

    }
    private void renderSolids() {

    }
}