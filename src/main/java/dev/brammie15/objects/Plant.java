package dev.brammie15.objects;

import com.raylib.java.raymath.Vector2;
import com.raylib.java.textures.Texture2D;
import dev.brammie15.Constants;
import dev.brammie15.core.AdvancedObject;
import dev.brammie15.interfaces.Tickable;
import dev.brammie15.managers.GameManager;
import dev.brammie15.util.Transform;

public class Plant extends AdvancedObject implements Tickable {
    final Texture2D texture = GameManager.getInstance().textureManager.getTexture("wheat_sheet");

    public Plant(Texture2D texture2D, Transform transform, int maxFrame, Vector2 frameSize, int renderPriority) {
        super(null, transform, 8, new Vector2(16,16), renderPriority);
        this.sprite.texture = texture;
        this.currentFrame = Constants.rand.nextInt(maxFrame);

        //TODO: add multiple types rn gonna hardcode it

    }

    public void draw(GameManager manager) {
        manager.renderManager.drawObject(this);
    }

    @Override
    public void tick() {
        if(this.currentFrame < this.maxFrame){
            this.currentFrame++;
        }else{
            this.currentFrame = 0;
        }
    }
}
