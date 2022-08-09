package dev.brammie15.util;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.raymath.Vector3;

public class Transform {
    public Vector2 position;
    public final float scale;
    public final Vector3 rotation;

    public Transform() {
        this.position = new Vector2(0, 0);
        this.scale = 1;
        this.rotation = new Vector3(0,0,0);
    }
    public Transform(Vector2 position) {
        this.position = position;
        this.scale = 1;
        this.rotation = new Vector3(0,0,0);
    }
    public Transform(Vector2 position, float scale) {
        this.position = position;
        this.scale = scale;
        this.rotation = new Vector3(0,0,0);
    }
    public Transform(Vector2 position, float scale, Vector3 rotation) {
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }
    public Transform(Vector2 position, Vector3 rotation) {
        this.position = position;
        this.scale = 1;
        this.rotation = rotation;
    }
}
