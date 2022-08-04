import com.raylib.java.textures.Texture2D;

public class Object {
    public Transform transform;
    public Sprite sprite;

    public Object(Texture2D texture2D, Transform transform) {
        this.transform = transform;
        this.sprite = new Sprite(texture2D, transform.position);
    }
}
