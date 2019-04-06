package co.paulfran.paulfranco.a2048clone;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import co.paulfran.paulfranco.a2048clone.sprites.Grid;

public class GameManager extends SurfaceView implements SurfaceHolder.Callback{

    private MainThread thread;
    private Grid grid;
    private int scWidth, scHeight, standardSize;
    private TileManager tileManager;

    public GameManager(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);

        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        scWidth = dm.widthPixels;
        scHeight = dm.heightPixels;
        standardSize = (int) (scWidth * .88) / 4;


        grid = new Grid(getResources(), scWidth, scHeight, standardSize);
        tileManager = new TileManager(getResources(), standardSize, scWidth, scHeight);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(holder, this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int i, int i1, int i2) {
        thread.setSurfaceHolder(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        tileManager.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawRGB(255,255, 255);
        //draw grid on the canvas
        grid.draw(canvas);
        // draw tiles on the canvas
        tileManager.draw(canvas);

    }
}
