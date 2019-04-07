package co.paulfran.paulfranco.a2048clone;

import android.graphics.Bitmap;

import co.paulfran.paulfranco.a2048clone.sprites.Tile;

public interface TileManagerCallback {

    Bitmap getBitmap(int count);
    void finishedMoving(Tile t);
    void updateScore(int delta);
    void reached2048();

}
