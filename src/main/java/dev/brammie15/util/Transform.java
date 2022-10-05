package dev.brammie15.util;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.raymath.Vector3;
import dev.brammie15.Constants;

public class Transform {
    public Vector2 position;
    public Vector2 scale;
    public Vector3 rotation;

    public Transform() {
        this.position = new Vector2(0, 0);
        this.scale = Constants.ONE;
        this.rotation = new Vector3(0,0,0);
    }
    public Transform(Vector2 position) {
        this.position = position;
        this.scale = Constants.ONE;
        this.rotation = new Vector3(0,0,0);
    }
    public Transform(Vector2 position, Vector2 scale) {
        this.position = position;
        this.scale = scale;
        this.rotation = new Vector3(0,0,0);
    }
    public Transform(Vector2 position, Vector2 scale, Vector3 rotation) {
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }
    public Transform(Vector2 position, Vector3 rotation) {
        this.position = position;
        this.scale = Constants.ONE;
        this.rotation = rotation;
    }
}
