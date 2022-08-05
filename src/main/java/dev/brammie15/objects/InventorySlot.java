package dev.brammie15.objects;

import com.raylib.java.textures.Texture2D;
import dev.brammie15.util.Transform;

public class InventorySlot extends EngineObject {
    public ItemStack itemStack;

    public InventorySlot(Texture2D texture, Transform transform, int renderPriority) {
        super(texture, transform, renderPriority);
    }
}
