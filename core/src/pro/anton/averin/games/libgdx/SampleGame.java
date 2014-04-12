package pro.anton.averin.games.libgdx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import pro.anton.averin.games.libgdx.resources.Resources;
import pro.anton.averin.games.libgdx.screens.SampleTestScreen;

public class SampleGame extends Game {

    public Resources resources;

	@Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        resources = new Resources();

		setScreen(new SampleTestScreen(this));
	}
}
