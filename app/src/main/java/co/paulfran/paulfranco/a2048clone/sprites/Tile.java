package co.paulfran.paulfranco.a2048clone.sprites;

import android.graphics.Canvas;

import co.paulfran.paulfranco.a2048clone.TileManagerCallback;

public class Tile implements Sprite {

    private int screenWidth, screenHeight, standardSize;
    private TileManagerCallback callback;
    private int count = 3;

    public Tile(int standadrSize, int screenWidth, int screenHeight, TileManagerCallback callback) {
        this.standardSize = standadrSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.callback = callback;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(callback.getBitmap(count), screenWidth / 2 - 2 * standardSize, screenHeight / 2 - 2 * standardSize, null);
    }

    @Override
    public void update() {

    }
}
