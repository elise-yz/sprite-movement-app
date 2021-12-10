package com.zhuelise.lab09spriteandanimation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class Sprite extends RectF {
    private int dX, dY, width, height;
    private Bitmap bmap;
    public int currentXFrame, currentYFrame, x, y = 0;
    private int rows = 4;
    private int columns = 4;

    public Sprite(int x, int y, int dX, int dY, int currentY, Bitmap b) {
        this.dX = dX;
        this.dY = dY;
        this.x = x;
        this.y = y;
        this.currentYFrame = currentY;
        this.width = b.getWidth() / columns;
        this.height = b.getHeight() / rows;
        this.bmap = b;
    }

    public Sprite(int dX, int dY, Bitmap b) {
        this(1, 11, dX, dY, 0, b);
    }

    public Sprite(Bitmap b) {
        this(1, 1, b);
    }

    public Sprite() {
        dX = 1;
        dY = 1;
    }

    public void update() {
        x+=dX;
        y+=dY;
        currentXFrame = ++currentXFrame % columns;
        //currentYFrame = ++currentYFrame%columns;
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int srcX = currentXFrame * width;
        int srcY = currentYFrame * height;
        //source rectangle - rectangle of bitmap to draw
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        //destination rectangle - where to draw the rectangle from the bitmap
        Rect dst = new Rect(x, y, x + width, y + height);
        canvas.drawBitmap(bmap, src, dst, null);
    }

    public int getdX() {
        return dX;
    }

    public void setdX(int x) {
        dX = x;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int y) {
        dY = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int a, int b) {
        x = a;
        y = b;
        update();
    }

    public void setCurrentYFrame(int y) {
        currentYFrame = y;
    }
}
