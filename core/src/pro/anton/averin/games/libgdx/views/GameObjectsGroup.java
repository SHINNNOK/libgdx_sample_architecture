package pro.anton.averin.games.libgdx.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import pro.anton.averin.games.libgdx.SampleGame;
import pro.anton.averin.games.libgdx.game.AbstractScreenRenderer;

/**
 * Created by AAverin on 09.04.2014.
 */
public class GameObjectsGroup {

    protected SampleGame game;
    protected AbstractScreenRenderer screenRenderer;

    private InputMultiplexer privateInputMultiplexer = null;

    protected Array<GameObject> children;

    public GameObjectsGroup(SampleGame game, AbstractScreenRenderer screenRenderer) {
        this.game = game;
        this.screenRenderer = screenRenderer;
        children = new Array<GameObject>();
        Gdx.input.setInputProcessor(groupInputMultiplexer);
    }

    protected void addGameObject(GameObject gameObject) {
        children.add(gameObject);
    }

    protected void setInputMultiplexer(InputMultiplexer processor) {
        privateInputMultiplexer = processor;
    }

    public boolean hasInputMultiplexer() {
        return privateInputMultiplexer != null;
    }

    public InputMultiplexer getPrivateInputMultiplexer() {
        return privateInputMultiplexer;
    }

    private InputMultiplexer groupInputMultiplexer = new InputMultiplexer(new InputProcessor() {
        @Override
        public boolean keyDown(int keycode) {
            for (GameObject gameObject : children) {
                if (gameObject.hasInputMultiplexer()) {
                    if (gameObject.getPrivateInputMultiplexer().keyDown(keycode)) {
                        return true;
                    }
                }
            }

            if (hasInputMultiplexer()) {
                if (getPrivateInputMultiplexer().keyDown(keycode)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
            for (GameObject gameObject : children) {
                if (gameObject.hasInputMultiplexer()) {
                    if (gameObject.getPrivateInputMultiplexer().keyUp(keycode)) {
                        return true;
                    }
                }
            }

            if (hasInputMultiplexer()) {
                if (getPrivateInputMultiplexer().keyUp(keycode)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            for (GameObject gameObject : children) {
                if (gameObject.hasInputMultiplexer()) {
                    if (gameObject.getPrivateInputMultiplexer().keyTyped(character)) {
                        return true;
                    }
                }
            }
            if (hasInputMultiplexer()) {
                if (getPrivateInputMultiplexer().keyTyped(character)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            Vector3 worldCoordinates = screenRenderer.gameScreen.getWorldCoordinates(screenX, screenY);
            for (GameObject gameObject : children) {
                if (gameObject.hasInputMultiplexer() && gameObject.isTouched(worldCoordinates.x, worldCoordinates.y)) {
                    if (gameObject.getPrivateInputMultiplexer().touchDown((int) worldCoordinates.x, (int) worldCoordinates.y, pointer, button)) {
                        return true;
                    }
                }
            }

            if (hasInputMultiplexer()) {
                if (getPrivateInputMultiplexer().touchDown((int) worldCoordinates.x, (int) worldCoordinates.y, pointer, button)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            Vector3 worldCoordinates = screenRenderer.gameScreen.getWorldCoordinates(screenX, screenY);
            for (GameObject gameObject : children) {
                if (gameObject.hasInputMultiplexer() && gameObject.isTouched(worldCoordinates.x, worldCoordinates.y)) {
                    if (gameObject.getPrivateInputMultiplexer().touchUp((int) worldCoordinates.x, (int) worldCoordinates.y, pointer, button)) {
                        return true;
                    }
                }
            }

            if (hasInputMultiplexer()) {
                if (getPrivateInputMultiplexer().touchUp((int) worldCoordinates.x, (int) worldCoordinates.y, pointer, button)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            Vector3 worldCoordinates = screenRenderer.gameScreen.getWorldCoordinates(screenX, screenY);
            for (GameObject gameObject : children) {
                if (gameObject.hasInputMultiplexer() && gameObject.isTouched(worldCoordinates.x, worldCoordinates.y)) {
                    if (gameObject.getPrivateInputMultiplexer().touchDragged((int) worldCoordinates.x, (int) worldCoordinates.y, pointer)) {
                        return true;
                    }
                }
            }

            if (hasInputMultiplexer()) {
                if (getPrivateInputMultiplexer().touchDragged((int) worldCoordinates.x, (int) worldCoordinates.y, pointer)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            Vector3 worldCoordinates = screenRenderer.gameScreen.getWorldCoordinates(screenX, screenY);
            for (GameObject gameObject : children) {
                if (gameObject.hasInputMultiplexer() && gameObject.isTouched(worldCoordinates.x, worldCoordinates.y)) {
                    if (gameObject.getPrivateInputMultiplexer().mouseMoved((int) worldCoordinates.x, (int) worldCoordinates.y)) {
                        return true;
                    }
                }
            }

            if (hasInputMultiplexer()) {
                if (getPrivateInputMultiplexer().mouseMoved((int) worldCoordinates.x, (int) worldCoordinates.y)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            for (GameObject gameObject : children) {
                if (gameObject.hasInputMultiplexer()) {
                    if (gameObject.getPrivateInputMultiplexer().scrolled(amount)) {
                        return true;
                    }
                }
            }

            if (hasInputMultiplexer()) {
                if (getPrivateInputMultiplexer().scrolled(amount)) {
                    return true;
                }
            }

            return false;
        }
    });

}
