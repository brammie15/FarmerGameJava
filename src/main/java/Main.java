import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.input.Keyboard;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        GameManager r = GameManager.getInstance();
        Raylib rlj = r.rlj;
        TextureManager manager = r.textureManager;
        r.initWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, "Dingus");
        manager.init();

//        FloorBlock block = new FloorBlock(texture, new Vector2(Constands.WINDOW_WIDTH - Constands.TILE_WIDTH * Constands.SCALE, Constands.WINDOW_HEIGHT - Constands.TILE_HEIGHT * Constands.SCALE));
        ArrayList<FloorBlock> blocks = new ArrayList<FloorBlock>();
        for (int i = 0; i < Constants.TILE_X; i++) {
            blocks.add(new FloorBlock(manager.getTexture("grass"), new Vector2(Constants.TILE_WIDTH * Constants.SCALE * i, Constants.WINDOW_HEIGHT - Constants.TILE_HEIGHT * Constants.SCALE)));
        }
        Player p = new Player(manager.getTexture("player"), new Transform(new Vector2(Constants.WINDOW_WIDTH/2, GridUtils.gridPosToWorldPos(new Vector2(5,2)).y),Constants.SCALE),1, new Vector2(16,32));
        SelectionIcon selector = new SelectionIcon(manager.getTexture("selectionIcon"), new Transform(GridUtils.gridPosToWorldPos(5,4),10));
        boolean selecting = false;

        while (!rlj.core.WindowShouldClose()){
            //Update
            if(r.inputManager.isKeyDown(Keyboard.KEY_D)){
                p.move(5, 0);
            }
            if(r.inputManager.isKeyDown(Keyboard.KEY_A)){
                p.move(-5, 0);
            }

            if(r.inputManager.isKeyPressed(Keyboard.KEY_SPACE) && r.inputManager.isKeyDown(Keyboard.KEY_S)){
                int selectionIndex = Math.round(p.transform.position.x/(Constants.TILE_HEIGHT * Constants.SCALE));
                blocks.get(selectionIndex).use();
            }
            float Xpos = p.transform.position.x;
            selector.setPos(new Vector2(Math.round(Xpos/(Constants.TILE_HEIGHT * Constants.SCALE)), 4));
            selecting = r.inputManager.isKeyDown(Keyboard.KEY_S);

            //Render
            r.renderManager.beginRender();
            rlj.textures.DrawTextureRec(manager.getTexture("sky"),new Rectangle(0,0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT),new Vector2(0,0) , Color.WHITE);
            for (FloorBlock block : blocks) {
                r.renderManager.drawObject(block);
                r.renderManager.drawObject(block.plant);
            }
            r.renderManager.drawObject(p);
            if(selecting){
                r.renderManager.drawObject(selector);
            }
            r.renderManager.endRender();
        }
    }
}
