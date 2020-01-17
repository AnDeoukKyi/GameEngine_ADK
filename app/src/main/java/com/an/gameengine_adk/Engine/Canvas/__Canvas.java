package com.an.gameengine_adk.Engine.Canvas;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.an.gameengine_adk.Engine.__Engine;

import java.io.IOException;
import java.io.InputStream;

public class __Canvas extends View {

    private __Engine __engine;


    public __Canvas(Context context) {
        super(context);
    }

    public __Canvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        __engine = __Engine.__getEngine();
//        printWindowSize = engine.isPrintWindowSize();
//        paint = new Paint();
//        paint.setTextSize(30);
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //wait삭제할거 삭제한뒤에 출력함

//        engine.getObjMaster().__draw(canvas);
        __engine.__draw(canvas);


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
