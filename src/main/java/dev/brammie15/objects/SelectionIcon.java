package dev.brammie15.objects;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.core.EngineObject;
import dev.brammie15.util.GridUtils;
import dev.brammie15.util.Transform;

public class SelectionIcon extends EngineObject {

    public SelectionIcon(Texture2D texture2D, Transform transform, int renderPriority) {
        super(texture2D, transform, renderPriority);
    }
    public void setPos(Vector2 gridPos){
        transform.position = GridUtils.gridPosToWorldPos(gridPos);
    }
    public void setRealPos(Vector2 realPos){
        transform.position = realPos;
    }
}
