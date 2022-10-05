package dev.brammie15.util;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.Constants;

public class Sprite {
    public Texture2D texture;
    public final Transform transform;

    public Sprite() {
        this.texture = null;
        this.transform = new Transform(Constants.ZERO, Constants.ZERO);
        }

    public Sprite(Texture2D texture, Transform transform) {
        this.texture = texture;
        this.transform = transform;
    }

}
