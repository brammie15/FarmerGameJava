import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class World {

    public Map<String, EngineObject> world = new HashMap<String, EngineObject>();

    public <T extends EngineObject> void addObject(String id, T object) {
        world.put(id, object);
    }

    public ArrayList<EngineObject> objects = new ArrayList<>();

    public EngineObject getObject(String id) {
        return world.get(id);
    }

    public EngineObject[] getRenderOrder(){
        return world.values().stream().sorted(Comparator.comparingInt(o -> o.renderPriority)).toArray(EngineObject[]::new);
    }

    public void removeObject(String id) {
        world.remove(id);
    }
    public Object getObject(Vector2 gridPos) {
        for (EngineObject object : world.values()) {
            if (object.transform.position.equals(GridUtils.screenPosToGridPos(gridPos))) {
                return object;
            }
        }
        return null;
    }



}
