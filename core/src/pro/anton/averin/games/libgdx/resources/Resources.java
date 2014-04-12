package pro.anton.averin.games.libgdx.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

/**
 * Created by AAverin on 09.04.2014.
 */
public class Resources {

    private final static String TAG = "Resources";

    private AssetManager assetManager;

    private AbstractResourceAsset currentResourceAsset = null;

    public Resources() {
        assetManager = new AssetManager();
    }

    public AbstractResourceAsset getCurrentScreenResources() {
        return currentResourceAsset;
    }

    public boolean update() {
        if (!assetManager.update()) {
//            Gdx.app.debug(TAG, "updating assets load");
            return false;
        } else {
            prepareScreenResources(currentResourceAsset.assetName);
            return true;
        }
    }

    public void loadScreenResources(String screenName) {
        Gdx.app.log(TAG, "loadScreenResources for " + screenName);
        if (screenName.equals("SampleTestScreen")) {
            SampleGameTestScreenResources resources = new SampleGameTestScreenResources("SampleTestScreen");
            resources.load(assetManager);
            currentResourceAsset = resources;
        }
    }

    public void prepareScreenResources(String screenName) {
        if (currentResourceAsset.isPrepared) {
            return;
        }

        Gdx.app.log(TAG, "prepareScreenResources for " + screenName);

        if (screenName.equals("SampleTestScreen")) {
            SampleGameTestScreenResources resources = (SampleGameTestScreenResources) currentResourceAsset;
            resources.prepare(assetManager);
        }
        currentResourceAsset.isPrepared = true;
    }

    public void unloadScreenResources(String screenName) {
        Gdx.app.log(TAG, "unloadScreenResources for " + screenName);
        if (screenName.equals("SampleTestScreen")) {
            SampleGameTestScreenResources resources = (SampleGameTestScreenResources) currentResourceAsset;
            resources.unload(assetManager);
            currentResourceAsset = null;
        }
    }
}
