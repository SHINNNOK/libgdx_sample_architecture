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
public class MosaicChip extends GameObject {

    private final static String TAG = "MosaicChip";

    private AbstractScreenRenderer renderer;
    private TextureRegion chipRegion;

    public MosaicChip(AbstractScreenRenderer renderer, TextureRegion chipRegion, float x, float y, int width, int height) {
        super();
        this.renderer = renderer;
        this.chipRegion = chipRegion;
        size = new Vector2(width, height);
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);

        setInputMultiplexer(new InputMultiplexer(chipInputProcessor));
    }

    public void update(float delta) {

    }

    public void render(float delta) {
        SpriteBatch batch = renderer.getSpriteBatch();

        batch.draw(chipRegion, position.x, position.y, size.x, size.y);
    }

    private InputProcessor chipInputProcessor = new InputProcessor() {
        @Override
        public boolean keyDown(int keycode) {
//            Logger.log(TAG + ":" + id, "chipInputProcessor :: keyDown(", String.valueOf(keycode), ")");
            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
//            Logger.log(TAG + ":" + id, "chipInputProcessor :: keyUp(", String.valueOf(keycode), ")");
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
//            Logger.log(TAG + ":" + id, "chipInputProcessor :: keyTyped(", String.valueOf(character),")");
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//            Logger.log(TAG + ":" + id, "chipInputProcessor :: touchDown(", String.valueOf(screenX), String.valueOf(screenY), String.valueOf(pointer), String.valueOf(button), ")");
            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//            Logger.log(TAG + ":" + id, "chipInputProcessor :: touchUp(", String.valueOf(screenX), String.valueOf(screenY), String.valueOf(pointer), String.valueOf(button),")");
            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
//            Logger.log(TAG + ":" + id, "chipInputProcessor :: touchDragged(", String.valueOf(screenX), String.valueOf(screenY), String.valueOf(pointer),")");
            position.x = screenX - size.x / 2;
            position.y = screenY - size.y / 2;
            return true;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
//            Logger.log(TAG + ":" + id, "chipInputProcessor :: mouseMoved(", String.valueOf(screenX), String.valueOf(screenY), ")");
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
//            Logger.log(TAG + ":" + id, "chipInputProcessor :: scrolled(" + amount + ")");
            return false;
        }
    };
}
