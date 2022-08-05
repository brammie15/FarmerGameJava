package dev.brammie15.managers;

import com.raylib.java.Raylib;
import com.raylib.java.textures.Texture2D;
import com.raylib.java.textures.rTextures;

import java.util.HashMap;
import java.util.Map;

public class TextureManager {
    public Map<String, Texture2D> textureMap = new HashMap<String, Texture2D>();
    private final Raylib rlj;


    public TextureManager(Raylib rlj){
        this.rlj = rlj;
    }

    public void addTexture(String name, String path) {
        textureMap.put(name, this.loadTexture(path));
    }
    public Texture2D loadTexture(String path) {
        return rTextures.LoadTexture("src/main/resources/" + path);
    }


    public Texture2D getTexture(String name) {
        return textureMap.get(name);
    }

    public void dispose() {
        for (Texture2D texture : textureMap.values()) {
            GameManager.getInstance().rlj.textures.UnloadTexture(texture);
        }
    }

    public void init(){
        this.addTexture("grass", "textures/grass.png");
        this.addTexture("dirt", "textures/dirt.png");
        this.addTexture("selectionIcon", "textures/Selection.png");
        this.addTexture("sky", "textures/sky.png");
        this.addTexture("player", "textures/Farmer.png");
        this.addTexture("wheat", "textures/Wheat.png");
        this.addTexture("inventorySlot", "textures/inventorySlot.png");
    }




}
