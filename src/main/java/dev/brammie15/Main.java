package dev.brammie15;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.input.Mouse;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.interfaces.Tickable;
import dev.brammie15.managers.GameManager;
import dev.brammie15.managers.TextureManager;
import dev.brammie15.core.EngineObject;
import dev.brammie15.objects.*;
import dev.brammie15.util.ConsoleUtil;
import dev.brammie15.util.GridUtils;
import dev.brammie15.util.Transform;

import java.io.Console;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GameManager r = GameManager.getInstance();
        Raylib rlj = r.rlj;
        TextureManager textureManager = r.textureManager;
        r.init();
        Texture2D sky_tex = textureManager.getTexture("sky");
        int currentTick = 0;

        r.world.addObject("selectionIcon", new SelectionIcon(textureManager.getTexture("selection_icon"), new Transform(new Vector2(0, 0), Constants.SCALE_VECTOR), 10));

        for (int i = 0; i < Constants.TILE_X; i++) {
            r.world.addObject("floor" + i, new FloorBlock(textureManager.getTexture("grass"), new Vector2(Constants.TILE_WIDTH * Constants.SCALE * i, Constants.WINDOW_HEIGHT - Constants.TILE_HEIGHT * Constants.SCALE), 0));
        }

        for (int i = 0; i < 3; i++) {
            r.world.addObject("slot" + i, new InventorySlot(textureManager.getTexture("slot"), new Transform(GridUtils.gridPosToWorldPos(i, 0), new Vector2(7.26F, 7.26F)), 9, i));
        }
        r.inventoryManager.setItemInSlot(1, new ItemStack(new Item(r.textureManager.getTexture("hoe"), "hoe", Constants.ZERO, 10), 1));
        r.inventoryManager.setItemInSlot(2, new ItemStack(new Item(r.textureManager.getTexture("wheat_seeds"), "seed", Constants.ZERO, 10), 1));
        while (!rlj.core.WindowShouldClose()) {
            //Update
            SelectionIcon selectionIcon = (SelectionIcon) r.world.getObject("selectionIcon");
            selectionIcon.setRealPos(GridUtils.gridPosToWorldPos(GridUtils.screenPosToGridPos(r.inputManager.getMouse())));

            if (rlj.core.IsMouseButtonPressed(Mouse.MouseButton.MOUSE_BUTTON_LEFT)) {
                Vector2 gridPos = GridUtils.screenPosToGridPos(r.world.getObject("selectionIcon").transform.position);
//                System.out.println("Mouse Clicked at: " + gridPos.x + ", " + gridPos.y);
                ArrayList<EngineObject> objects = r.world.getObject(gridPos);
                if (objects != null) {
                    for (EngineObject object : objects) {
                        if (object instanceof FloorBlock) {
                            ((FloorBlock) object).interact();
                        }
                        if (object instanceof InventorySlot) {
                            ((InventorySlot) object).interact();
                            ConsoleUtil.printNormal("Slot clicked id: " + ((InventorySlot) object).id);
                        }
                    }
                }
            }
            if (currentTick >= Constants.TICK_RATE) {
                for (EngineObject object : r.world.world.values()) {
                    if (Tickable.class.isAssignableFrom(object.getClass())) {
                        ((Tickable) object).tick();
                    }
                }
                currentTick = 0;
            }

            currentTick += 1;

            //Render
            r.renderManager.beginRender();

            rlj.textures.DrawTextureRec(sky_tex, new Rectangle(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT), new Vector2(0, 0), Color.WHITE);
            for (EngineObject object : r.world.getRenderOrder()) {
                object.draw(r);
            }
            r.rlj.text.DrawText("FPS: ", 10, 10, 20, Color.WHITE);
            r.rlj.text.DrawTextPro(r.textureManager.font, "test", new Vector2(10, 10),Constants.ZERO, 0, 150, 2, Color.WHITE);
            r.inventoryManager.drawGizmo();
            r.renderManager.endRender();
        }
    }
}
