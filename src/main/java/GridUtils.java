import com.raylib.java.raymath.Vector2;

public class GridUtils {
    public static Vector2 gridPosToWorldPos(Vector2 gridPos){
        if(gridPos.x > Constants.TILE_X || gridPos.y > Constants.TILE_Y){
            System.out.println("Position out of bounds");
        }
        return new Vector2(gridPos.x * Constants.TILE_WIDTH * Constants.SCALE, gridPos.y * Constants.TILE_HEIGHT * Constants.SCALE);
    }
    public static Vector2 gridPosToWorldPos(int x, int y){
        return gridPosToWorldPos(new Vector2(x, y));
    }
}
