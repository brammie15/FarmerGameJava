import com.raylib.java.Raylib;

public final class GameManager {
    private static GameManager INSTANCE;

    Raylib rlj = new Raylib();
    TextureManager textureManager = new TextureManager(rlj);
    RenderManager renderManager = new RenderManager(rlj);
    InputManager inputManager = new InputManager(rlj);

    public static GameManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameManager();
        }
        return INSTANCE;
    }

    private GameManager() {
    }

    public void initWindow(int width, int height, String title) {
        rlj.core.InitWindow(width, height, title);
    }


}
