package dev.brammie15.objects;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.util.Sprite;
import dev.brammie15.util.Transform;


public class AdvancedObject extends EngineObject {

    public int maxFrame;
    public int currentFrame = 0;
    public Vector2 frameSize;

    public AdvancedObject(Texture2D texture2D, Transform transform, int maxFrame, Vector2 frameSize, int renderPriority) {
        super(texture2D, transform, renderPriority);
        this.transform = transform;
        this.sprite = new Sprite(texture2D, transform.position);
        this.maxFrame = maxFrame;
        this.frameSize = frameSize;
    }
}
