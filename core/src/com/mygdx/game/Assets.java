package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

/**
 * Created by Cricka on 2/25/2016.
 */

public class Assets {

    public static Texture ball;

    private static Texture loadTexture (String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load(){
        ball = loadTexture("badlogic.jpg");

    }
}
