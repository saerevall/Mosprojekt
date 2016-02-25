package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Cricka on 2/23/2016.
 */
public class GameScreen extends ScreenAdapter {

    Ballgame game;
    WorldRenderer renderer;
    WorldUpdate update;
    Vector3 tp;
    public GameScreen(Ballgame game) {

        this.game = game;
        update = new WorldUpdate();
        renderer = new WorldRenderer(update, game.batch);
        tp = new Vector3();
    }
    public void render(float delta) {

        update(delta);
        draw();
    }
    private void draw(){
        renderer.render();
    }
    private void update(float delta){
        if(Gdx.input.justTouched()){
            tp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            Vector2 boll = new Vector2(tp.x, tp.y);
            update.ball.setPos(boll);
        }
        update.update(delta);
    }
}
