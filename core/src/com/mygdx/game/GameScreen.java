package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Camera;

/**
 * Created by Cricka on 2/23/2016.
 */
public class GameScreen extends ScreenAdapter {

    Ballgame game;
    WorldRenderer renderer;
    WorldUpdate update;
    Vector3 touchDown, touchUp, result, camPos;
    Vector2 newPos, oldPos, diffPos;
    OrthographicCamera cam;
    float dt;


    public GameScreen(Ballgame game) {

        this.game = game;
        update = new WorldUpdate();
        renderer = new WorldRenderer(update, game.batch);
        result = new Vector3();
        touchDown = new Vector3();
        touchUp = new Vector3();
        cam = new OrthographicCamera();
        cam.setToOrtho(false);

        //cam.position.set(320 / 2, 480 / 2, 0);
        camPos = cam.position;
    }
    public void render(float delta) {

        cam.position.set(0 + camPos.x, camPos.y, 0);
        camPos = cam.position;
        dt = delta;
        update(delta);
        draw();
    }
    private void draw(){

        cam.update();
        game.batch.setProjectionMatrix(cam.combined);
        renderer.render();
    }
    private void update(float delta){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
                // your touch down code here
                touchDown.set(x, Gdx.graphics.getHeight() - y, 0);

                return true; // return true to indicate the event was handled
            }

            @Override
            public boolean touchUp (int x, int y, int pointer, int button) {
                // your touch up code here
                touchUp.set(x, Gdx.graphics.getHeight() - y, 0);
                result = touchUp.sub(touchDown);
                diffPos = new Vector2(result.x, result.y);
                update.ball.setVelocity(diffPos);
                return true; // return true to indicate the event was handled
            }


        });

        update.update(delta);
    }
}
