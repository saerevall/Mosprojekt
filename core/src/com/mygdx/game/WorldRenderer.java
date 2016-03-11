package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;

public class WorldRenderer extends ApplicationAdapter {

    static final float FRUSTUM_WIDTH = 10;
    static final float FRUSTUM_HEIGHT = 15;
    WorldUpdate update;
    SpriteBatch batch;
    OrthographicCamera cam;
    ShapeRenderer shapeRenderer;

    public WorldRenderer(WorldUpdate update, SpriteBatch batch){
        this.update = update;
        this.batch = batch;
        this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
        this.cam.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);
        shapeRenderer = new ShapeRenderer();
    }

    public void render(){
        batch.setProjectionMatrix(cam.combined);
        renderBackground();
        renderObjects();
        cam.update();


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
        //Vector2 pos = update.ball.getPos();
       /*
        batch.begin();
        batch.draw(Assets.ball, update.ballBody.getPosition().x, update.ballBody.getPosition().y);
        batch.end();*/
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.circle(update.ballBody.getPosition().x * update.PIXELS_TO_METERS, update.ballBody.getPosition().y * update.PIXELS_TO_METERS, update.PIXELS_TO_METERS);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.end();
    }

    private void renderObstacles() {

        shapeRenderer.begin(ShapeType.Filled);
        for (int i = 0; i < WorldUpdate.BOXES; i++)
        {
            shapeRenderer.rect(update.boxesBody[i].getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxesBody[i].getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.boxes[i].x,update.boxes[i].y );
        }
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.end();
    }

    private void renderSolids() {

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.rect(update.floorBody.getPosition().x, update.floorBody.getPosition().y * WorldUpdate.PIXELS_TO_METERS, Gdx.graphics.getWidth(), 20f);
        shapeRenderer.rect(update.roofBody.getPosition().x, update.roofBody.getPosition().y * WorldUpdate.PIXELS_TO_METERS - 20f, Gdx.graphics.getWidth(), 20f);
        shapeRenderer.rect(update.wallBody.getPosition().x * WorldUpdate.PIXELS_TO_METERS - 20, update.wallBody.getPosition().y, 20f, Gdx.graphics.getHeight());
        shapeRenderer.setColor(Color.BLACK);

        shapeRenderer.end();
    }
}