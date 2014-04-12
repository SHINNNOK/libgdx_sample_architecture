package pro.anton.averin.games.libgdx.views;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import pro.anton.averin.games.libgdx.SampleGame;
import pro.anton.averin.games.libgdx.game.AbstractScreenRenderer;
import pro.anton.averin.games.libgdx.resources.SampleGameTestScreenResources;

import java.util.Random;

/**
 * Created by AAverin on 08.04.2014.
 */
public class ObjectGroupSample extends GameObjectsGroup {

    private final Vector3 _lastMouseWorldMovePos;
    private final Vector3 _lastMouseWorldDragPos;
    private final Vector3 _lastMouseWorldPressPos;
    private final Vector3 _lastMouseWorldReleasePos;
    private final Vector3 _lastMouseScreenPos;

    public int _width;
    public int _height;

    SampleGameTestScreenResources res = null;

    public ObjectGroupSample(SampleGame game, AbstractScreenRenderer screenRenderer, int _width, int _height) {
        super(game, screenRenderer);
        _lastMouseWorldMovePos = new Vector3();
        _lastMouseWorldDragPos = new Vector3();
        _lastMouseWorldPressPos = new Vector3();
        _lastMouseWorldReleasePos = new Vector3();
        _lastMouseScreenPos = new Vector3();

        this._width = _width;
        this._height = _height;

        screenRenderer.gameScreen.camera.setWorldBounds(0, 0, _width, _height);

        setInputMultiplexer(new InputMultiplexer(boardGestureDetector));

        res = (SampleGameTestScreenResources) game.resources.getCurrentScreenResources();

        Random random = new Random();

        int chipWidth = 200;
        int chipHeight = 200;
        for (int i = 0; i < 10; i++) {
            TextureRegion chipRegion = new TextureRegion(res.sampleTexture, random.nextInt(res.sampleTexture.getWidth() - chipWidth), random.nextInt(res.sampleTexture.getHeight() - chipHeight), chipWidth, chipHeight);
            addGameObject(new MosaicChip(screenRenderer, chipRegion, random.nextInt(_width), random.nextInt(_height), chipWidth, chipHeight));
        }
    }

    public void update(float delta) {
//        for (MosaicChip chip : chips) {
//            chip.update(delta);
//        }
    }

    public void render(float delta) {

        SpriteBatch batch = screenRenderer.getSpriteBatch();

        batch.draw(res.sampleBg, 0, 0, _width, _height);

        for (GameObject gameObject : children) {
            gameObject.update(delta);
            gameObject.render(delta);
        }
    }

    GestureDetector boardGestureDetector = new GestureDetector(new GestureDetector.GestureListener() {

        float initialScale = 1;

        @Override
        public boolean touchDown(float x, float y, int pointer, int button) {
            initialScale = screenRenderer.gameScreen.camera.zoom;
            return false;
        }

        @Override
        public boolean tap(float x, float y, int count, int button) {
            return false;
        }

        @Override
        public boolean longPress(float x, float y) {
            return false;
        }

        @Override
        public boolean fling(float velocityX, float velocityY, int button) {
            return false;
        }

        @Override
        public boolean pan(float x, float y, float deltaX, float deltaY) {
            panCamera(deltaX, deltaY);
            return false;
        }

        @Override
        public boolean panStop(float x, float y, int pointer, int button) {
            return false;
        }

        @Override
        public boolean zoom(float initialDistance, float distance) {
            float ratio = initialDistance / distance;
            screenRenderer.gameScreen.camera.zoomSafe(initialScale * ratio);

            return false;
        }

        @Override
        public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
            return false;
        }
    });

    private void panCamera(float deltaX, float deltaY) {
        screenRenderer.gameScreen.camera.translateSafe(-deltaX, -deltaY);
    }

    public void dispose() {
        res.sampleBg = null;
    }

}
