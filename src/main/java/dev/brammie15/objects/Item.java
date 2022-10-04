package dev.brammie15.objects;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.Constants;
import dev.brammie15.core.EngineObject;
import dev.brammie15.util.Transform;

public class Item extends EngineObject {
    public String name;
    public Item(Texture2D texture,String name, Vector2 position, int renderPriority) {
        super(texture, new Transform(position, Constants.SCALE), renderPriority);
        this.name = name;
    }

}
