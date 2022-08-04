import com.raylib.java.Raylib;

public class InputManager {

    private final Raylib rlj;

    public InputManager(Raylib rlj) {
        this.rlj = rlj;
    }

    public boolean isKeyDown(int key) {
        return !rlj.core.IsKeyUp(key);
    }

    public boolean isKeyPressed(int key) {
        return rlj.core.IsKeyPressed(key);
    }
}
