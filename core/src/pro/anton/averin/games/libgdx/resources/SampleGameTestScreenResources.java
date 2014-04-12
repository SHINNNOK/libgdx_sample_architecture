package pro.anton.averin.games.libgdx.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by AAverin on 09.04.2014.
 */
public class SampleGameTestScreenResources extends AbstractResourceAsset {

    private final static String baseFolder = "data/";

    public Texture sampleBg;
    public Texture sampleTexture;

    public SampleGameTestScreenResources(String name) {
        super(name);
    }

    public void load(AssetManager assetManager) {
        assetManager.load(baseFolder + "sampleBg.jpg", Texture.class);
        assetManager.load(baseFolder + "sampleTexture.jpg", Texture.class);
    }

    public void unload(AssetManager assetManager) {
        assetManager.unload(baseFolder + "sampleBg.jpg");
        assetManager.unload(baseFolder + "sampleTexture.jpg");
        sampleBg = null;
        sampleTexture = null;
    }

    public void prepare(AssetManager assetManager) {
        sampleBg = assetManager.get(baseFolder + "sampleBg.jpg", Texture.class);
        sampleTexture = assetManager.get(baseFolder + "sampleTexture.jpg", Texture.class);
    }
}
