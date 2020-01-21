package com.an.gameengine_adk.Engine.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.an.gameengine_adk.Engine.__Engine;


public class __Canvas extends View {

    private __Engine __engine;

    public __Canvas(Context context) {
        super(context);
    }

    public __Canvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        __engine = __Engine.__getEngine();
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        __engine.__draw(canvas);
        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                __engine.__mouse(1, new Point((int)event.getX(), (int)event.getY()));
                break;
            case MotionEvent.ACTION_MOVE:
                __engine.__mouse(2, new Point((int)event.getX(), (int)event.getY()));
                break;
            case MotionEvent.ACTION_UP:
                __engine.__mouse(3, new Point((int)event.getX(), (int)event.getY()));
                break;
        }
        return true;
    }
}
