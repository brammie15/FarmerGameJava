package dev.brammie15.managers;

import com.raylib.java.raymath.Vector2;
import dev.brammie15.core.EngineObject;
import dev.brammie15.util.ConsoleUtil;
import dev.brammie15.util.GridUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class World implements CommonManager {

    public final Map<String, EngineObject> world = new HashMap<>();

    public <T extends EngineObject> void addObject(String id, T object) {
        world.put(id, object);
    }
    //Legacy
//    public ArrayList<EngineObject> objects = new ArrayList<>();

    public EngineObject getObject(String id) {
        return world.get(id);
    }

    public EngineObject[] getRenderOrder(){
        return world.values().stream().sorted(Comparator.comparingInt(o -> o.renderPriority)).toArray(EngineObject[]::new);
    }

    public void removeObject(String id) {
        world.remove(id);
    }

    public ArrayList<EngineObject> getObject(Vector2 gridPos) {
        ArrayList<EngineObject> objects = new ArrayList<>();
        for (EngineObject object : world.values()) {
            Vector2 objectGridPos = GridUtils.screenPosToGridPos(object.transform.position);
            if (GridUtils.screenPosToGridPos(object.transform.position).x == gridPos.x && GridUtils.screenPosToGridPos(object.transform.position).y == gridPos.y) {
                objects.add(object);
            }
        }
        if(objects.size() == 0){
            ConsoleUtil.printError("No objects found at: " + gridPos.x + ", " + gridPos.y);
            return null;
        }else{
            return objects;
        }
    }

    @Override
    public void init(GameManager gameManager) {
    }

    @Override
    public void dispose() {

    }
}
