package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;

/**
 * Created by Cricka on 2/23/2016.
 */
public class GameScreen extends ScreenAdapter {

    Ballgame game;
    WorldRenderer renderer;
    WorldUpdate update;
    public GameScreen(Ballgame game) {

        this.game = game;
        update = new WorldUpdate();
        renderer = new WorldRenderer(update, game.batch);

    }
    public void render(float delta) {

        update.update(delta);
        draw();
    }
    private void draw(){
        renderer.render();
    }
    private void update(){

        //update.update();
    }
}
