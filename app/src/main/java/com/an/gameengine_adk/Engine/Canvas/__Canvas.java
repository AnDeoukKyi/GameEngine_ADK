package com.an.gameengine_adk.Engine.Canvas;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;

import com.an.gameengine_adk.Engine.__Engine;
import com.an.gameengine_adk.Engine.Obj.Obj.__ObjManager;

public class __Canvas extends View {

    private __Engine __engine;
    private __ObjManager __objManager;

    public __Canvas(Context context) {
        super(context);
    }

    public __Canvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        __engine = __Engine.__getEngine();
        __objManager = __engine.__get_objManager();
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //rootPos
        __objManager.__setRootPos();
        //stepBefore
        __objManager.__stepBefore();
        //spriteIndexing
        __objManager.__spriteIndexing();
        //step
        __objManager.__step();
        //stepAfter
        __objManager.__stepAfter();
        //draw
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
