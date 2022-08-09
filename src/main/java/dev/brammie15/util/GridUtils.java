package dev.brammie15.util;

import com.raylib.java.raymath.Vector2;
import dev.brammie15.Constants;

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

    //convert screen pos to grid pos
    public static Vector2 screenPosToGridPos(Vector2 screenPos){
        return new Vector2((float) Math.floor(screenPos.x / (Constants.TILE_WIDTH * Constants.SCALE)), (float) Math.floor(screenPos.y / (Constants.TILE_HEIGHT * Constants.SCALE)));
    }

}
