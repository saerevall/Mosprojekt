package com.mygdx.game;

/**
 * Created by J on 16-03-01.
 */
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
    public static final boolean ANIMATION_LOOPING = false;
    public static final boolean ANIMATION_NONLOOPING = true;

    final TextureRegion[] keyFrames;
    final float frameDuration;

    public Animation (float frameDuration, TextureRegion... keyFrames) {
        this.frameDuration = frameDuration;
        this.keyFrames = keyFrames;
    }

    public TextureRegion getKeyFrame (float stateTime, int mode) {
        int frameNumber = (int)(stateTime / frameDuration);

        if (mode == 0) {
            frameNumber = Math.min(keyFrames.length - 1, frameNumber);
        }
        else {
            frameNumber = frameNumber % keyFrames.length;
        }
        return keyFrames[frameNumber];
    }
}
