package pro.anton.averin.games.libgdx.utils;

import com.badlogic.gdx.Gdx;

/**
 * Created by AAverin on 09.04.2014.
 */
public class Logger {

    public static void log(String TAG, Object... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object msg : message) {
            stringBuilder.append(String.valueOf(msg));
        }
        Gdx.app.log(TAG, stringBuilder.toString());
    }

    public static void log(Object o, Object... message) {
        log(o.getClass().getName(), message);
    }
}
