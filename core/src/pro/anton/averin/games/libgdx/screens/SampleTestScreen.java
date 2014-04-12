package pro.anton.averin.games.libgdx.screens;

import pro.anton.averin.games.libgdx.SampleGame;
import pro.anton.averin.games.libgdx.game.GameScreenRenderer;
import pro.anton.averin.games.libgdx.views.ObjectGroupSample;

/**
 * Created by AAverin on 07.04.2014.
 */
public class SampleTestScreen extends AbstractGameScreen {

    public ObjectGroupSample objectGroupSample;
    private GameScreenRenderer screenRenderer;

    public SampleTestScreen(final SampleGame game) {
        super(game);

        screenRenderer = new GameScreenRenderer(this, new GameScreenRenderer.GameScreenRendererCallback() {
            @Override
            public void onResourceReady() {
                objectGroupSample = new ObjectGroupSample(game, screenRenderer, (int)screenRenderer.gameScreen.camera.viewportWidth * 2, (int)screenRenderer.gameScreen.camera.viewportHeight * 2);
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (!screenRenderer.isResourceReady) {
            screenRenderer.render(delta);
            return;
        }

        objectGroupSample.update(delta);

        screenRenderer.renderBegin(delta);
        screenRenderer.render(delta);
        objectGroupSample.render(delta);
        screenRenderer.renderEnd(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
        objectGroupSample.dispose();
        screenRenderer.dispose();
    }
}
