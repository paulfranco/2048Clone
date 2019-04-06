package co.paulfran.paulfranco.a2048clone;

import android.graphics.Path;

public interface SwipeCallback {

    void onSwipe(Direction direction);

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }



}
