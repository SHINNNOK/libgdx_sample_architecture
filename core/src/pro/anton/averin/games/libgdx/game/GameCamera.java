package pro.anton.averin.games.libgdx.game;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import pro.anton.averin.games.libgdx.utils.OrthographicCameraWithVirtualViewport;
import pro.anton.averin.games.libgdx.utils.VirtualViewport;

/**
 * Created by AAverin on 10.04.2014.
 */
public class GameCamera extends OrthographicCameraWithVirtualViewport {
    public GameCamera(VirtualViewport virtualViewport) {
        super(virtualViewport);
    }

    public GameCamera(VirtualViewport virtualViewport, float cx, float cy) {
        super(virtualViewport, cx, cy);
    }

    int left, bottom, top, right, width, height;
    BoundingBox bb_left, bb_right, bb_top, bb_bottom = null;

    public void setWorldBounds(int left, int bottom, int width, int height) {
        top = bottom + height;
        right = left + width;
        this.left = left;
        this.bottom = bottom;
        this.width = width;
        this.height = height;

        this.bb_left = new BoundingBox(new Vector3(left - 2, 0, 0), new Vector3(left -1, top, 0));
        this.bb_right = new BoundingBox(new Vector3(right + 1, 0, 0), new Vector3(right + 2, top, 0));
        this.bb_top = new BoundingBox(new Vector3(0, top + 1, 0), new Vector3(right, top + 2, 0));
        this.bb_bottom = new BoundingBox(new Vector3(0, bottom - 1, 0), new Vector3(right, bottom - 2, 0));
    }

    public void zoomSafe(float newZoomValue) {
        zoom = newZoomValue;
        ensureInBounds();

    }

    public void translateSafe(float x, float y) {
        translate(x, y);
        ensureInBounds();
    }

    private float getVisibleWidth() {
        return zoom * viewportWidth;
    }
    private float getVisibleHeight() {
        return zoom * viewportHeight;
    }

    private void ensureInBounds() {
//        Logger.log(this, "position x=",position.x,"y=",position.y);

        if (getVisibleWidth() > width) {
            zoom = width/viewportWidth;
        }
        if (getVisibleHeight() > height) {
            zoom = height/viewportHeight;
        }

        float halfVisibleWidth = getVisibleWidth()/2;
        float halfVisibleHeight = getVisibleHeight()/2;

        float _left = position.x - halfVisibleWidth;
        if (_left < left) {
            position.x = halfVisibleWidth;
        }
        float _bottom = position.y - halfVisibleHeight;
        if (_bottom < bottom) {
            position.y = halfVisibleHeight;
        }

        if (position.x + halfVisibleWidth > width) {
            position.x = width - halfVisibleWidth;
        }
        if (position.y + halfVisibleHeight > height) {
            position.y = height - halfVisibleHeight;
        }
    }

}
