package dev.brammie15.util;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;

public class Sprite {
    public Texture2D texture;
    public final Transform transform;

    public Sprite() {
        this.texture = null;
        this.transform = new Transform(new Vector2(0, 0), 0);
        }

    public Sprite(Texture2D texture, Transform transform) {
        this.texture = texture;
        this.transform = transform;
    }

}
