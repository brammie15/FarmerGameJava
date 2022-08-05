import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;

public class SelectionIcon extends EngineObject {

    public SelectionIcon(Texture2D texture2D, Transform transform, int renderPriority) {
        super(texture2D, transform, renderPriority);
    }
    public void setPos(Vector2 gridPos){
        transform.position = GridUtils.gridPosToWorldPos(gridPos);
    }
}
