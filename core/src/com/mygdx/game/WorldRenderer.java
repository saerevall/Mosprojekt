package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
public class WorldRenderer {

    static final float FRUSTUM_WIDTH = 10;
    static final float FRUSTUM_HEIGHT = 15;
    WorldUpdate update;
    SpriteBatch batch;
    OrthographicCamera cam;
    public WorldRenderer(WorldUpdate update, SpriteBatch batch){
        this.update = update;
        this.batch = batch;
        this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
        this.cam.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);
    }

    public void render(){

        renderBackground();
        renderObjects();
        cam.update();
        batch.setProjectionMatrix(cam.combined);

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