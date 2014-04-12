package pro.anton.averin.games.libgdx.views;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import pro.anton.averin.games.libgdx.game.AbstractScreenRenderer;

/**
 * Created by AAverin on 07.04.2014.
 */
public class GameObjectSample extends GameObject {

    private AbstractScreenRenderer renderer;
    private TextureRegion sampleRegion;

    public GameObjectSample(AbstractScreenRenderer renderer, TextureRegion sampleRegion, float x, float y, int width, int height) {
        super();
        this.renderer = renderer;
        this.sampleRegion = sampleRegion;
        size = new Vector2(width, height);
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);

        setInputMultiplexer(new InputMultiplexer(sampleInputProcessor));
    }

    public void update(float delta) {

    }

    public void render(float delta) {
        SpriteBatch batch = renderer.getSpriteBatch();

        batch.draw(sampleRegion, position.x, position.y, size.x, size.y);
    }

    private InputProcessor sampleInputProcessor = new InputProcessor() {
        @Override
        public boolean keyDown(int keycode) {
            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            position.x = screenX - size.x / 2;
            position.y = screenY - size.y / 2;
            return true;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            return false;
        }
    };
}
