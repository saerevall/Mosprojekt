package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;

/**
 * Created by Cricka on 2/23/2016.
 */
public class GameScreen extends ScreenAdapter {

    Ballgame game;
    WorldRenderer render;
    WorldUpdate update;
    public GameScreen(Ballgame game) {

        this.game = game;
        render = new WorldRenderer();
        update = new WorldUpdate();
    }
    public void render(){
        update();
        draw();
    }
    private void draw(){
        render.render();
    }
    private void update(){
        update.update();
    }
}
