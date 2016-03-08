package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

        int len = update.cubes.size();
        for (int i = 0; i < len; i++) {
            Cube cube = update.cubes.get(i);
            Texture keyFrame = Assets.cube;

            batch.draw(keyFrame, cube.position.x - 1, cube.position.y - 0.25f, 2, 0.5f);
        }

    }
    private void renderSolids() {

        Vector2 pos = update.floor.getPos();
        batch.begin();
        batch.draw(Assets.BadLogic, pos.x, pos.y, 2000+pos.x, 20);
        batch.end();

    }
}