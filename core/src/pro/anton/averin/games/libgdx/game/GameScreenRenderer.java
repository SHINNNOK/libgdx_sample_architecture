package pro.anton.averin.games.libgdx.game;

import com.badlogic.gdx.Gdx;
import pro.anton.averin.games.libgdx.screens.AbstractGameScreen;

/**
 * Created by AAverin on 08.04.2014.
 */
public class GameScreenRenderer extends AbstractScreenRenderer {

    public interface GameScreenRendererCallback {
        public void onResourceReady();
    }
    private GameScreenRendererCallback callback;

    public GameScreenRenderer(AbstractGameScreen screen, GameScreenRendererCallback c) {
        super(screen);
        this.callback = c;
        super.create();
    }

    @Override
    public void renderBegin(float delta) {
        spriteBatch.setProjectionMatrix(gameScreen.camera.combined);
        spriteBatch.begin();
    }

    @Override
    public void render(float delta) {
        while (!gameScreen.getGame().resources.update()) {
            //loading
        }
        if (isResourceReady) {
            return;
        }

        isResourceReady = true;
        if (callback != null) {
            callback.onResourceReady();
        }
    }

    @Override
    public void renderEnd(float delta) {
        spriteBatch.end();
    }

    @Override
    public void loadAssets() {
        Gdx.app.debug(TAG, "loadAssets");
        gameScreen.getGame().resources.loadScreenResources(gameScreen.getClass().getSimpleName());
    }

    @Override
    public void unloadAssets() {
        Gdx.app.debug(TAG, "unloadAssets");
        gameScreen.getGame().resources.unloadScreenResources(gameScreen.getClass().getSimpleName());
    }
}
