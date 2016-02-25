package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

/**
 * Created by Cricka on 2/25/2016.
 */
public class Assets {

    public static Texture ball;

    public static Texture loadTexture (String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public void load(){
        ball = loadTexture("path to image");
    }
}
