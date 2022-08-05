import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;

public class FloorBlock extends EngineObject implements Useable{

    Plant plant;

    public FloorBlock(Texture2D texture2D, Vector2 position, int renderPriority) {
        super(texture2D, new Transform(position, Constants.SCALE), renderPriority);
        Vector2 plantPos = new Vector2(position.x, position.y - Constants.TILE_HEIGHT * Constants.SCALE);
        this.plant = new Plant(null, new Transform(plantPos, Constants.SCALE), 8, new Vector2(16,16), 1);
    }

    @Override
    public void use() {
        this.sprite.texture = GameManager.getInstance().textureManager.getTexture("dirt");

    }
}
