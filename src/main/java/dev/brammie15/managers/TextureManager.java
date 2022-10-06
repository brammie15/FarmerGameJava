package dev.brammie15.managers;

import com.raylib.java.Raylib;
import com.raylib.java.text.Font;
import com.raylib.java.textures.Texture2D;
import com.raylib.java.textures.rTextures;
import dev.brammie15.util.ConsoleUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TextureManager implements CommonManager {
    public final Map<String, Texture2D> textureMap = new HashMap<>();
    public Font font;

    public TextureManager(Raylib rlj){

    }

    public void addTexture(String name, String path) {
        textureMap.put(name, this.loadTexture(path));
    }
    public Texture2D loadTexture(String path) {
        return rTextures.LoadTexture("src/main/resources/" + path);
    }


    public Texture2D getTexture(String name) {
        Texture2D texture = textureMap.get(name);
        if (texture == null) {
            ConsoleUtil.printError("Texture not found: " + name);
            return null;
        }
        ConsoleUtil.printSuccess("Found texture: " + name);
        return textureMap.get(name);
    }

    public void dispose() {
        for (Texture2D texture : textureMap.values()) {
            GameManager.getInstance().rlj.textures.UnloadTexture(texture);
        }
    }

    @Override
    public void init(GameManager gameManager){
        ConsoleUtil.printNormal("Loading textures...");
        font = gameManager.rlj.text.LoadFont("src/main/resources/font.otf");
//        this.addTexture("grass", "textures/grass.png");
//        this.addTexture("dirt", "textures/dirt.png");
//        this.addTexture("selectionIcon", "textures/selection_icon.png");
//        this.addTexture("sky", "textures/sky.png");
//        this.addTexture("player", "farmer/Farmer.png");
//        this.addTexture("wheat", "textures/wheat_sheet.png");
//        this.addTexture("inventorySlot", "textures/inventory_slot.png");
//        this.addTexture("hoe", "textures/hoe.png");
//        this.addTexture("null", "textures/null.png");
        getFileNames("textures/");
    }

    public void getFileNames(String s) {
        File folder = new File("src/main/resources/" + s);
        File[] files = folder.listFiles();
        for (File file : files) {
            this.addTexture(file.getName().split("\\.")[0], s + file.getName());
        }
        ConsoleUtil.printSuccess("Loaded " + files.length + " textures");
    }


}
