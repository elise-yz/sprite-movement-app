package com.zhuelise.lab09spriteandanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Sprite sprite;
    Bitmap bmap;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bmap = BitmapFactory.decodeResource(getResources(), R.drawable.sprite1);
        //walk towards the right
        sprite = new Sprite(500, 500, 1, 0, 2, bmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sprite.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN) {
            int x = sprite.getX();
            int y = sprite.getY();
            int dY = sprite.getdY();
            int dX = sprite.getdX();
            //case 1
            if(event.getX()<x-100 && event.getY()<y-100){
                sprite.setdX(-5);
                sprite.setdY(-5);
                sprite.setCurrentYFrame(1);
            }
            //case 2
            if(event.getX()>x-100 && event.getX()<x+100 && event.getY()<y){
                sprite.setdX(0);
                sprite.setdY(-5);
                sprite.setCurrentYFrame(3);
            }
            //case 3
            if(event.getX()>x+100 && event.getY()<y-100){
                sprite.setdX(5);
                sprite.setdY(-5);
                sprite.setCurrentYFrame(2);
            }
            //case 4
            if(event.getX()>x && event.getY()>y-100 && event.getY()<y+100){
                sprite.setdX(-5);
                sprite.setdY(0);
                sprite.setCurrentYFrame(1);
            }
            //case 5
            if(event.getX()<x && event.getY()>y-100 && event.getY()<y+100){
                sprite.setdX(5);
                sprite.setdY(0);
                sprite.setCurrentYFrame(2);
            }
            //case 6
            if(event.getX()<x && event.getY()>y+100){
                sprite.setdX(-5);
                sprite.setdY(5);
                sprite.setCurrentYFrame(2);
            }
            //case 7
            if(event.getX()>x-100 && event.getX()<x+100 && event.getY()>y){
                sprite.setdX(0);
                sprite.setdY(5);
                sprite.setCurrentYFrame(2);
            }
            //case 8
            if(event.getX()>x+100 && event.getY()>y+100){
                sprite.setdX(5);
                sprite.setdY(5);
                sprite.setCurrentYFrame(2);
            }
            sprite.update();
            invalidate();
        }
        return true;
    }
}
