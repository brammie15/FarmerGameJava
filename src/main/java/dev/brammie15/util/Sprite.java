package dev.brammie15.util;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;

public class Sprite {
    public Texture2D texture;
    public Vector2 position;
    public float scale;

    public Sprite() {
        this.texture = null;
        this.position = new Vector2(-1, -1);
        this.scale = -1;
    }

    public Sprite(Texture2D texture, Vector2 position, float scale) {
        this.texture = texture;
        this.position = position;
        this.scale = scale;
    }

    public Sprite(Texture2D texture, Vector2 position) {
        this.texture = texture;
        this.position = position;
        this.scale = 1;
    }

}
