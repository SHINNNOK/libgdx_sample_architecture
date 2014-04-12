package pro.anton.averin.games.libgdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import pro.anton.averin.games.libgdx.SampleGame;
import pro.anton.averin.games.libgdx.game.GameCamera;
import pro.anton.averin.games.libgdx.utils.MultipleVirtualViewportBuilder;
import pro.anton.averin.games.libgdx.utils.VirtualViewport;

/**
 * Created by AAverin on 07.04.2014.
 */
public class AbstractGameScreen implements Screen {

    protected SampleGame game;

    public GameCamera camera;
    private MultipleVirtualViewportBuilder multipleVirtualViewportBuilder;

    public AbstractGameScreen(SampleGame game) {
        this.game = game;
        multipleVirtualViewportBuilder = new MultipleVirtualViewportBuilder(1920, 1080, 1920, 1200);
        VirtualViewport virtualViewport = multipleVirtualViewportBuilder.getVirtualViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera = new GameCamera(virtualViewport);
        camera.setPosition(camera.viewportWidth / 2, camera.viewportHeight / 2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        VirtualViewport virtualViewport = multipleVirtualViewportBuilder.getVirtualViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setVirtualViewport(virtualViewport);
        camera.updateViewport();
        camera.setPosition(camera.viewportWidth / 2, camera.viewportHeight / 2);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
    }

    public SampleGame getGame() {
        return game;
    }

    public Vector3 getWorldCoordinates(float touchX, float touchY) {
        Vector3 touchPosition = new Vector3(touchX, touchY, 0);
        camera.unproject(touchPosition);
        return touchPosition;
    }
}
