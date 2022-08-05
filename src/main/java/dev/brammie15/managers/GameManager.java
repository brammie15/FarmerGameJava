package dev.brammie15.managers;

import com.raylib.java.Raylib;

public final class GameManager {
    private static GameManager INSTANCE;

    public final Raylib rlj = new Raylib();
    public final TextureManager textureManager = new TextureManager(rlj);
    public final RenderManager renderManager = new RenderManager(rlj);
    public final InputManager inputManager = new InputManager(rlj);
    public final World world = new World();

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
