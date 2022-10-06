package dev.brammie15.objects;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.Constants;
import dev.brammie15.core.EngineObject;
import dev.brammie15.interfaces.Tickable;
import dev.brammie15.managers.GameManager;
import dev.brammie15.util.Transform;
import dev.brammie15.interfaces.Interactable;

public class FloorBlock extends EngineObject implements Interactable, Tickable {

    Plant plant;
    Vector2 plantPosition;
    boolean hasPlant = false;
    public FloorBlock(Texture2D texture2D, Vector2 position, int renderPriority) {
        super(texture2D, new Transform(position, Constants.SCALE_VECTOR), renderPriority);
        plantPosition = new Vector2(position.x, position.y - Constants.TILE_HEIGHT * Constants.SCALE);
        this.plant = new Plant(null, new Transform(plantPosition, Constants.SCALE_VECTOR), 8, new Vector2(16,16), 1);
    }

    @Override
    public void interact() {
//        this.sprite.texture = GameManager.getInstance().textureManager.getTexture("dirt");
//        this.plant = null;
        GameManager gm = GameManager.getInstance();

        switch (gm.inventoryManager.getCurrentItem().name){
            case "seed":
                this.plant = new Plant(GameManager.getInstance().textureManager.getTexture("wheat_sheet"), new Transform(this.plantPosition, Constants.SCALE_VECTOR), 8, new Vector2(16,16), 1);
                this.sprite.texture = GameManager.getInstance().textureManager.getTexture("grass");
                GameManager.getInstance().inventoryManager.slots.get(GameManager.getInstance().inventoryManager.selectedSlot).itemStack.use();
                break;
            case "hoe":
                if(hasPlant){
                    hasPlant = false;
                    this.sprite.texture = GameManager.getInstance().textureManager.getTexture("dirt");
                    this.plant = null;
                    break;
                }else{

                }

        }
    }

    @Override
    public void draw(GameManager manager) {
        super.draw(manager);
        if(this.plant != null){
            this.plant.draw(manager);
        }
    }

    @Override
    public void tick() {
        if(this.plant != null){
            this.plant.tick();
        }
    }
}
