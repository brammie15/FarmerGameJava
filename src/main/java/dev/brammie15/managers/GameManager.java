package dev.brammie15.managers;

import com.raylib.java.Raylib;
import dev.brammie15.Constants;

public final class GameManager {
    private static GameManager INSTANCE;

    public final Raylib rlj = new Raylib();
    public final TextureManager textureManager = new TextureManager(rlj);
    public final RenderManager renderManager = new RenderManager(rlj);
    public final InputManager inputManager = new InputManager(rlj);
    public final InventoryManager inventoryManager = new InventoryManager(rlj);
    public final World world = new World();

    public static GameManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameManager();
        }
        return INSTANCE;
    }
    public void init(){
        textureManager.init(this);
        renderManager.init(this);
        inputManager.init(this);
        inventoryManager.init(this);
        world.init(this);
    }
    private GameManager() {
        initWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, "Dingus");
        init();
    }

    public void initWindow(int width, int height, String title) {
        rlj.core.InitWindow(width, height, title);
    }

    public void dispose(){
        textureManager.dispose();
        renderManager.dispose();
        inputManager.dispose();
        inventoryManager.dispose();
        world.dispose();
    }

}
