package com.mygdx.game;

/**
 * Created by Cricka on 2/23/2016.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;


public class WorldRenderer extends ApplicationAdapter {

    static final float FRUSTUM_WIDTH = 10;
    static final float FRUSTUM_HEIGHT = 15;

    WorldUpdate update;
    SpriteBatch batch;
    OrthographicCamera cam;
    ShapeRenderer shapeRenderer;

    Box2DDebugRenderer debugRenderer;
    Matrix4 debugMatrix;


    public WorldRenderer(WorldUpdate update, SpriteBatch batch){
        this.update = update;
        this.batch = batch;
        this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
        this.cam.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);

        shapeRenderer = new ShapeRenderer();

        debugMatrix=new Matrix4(cam.combined);

        debugMatrix.scale(Box.PIXELS_TO_METERS, Box.PIXELS_TO_METERS, 1f);

        debugRenderer=new Box2DDebugRenderer();

    }

    public void render(){
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        //BoxObjectManager.GetWorld() gets the reference to Box2d World object
        debugRenderer.render(update.world, debugMatrix);
        batch.end();
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


            renderRoof();
            renderFloor();
            renderRight();
            renderLeft();


    }

    private void renderSolids() {

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.rect(update.floorBody.getPosition().x, update.floorBody.getPosition().y * WorldUpdate.PIXELS_TO_METERS, Gdx.graphics.getWidth(), 20f);
        shapeRenderer.rect(update.roofBody.getPosition().x, update.roofBody.getPosition().y * WorldUpdate.PIXELS_TO_METERS - 20f, Gdx.graphics.getWidth(), 20f);
        shapeRenderer.rect(update.rwallBody.getPosition().x * WorldUpdate.PIXELS_TO_METERS - 20, update.rwallBody.getPosition().y, 20f, Gdx.graphics.getHeight());
        shapeRenderer.rect(update.lwallBody.getPosition().x * WorldUpdate.PIXELS_TO_METERS - 20, update.lwallBody.getPosition().y, 20f, Gdx.graphics.getHeight());
        shapeRenderer.setColor(Color.BLACK);

        shapeRenderer.end();
    }
    private void renderRoof(){
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.rect(update.boxRoofBody1.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxRoofBody1.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.roofbox1.x,update.roofbox1.y );
        shapeRenderer.rect(update.boxRoofBody2.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxRoofBody2.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.roofbox2.x,update.roofbox2.y );
        shapeRenderer.rect(update.boxRoofBody3.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxRoofBody3.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.roofbox3.x,update.roofbox3.y );


        shapeRenderer.setColor(Color.BLACK);

        shapeRenderer.end();
    }
    private void renderFloor(){
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.rect(update.boxFloorBody1.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxFloorBody1.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.floorbox1.x,update.floorbox1.y );
        shapeRenderer.rect(update.boxFloorBody2.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxFloorBody2.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.floorbox2.x,update.floorbox2.y );
        shapeRenderer.rect(update.boxFloorBody3.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxFloorBody3.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.floorbox3.x,update.floorbox3.y );

        shapeRenderer.setColor(Color.BLACK);

        shapeRenderer.end();

    }
    private void renderRight(){
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.rect(update.boxRightBody1.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxRightBody1.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.rightbox1.x,update.rightbox1.y );
        shapeRenderer.rect(update.boxRightBody2.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxRightBody2.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.rightbox2.x,update.rightbox2.y );
        shapeRenderer.rect(update.boxRightBody3.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxRightBody3.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.rightbox3.x,update.rightbox3.y );


        shapeRenderer.setColor(Color.BLACK);

        shapeRenderer.end();

    }
    private void renderLeft(){
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.rect(update.boxLeftBody1.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxLeftBody1.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.leftbox1.x,update.leftbox1.y );
        shapeRenderer.rect(update.boxLeftBody2.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxLeftBody2.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.leftbox2.x,update.leftbox2.y );
        shapeRenderer.rect(update.boxLeftBody3.getPosition().x * WorldUpdate.PIXELS_TO_METERS,update.boxLeftBody3.getPosition().y * WorldUpdate.PIXELS_TO_METERS, update.leftbox3.x,update.leftbox3.y );


        shapeRenderer.setColor(Color.BLACK);

        shapeRenderer.end();

    }
}
