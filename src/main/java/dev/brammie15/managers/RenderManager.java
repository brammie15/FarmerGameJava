package dev.brammie15.managers;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Texture2D;
import com.raylib.java.textures.rTextures;
import dev.brammie15.Constants;
import dev.brammie15.util.Sprite;
import dev.brammie15.core.AdvancedObject;
import dev.brammie15.core.EngineObject;

public class RenderManager implements CommonManager {

    private final Raylib rlj;

    public RenderManager(Raylib rlj) {
        this.rlj = rlj;
    }
    public Texture2D no_texture;

    public void drawSprite(Sprite sprite) {
        Texture2D texture = checkIfTextureExists(sprite.texture);
        Rectangle source = new Rectangle(0, 0, texture.width, texture.height);
        Rectangle destination = new Rectangle(sprite.transform.position.x, sprite.transform.position.y, sprite.transform.scale.x * texture.width, sprite.transform.scale.y * texture.height);
        rTextures.DrawTexturePro(texture, source, destination, Constants.ZERO, 0, Color.WHITE);

    }
    public <T extends EngineObject> void drawObject(T object) {
        drawObject(object, Color.WHITE);
    }

    public <T extends EngineObject> void drawObject(T object, Color color) {
        Texture2D texture = checkIfTextureExists(object.sprite.texture);
        Rectangle source = new Rectangle(0, 0, texture.width, texture.height);
        Rectangle destination = new Rectangle(object.transform.position.x, object.transform.position.y, object.transform.scale.x * texture.width, object.transform.scale.y * texture.height);
        rTextures.DrawTexturePro(texture, source, destination, Constants.ZERO, 0, color);
    }

    public <T extends AdvancedObject> void drawObject(T object) {
        Texture2D texture = checkIfTextureExists(object.sprite.texture);
        Rectangle source = new Rectangle(object.frameSize.x * object.currentFrame, 0, object.frameSize.x, texture.height);
        Rectangle destination = new Rectangle(object.transform.position.x, object.transform.position.y, object.transform.scale.x * object.frameSize.x, object.transform.scale.y * texture.height);
        rTextures.DrawTexturePro(texture, source, destination, new Vector2(0,0), 0,Color.WHITE);
    }

    public Texture2D checkIfTextureExists(Texture2D tex){
        if(tex == null){
            return no_texture;
        }else{
            return tex;
        }
    }

    public void beginRender() {
        rlj.core.BeginDrawing();
    }
    public void endRender() {
        rlj.core.EndDrawing();
    }
    public void drawRectangle(int x, int y, int width, int height, Color color) {
        rlj.shapes.DrawRectangle(x, y, width, height, color);
    }
    public void drawCircle(int x, int y, int radius, Color color) {
        rlj.shapes.DrawCircle(x, y, radius, color);
    }
    public void drawCircle(Vector2 pos, int radius, Color color) {
        drawCircle((int) pos.x, (int) pos.y, radius, color);
    }
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        rlj.shapes.DrawLine(x1, y1, x2, y2, color);
    }
    public void clearBackground(Color color) {
        rlj.core.ClearBackground(color);
    }
    public void clearBackground() {
        rlj.core.ClearBackground(Color.WHITE);
    }

    @Override
    public void init(GameManager gameManager) {
        //Manually load the NO_TEXTURE texture because if its loaded through TextureManager and it fails we get a chrash
        no_texture = rTextures.LoadTexture("src/main/resources/textures/null.png");
//        no_texture = gameManager.textureManager.getTexture("null");
    }

    @Override
    public void dispose() {


    }
}
