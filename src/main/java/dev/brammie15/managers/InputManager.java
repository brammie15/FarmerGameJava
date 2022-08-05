package dev.brammie15.managers;

import com.raylib.java.Raylib;
import com.raylib.java.raymath.Vector2;

public class InputManager {

    private final Raylib rlj;

    public InputManager(Raylib rlj) {
        this.rlj = rlj;
    }
    public int getMouseX() {
        return rlj.core.GetMouseX();
    }
    public int getMouseY() {
        return rlj.core.GetMouseY();
    }
    public Vector2 getMouse(){
        return new Vector2(getMouseX(), getMouseY());
    }

    public boolean isKeyDown(int key) {
        return !rlj.core.IsKeyUp(key);
    }

    public boolean isKeyPressed(int key) {
        return rlj.core.IsKeyPressed(key);
    }
}
