import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.input.Mouse;
import com.raylib.java.raymath.Raymath;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;

public class Main {
    public static void main(String[] args) {
        GameManager r = GameManager.getInstance();
        Raylib rlj = r.rlj;
        TextureManager manager = r.textureManager;
        r.initWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, "Dingus");
        manager.init();

        r.world.addObject("selectionIcon", new SelectionIcon(manager.getTexture("selectionIcon"), new Transform(new Vector2(0, 0), Constants.SCALE), 10));

        for (int i = 0; i < Constants.TILE_X; i++) {
            r.world.addObject("floor" + i, new FloorBlock(manager.getTexture("grass"), new Vector2(Constants.TILE_WIDTH * Constants.SCALE * i, Constants.WINDOW_HEIGHT - Constants.TILE_HEIGHT * Constants.SCALE), 0));
        }

        while (!rlj.core.WindowShouldClose()) {
            //Update
            Vector2 mousePos = Raymath.Vector2SubtractValue(r.inputManager.getMouse(), (float)Constants.TILE_WIDTH * Constants.SCALE / 2);
            SelectionIcon selectionIcon = (SelectionIcon) r.world.getObject("selectionIcon");
            selectionIcon.setPos(GridUtils.screenPosToGridPos(mousePos));



            //Render
            r.renderManager.beginRender();
            if(rlj.core.IsMouseButtonPressed(Mouse.MouseButton.MOUSE_BUTTON_LEFT)){
                Vector2 gridPos = GridUtils.screenPosToGridPos(r.world.getObject("selectionIcon").transform.position);
                r.renderManager.drawCircle(gridPos, 10, Color.BLUE);
                Object object = r.world.getObject(gridPos);
                if(object != null){
                    if(object.getClass() == FloorBlock.class){
                        ((FloorBlock) object).use();
                    }
                }
            }
            rlj.textures.DrawTextureRec(manager.getTexture("sky"), new Rectangle(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT), new Vector2(0, 0), Color.WHITE);
            for (EngineObject object : r.world.getRenderOrder()) {
                r.renderManager.drawObject(object);
                r.renderManager.drawCircle(object.transform.position, 10, Color.ORANGE);
            }

            r.renderManager.drawCircle(r.inputManager.getMouseX(), r.inputManager.getMouseY(), 10, Color.RED);
            r.renderManager.drawCircle(GridUtils.gridPosToWorldPos(GridUtils.screenPosToGridPos(r.inputManager.getMouse())), 10, Color.BLUE);
            r.renderManager.endRender();
        }
    }
}
