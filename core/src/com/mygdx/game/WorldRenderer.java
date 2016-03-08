package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;


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

        //Vector2 pos = update.ball.getPos();
        batch.begin();
        batch.draw(Assets.BadLogic, update.ballBody.getPosition().x, update.ballBody.getPosition().y);

        batch.end();
    }

    private void renderObstacles() {

        int len = update.cubes.size();

            for (int i = 0; i < len; i++) {

                batch.begin();
                batch.draw(Assets.cube, update.cubes.get(i).getPosition().x, update.cubes.get(i).getPosition().y);
                batch.end();
            }
        }



    private void renderSolids() {


        batch.begin();
        batch.draw(Assets.BadLogic, update.floorBody.getPosition().x, update.floorBody.getPosition().y, 2000+update.floorBody.getPosition().x, 20);
        batch.end();

    }
}