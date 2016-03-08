package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;


public class Assets {

    public static Texture items;
    public static Texture background;
    public static Texture BadLogic;
    public static Texture cube;

    public static Animation ball;

    private static Texture loadTexture (String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load(){

        items = loadTexture("items.png");
        cube = loadTexture("cube.jpg");

        BadLogic = loadTexture("badlogic.jpg");
        background = loadTexture("Background.png");
        ball = new Animation(0.2f, new TextureRegion(items, 0, 0, items.getHeight(), items.getHeight()), new TextureRegion(items, items.getHeight(), 0, items.getHeight(), items.getHeight()), new TextureRegion(items, items.getHeight()*2, 0, items.getHeight(), items.getHeight()));


    }
}
