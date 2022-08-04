import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;

import static java.lang.Math.abs;

public class Player extends AdvancedObject {

    public Player(Texture2D texture2D, Transform transform, int maxFrame, Vector2 frameSize) {
        super(texture2D, transform, maxFrame,frameSize);
    }

    public void move(float x, float y) {
        if(this.transform.position.x >= 0 || this.transform.position.x + this.frameSize.x <= Constants.WINDOW_WIDTH){
            transform.position.x += x;
            transform.position.y += y;
            this.currentFrame = (int) (abs(x) / x) == -1 ? 1 : 0;
        }
    }
}
