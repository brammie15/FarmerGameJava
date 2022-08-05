package dev.brammie15.objects;

import com.raylib.java.textures.Texture2D;
import dev.brammie15.util.Sprite;
import dev.brammie15.util.Transform;

public class EngineObject {
    public Transform transform;
    public Sprite sprite;
    public int renderPriority;

    public EngineObject(Texture2D texture2D, Transform transform, int renderPriority) {
        this.transform = transform;
        this.renderPriority = renderPriority;
        this.sprite = new Sprite(texture2D, transform.position);
    }
}