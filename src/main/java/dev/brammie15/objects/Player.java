package dev.brammie15.objects;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.Constants;
import dev.brammie15.core.AdvancedObject;
import dev.brammie15.util.Transform;

import static java.lang.Math.abs;

public class Player extends AdvancedObject {

    public Player(Texture2D texture2D, Transform transform, int maxFrame, Vector2 frameSize, int renderPriority) {
        super(texture2D, transform, maxFrame,frameSize, renderPriority);
    }

    public void move(float x, float y) {
        if(this.transform.position.x >= 0 || this.transform.position.x + this.frameSize.x <= Constants.WINDOW_WIDTH){
            transform.position.x += x;
            transform.position.y += y;
            this.currentFrame = (int) (abs(x) / x) == -1 ? 1 : 0;
        }
    }
}
