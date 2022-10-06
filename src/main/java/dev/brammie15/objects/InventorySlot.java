package dev.brammie15.objects;

import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.Constants;
import dev.brammie15.core.EngineObject;
import dev.brammie15.interfaces.Interactable;
import dev.brammie15.managers.GameManager;
import dev.brammie15.util.ConsoleUtil;
import dev.brammie15.util.Transform;

public class InventorySlot extends EngineObject implements Interactable {
    public ItemStack itemStack;
    public final int id;

    public InventorySlot(Texture2D texture, Transform transform, int renderPriority, int id) {
        super(texture, transform, renderPriority);
        this.id = id;
        GameManager.getInstance().inventoryManager.registerInventorySlot(this, id);
//        System.out.println(id);
    }

    @Override
    public void interact(){
        GameManager.getInstance().inventoryManager.selectSlot(this.id);
    }

    @Override
    public void draw(GameManager manager) {
        super.draw(manager);
        if(this.itemStack != null){
            this.itemStack.item.draw(manager);
        }
    }
}
