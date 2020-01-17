package com.an.gameengine_adk.Engine.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class _Canvas extends View {

    public _Canvas(Context context) {
        super(context);
    }

    public _Canvas(Context context, AttributeSet attrs) {
        super(context, attrs);
//        engine = SA_Engine.getEngine();
//        printWindowSize = engine.isPrintWindowSize();
//        paint = new Paint();
//        paint.setTextSize(30);
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        engine.getObjMaster().draw(canvas);

        invalidate();
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        switch(event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                engine.SA_Touch(SA_FLAG.ENGINE_CLICK_DOWN, (int)event.getX(), (int)event.getY());
//                break;
//            case MotionEvent.ACTION_UP:
//                engine.SA_Touch(SA_FLAG.ENGINE_CLICK_UP, (int)event.getX(), (int)event.getY());
//                break;
//            case MotionEvent.ACTION_MOVE:
//                engine.SA_Touch(SA_FLAG.ENGINE_CLICK_DRAG, (int)event.getX(), (int)event.getY());
//                break;
//        }

        return true;
    }
}
