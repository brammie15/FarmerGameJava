package dev.brammie15.objects;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.managers.GameManager;
import dev.brammie15.util.Transform;

public class Plant extends AdvancedObject{
    Texture2D texture = GameManager.getInstance().textureManager.getTexture("wheat");

    public Plant(Texture2D texture2D, Transform transform, int maxFrame, Vector2 frameSize, int renderPriority) {
        super(null, transform, 8, new Vector2(16,16), renderPriority);
        this.sprite.texture = texture;
        this.currentFrame = 5;

        //TODO: add multiple types rn gonna hardcode it

    }
}
