package pro.anton.averin.games.libgdx.views;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.math.Vector2;

import java.util.UUID;

/**
 * Created by AAverin on 09.04.2014.
 */
public abstract class GameObject {

    protected UUID id;

    private InputMultiplexer privateInputMultiplexer = null;

    protected Vector2 size;
    protected Vector2 position;
    protected Vector2 velocity;
    protected Vector2 acceleration;

    public GameObject() {
        id = UUID.randomUUID();
    }

    public abstract void update(float delta);
    public abstract void render(float delta);

    protected void setInputMultiplexer(InputMultiplexer processor) {
        privateInputMultiplexer = processor;
    }
    public boolean hasInputMultiplexer() {
        return privateInputMultiplexer != null;
    }
    public InputMultiplexer getPrivateInputMultiplexer() {
        return privateInputMultiplexer;
    }
    public boolean isTouched(float x, float y) {
        if ((x >= position.x && x <= position.x + size.x) &&
                y >= position.y && y <= position.y + size.y) {
            return true;
        }

        return false;
    }
}
