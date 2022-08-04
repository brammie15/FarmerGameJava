import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;


public class AdvancedObject {
    public Transform transform;
    public Sprite sprite;

    public int maxFrame;
    public int currentFrame = 0;
    public Vector2 frameSize;

    public AdvancedObject(Texture2D texture2D, Transform transform, int maxFrame, Vector2 frameSize) {
        this.transform = transform;
        this.sprite = new Sprite(texture2D, transform.position);
        this.maxFrame = maxFrame;
        this.frameSize = frameSize;
    }
}
