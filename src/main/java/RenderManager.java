import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.rTextures;

public class RenderManager {

    private final Raylib rlj;

    public RenderManager(Raylib rlj) {
        this.rlj = rlj;
    }


    public void drawSprite(Sprite sprite) {
        Rectangle source = new Rectangle(0, 0, sprite.texture.width, sprite.texture.height);
        Rectangle destination = new Rectangle(sprite.position.x, sprite.position.y, sprite.scale * sprite.texture.width, sprite.scale * sprite.texture.height);
        rlj.textures.DrawTextureTiled(sprite.texture, source, destination, new Vector2(0,0), 0,1, Color.WHITE);
    }
    public <T extends Object> void drawObject(T object) {
        drawObject(object, Color.WHITE);
    }
    public <T extends Object> void drawObject(T object, Color color) {
        Rectangle source = new Rectangle(0, 0, object.sprite.texture.width, object.sprite.texture.height);
        Rectangle destination = new Rectangle(object.transform.position.x, object.transform.position.y, object.transform.scale * object.sprite.texture.width, object.transform.scale * object.sprite.texture.height);
        rlj.textures.DrawTextureEx(object.sprite.texture, object.transform.position, 0, object.transform.scale, color);
    }

    public <T extends AdvancedObject> void drawObject(T object) {
        Rectangle source = new Rectangle(object.frameSize.x * object.currentFrame, 0, object.frameSize.x, object.sprite.texture.height);
        Rectangle destination = new Rectangle(object.transform.position.x, object.transform.position.y, object.transform.scale * object.frameSize.x, object.transform.scale * object.sprite.texture.height);
        rTextures.DrawTexturePro(object.sprite.texture, source, destination, new Vector2(0,0), 0,Color.WHITE);
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
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        rlj.shapes.DrawLine(x1, y1, x2, y2, color);
    }
    public void clearBackground(Color color) {
        rlj.core.ClearBackground(color);
    }
    public void clearBackground() {
        rlj.core.ClearBackground(Color.WHITE);
    }
}
