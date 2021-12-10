package com.zhuelise.lab09spriteandanimation;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button up, down, left, right;
    Sprite s;
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up = findViewById(R.id.up_button);
        down = findViewById(R.id.down_button);
        left = findViewById(R.id.left_button);
        right = findViewById(R.id.right_button);
        drawView = findViewById(R.id.drawview);
        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                s = drawView.sprite2;
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    s.setdX(0);
                    s.setdY(-5);
                    s.setCurrentYFrame(3);
                }
                s.update();
                drawView.invalidate();
                return false;
            }
        });
        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                s = drawView.sprite2;
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    s.setdX(0);
                    s.setdY(5);
                    s.setCurrentYFrame(0);
                }
                s.update();
                drawView.invalidate();
                return false;
            }
        });
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                s = drawView.sprite2;
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    s.setdX(-5);
                    s.setdY(0);
                    s.setCurrentYFrame(1);
                }
                s.update();
                drawView.invalidate();
                return false;
            }
        });
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                s = drawView.sprite2;
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    s.setdX(5);
                    s.setdY(0);
                    s.setCurrentYFrame(2);
                }
                s.update();
                drawView.invalidate();
                return false;
            }
        });
    }

    public void resetSprites(View view) {
        s = drawView.sprite;
        s.setPosition(0, 0);
        s.setdX(5);
        s.setdY(5);
        s.setCurrentYFrame(2);
        s = drawView.sprite2;
        s.setPosition(1000, 1000);
        drawView.invalidate();
    }
}