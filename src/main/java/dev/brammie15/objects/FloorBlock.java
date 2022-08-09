package dev.brammie15.objects;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.Constants;
import dev.brammie15.managers.GameManager;
import dev.brammie15.util.Transform;
import dev.brammie15.interfaces.Interactable;

public class FloorBlock extends EngineObject implements Interactable {

    Plant plant;

    public FloorBlock(Texture2D texture2D, Vector2 position, int renderPriority) {
        super(texture2D, new Transform(position, Constants.SCALE), renderPriority);
        Vector2 plantPos = new Vector2(position.x, position.y - Constants.TILE_HEIGHT * Constants.SCALE);
        this.plant = new Plant(null, new Transform(plantPos, Constants.SCALE), 8, new Vector2(16,16), 1);
    }

    @Override
    public void interact() {
        this.sprite.texture = GameManager.getInstance().textureManager.getTexture("dirt");
        this.plant = null;

    }

    @Override
    public void draw(GameManager manager) {
        super.draw(manager);
        if(this.plant != null){
            this.plant.draw(manager);
        }
    }
}
