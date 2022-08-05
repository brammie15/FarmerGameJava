package dev.brammie15;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.input.Mouse;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import dev.brammie15.managers.GameManager;
import dev.brammie15.managers.TextureManager;
import dev.brammie15.objects.EngineObject;
import dev.brammie15.objects.FloorBlock;
import dev.brammie15.objects.InventorySlot;
import dev.brammie15.objects.SelectionIcon;
import dev.brammie15.util.GridUtils;
import dev.brammie15.util.Transform;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GameManager r = GameManager.getInstance();
        Raylib rlj = r.rlj;
        TextureManager textureManager = r.textureManager;
        r.initWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, "Dingus");
        textureManager.init();

        r.world.addObject("selectionIcon", new SelectionIcon(textureManager.getTexture("selectionIcon"), new Transform(new Vector2(0, 0), Constants.SCALE), 10));

        for (int i = 0; i < Constants.TILE_X; i++) {
            r.world.addObject("floor" + i, new FloorBlock(textureManager.getTexture("grass"), new Vector2(Constants.TILE_WIDTH * Constants.SCALE * i, Constants.WINDOW_HEIGHT - Constants.TILE_HEIGHT * Constants.SCALE), 0));
        }

        for (int i = 0; i < 3; i++) {
            r.world.addObject("slot" + i,new InventorySlot(textureManager.getTexture("inventorySlot"), new Transform(GridUtils.gridPosToWorldPos(i,0), 7.26F), 9));
        }

        while (!rlj.core.WindowShouldClose()) {
            //Update
            SelectionIcon selectionIcon = (SelectionIcon) r.world.getObject("selectionIcon");
            selectionIcon.setRealPos(GridUtils.gridPosToWorldPos(GridUtils.screenPosToGridPos(r.inputManager.getMouse())));

            if(rlj.core.IsMouseButtonPressed(Mouse.MouseButton.MOUSE_BUTTON_LEFT)){
                Vector2 gridPos = GridUtils.screenPosToGridPos(r.world.getObject("selectionIcon").transform.position);
                System.out.println("Mouse Clicked at: " + gridPos.x + ", " + gridPos.y);
                ArrayList<EngineObject> objects = r.world.getObject(gridPos);
                if(objects != null){
                    try {
                        System.out.println("Object found");
                    } catch (Exception e) {
                        System.out.println("Object not found");
                    }
                    for (EngineObject object : objects) {
                        if(object.getClass() == FloorBlock.class){
                            ((FloorBlock) object).interact();
                        }
                    }
                }
            }

            //Render
            r.renderManager.beginRender();

            rlj.textures.DrawTextureRec(textureManager.getTexture("sky"), new Rectangle(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT), new Vector2(0, 0), Color.WHITE);
            for (EngineObject object : r.world.getRenderOrder()) {
                r.renderManager.drawObject(object);
            }

            r.renderManager.endRender();
        }
    }
}
