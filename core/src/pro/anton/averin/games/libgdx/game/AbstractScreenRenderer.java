package pro.anton.averin.games.libgdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import pro.anton.averin.games.libgdx.screens.AbstractGameScreen;

/**
 * Created by AAverin on 08.04.2014.
 */
public abstract class AbstractScreenRenderer {

    protected final String TAG = getClass().getName();

    protected SpriteBatch spriteBatch;

    public boolean isResourceReady = false;

    public AbstractGameScreen gameScreen;
    public AbstractScreenRenderer(AbstractGameScreen gameScreen) {
        this.gameScreen = gameScreen;
        spriteBatch = new SpriteBatch();
        isResourceReady = false;
    }

    public void create() {
        try {
            loadAssets();
        } catch (GdxRuntimeException e) {
            e.printStackTrace();
            Gdx.app.debug(TAG, "loadAssets runtime exception", e);
        }
    }

    public abstract void renderBegin(float delta);
    public abstract void render(float delta);
    public abstract void renderEnd(float delta);

    public abstract void loadAssets();
    public abstract void unloadAssets();

    public void dispose() {
        try {
            unloadAssets();
        } catch (GdxRuntimeException e) {
            e.printStackTrace();
            Gdx.app.debug(TAG, "unloadAssets runtime exception", e);
        }
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

}
