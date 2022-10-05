package dev.brammie15.managers;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;
import dev.brammie15.Constants;
import dev.brammie15.objects.InventorySlot;
import dev.brammie15.objects.Item;
import dev.brammie15.objects.ItemStack;
import dev.brammie15.util.ConsoleUtil;
import dev.brammie15.util.Sprite;
import dev.brammie15.util.Transform;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager implements CommonManager{
    public final Map<Integer, InventorySlot> slots = new HashMap<>();
    public int selectedSlot = 0;
    public Sprite selectionSprite;

    public InventoryManager(Raylib rlj) {
//        this.selectionSprite = new Sprite(GameManager.getInstance().textureManager.getTexture("selectionIcon"), new Transform(new Vector2(0, 0), Constants.SCALE));
    }

    //This works but idfk why and tbh its 4am and i need sleep but fuck that
    public void registerInventorySlot(InventorySlot slot, int id){
        slots.put(id, slot);
        ConsoleUtil.printNormal("Registerd slot: " + id);
    }
    public void selectSlot(int id){
        this.selectedSlot = id;
        this.selectionSprite.transform.position = slots.get(this.selectedSlot).transform.position;

    }
    public Item getCurrentItem(){
        if(slots.get(this.selectedSlot).itemStack != null){
            return slots.get(this.selectedSlot).itemStack.item;
        }
        return new Item(GameManager.getInstance().textureManager.getTexture("null"), "null", Constants.ZERO, 11);
    }

    public void setItemInSlot(int id, ItemStack item){
        item.item.transform.position = slots.get(id).transform.position;

        slots.get(id).itemStack = item;
    }

    public void drawGizmo(){
        GameManager.getInstance().renderManager.drawCircle(this.slots.get(this.selectedSlot).transform.position, 10, Color.BLUE);
        GameManager.getInstance().renderManager.drawSprite(this.selectionSprite);
    }


    @Override
    public void init(GameManager gameManager) {
        this.selectionSprite = new Sprite(gameManager.textureManager.getTexture("selection_icon"), new Transform(Constants.ZERO, Constants.SCALE_VECTOR));
    }

    @Override
    public void dispose() {

    }
}
