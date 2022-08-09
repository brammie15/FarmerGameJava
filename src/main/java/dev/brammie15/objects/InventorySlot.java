package dev.brammie15.objects;

import com.raylib.java.textures.Texture2D;
import dev.brammie15.interfaces.Interactable;
import dev.brammie15.managers.GameManager;
import dev.brammie15.util.Transform;

public class InventorySlot extends EngineObject implements Interactable {
    public ItemStack itemStack;
    public final int id;

    public InventorySlot(Texture2D texture, Transform transform, int renderPriority, int id) {
        super(texture, transform, renderPriority);
        this.id = id;
        GameManager.getInstance().inventoryManager.registerInventorySlot(this, id);
        System.out.println(id);
    }

    @Override
    public void interact(){
        GameManager.getInstance().inventoryManager.selectSlot(this.id);
    }


}
