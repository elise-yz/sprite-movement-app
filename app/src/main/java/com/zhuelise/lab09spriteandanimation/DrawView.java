package com.zhuelise.lab09spriteandanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Sprite sprite;
    public Sprite sprite2;
    Bitmap bmap;
    Paint paint;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bmap = BitmapFactory.decodeResource(getResources(), R.drawable.sprite1);
        //walk towards the right
        paint = new Paint();
        sprite = new Sprite(500, 500, 1, 0, 2, bmap);
        sprite2 = new Sprite(100, 100, 1, 0, 2, bmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        sprite.draw(canvas);
        sprite2.draw(canvas);
    }

    //2,280x1,080
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //if(event.getAction()==MotionEvent.ACTION_DOWN) {
            int x = sprite.getX();
            int y = sprite.getY();
            int dY = sprite.getdY();
            int dX = sprite.getdX();
            //case 1
            if(event.getX()<x-100 && event.getY()<y-100 && !(y<2080 && x<200)) {
                sprite.setdX(-5);
                sprite.setdY(-5);
                sprite.setCurrentYFrame(1);
            }
            //case 2
            else if(event.getX()>x-100 && event.getX()<x+100 && event.getY()<y && !(y<2080 && x<200)){
                sprite.setdX(0);
                sprite.setdY(-5);
                sprite.setCurrentYFrame(3);
            }
            //case 3
            else if(event.getX()>x+100 && event.getY()<y-100 && !(y<2080 && x<200)){
                sprite.setdX(5);
                sprite.setdY(-5);
                sprite.setCurrentYFrame(2);
            }
            //case 4
            else if(event.getX()<x && event.getY()>y-100 && event.getY()<y+100 && !(y<2080 && x<200)){
                sprite.setdX(-5);
                sprite.setdY(0);
                sprite.setCurrentYFrame(1);
            }
            //case 5
            else if(event.getX()>x && event.getY()>y-100 && event.getY()<y+100 && !(y<2080 && x<200)){
                sprite.setdX(5);
                sprite.setdY(0);
                sprite.setCurrentYFrame(2);
            }
            //case 6
            else if(event.getX()<x && event.getY()>y+100 && !(y<2080 && x<200)){
                sprite.setdX(-5);
                sprite.setdY(5);
                sprite.setCurrentYFrame(1);
            }
            //case 7
            else if(event.getX()>x-100 && event.getX()<x+100 && event.getY()>y && !(y<2080 && x<200)){
                sprite.setdX(0);
                sprite.setdY(5);
                sprite.setCurrentYFrame(0);
            }
            //case 8
            else if(event.getX()>x+100 && event.getY()>y+100 && !(y<2080 && x<200)){
                sprite.setdX(5);
                sprite.setdY(5);
                sprite.setCurrentYFrame(2);
            }
            sprite.update();
            invalidate();
        return true;
    }
}
