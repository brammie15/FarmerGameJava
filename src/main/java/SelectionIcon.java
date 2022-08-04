import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;

public class SelectionIcon extends Object{

    public SelectionIcon(Texture2D texture2D, Transform transform) {
        super(texture2D, transform);
    }
    public void setPos(Vector2 gridPos){
        transform.position = GridUtils.gridPosToWorldPos(gridPos);
    }
}
