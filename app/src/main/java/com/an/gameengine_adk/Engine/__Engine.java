package com.an.gameengine_adk.Engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.DisplayMetrics;

import com.an.gameengine_adk.Engine.Map.Camera.Camera;
import com.an.gameengine_adk.Engine.Obj.Obj;
import com.an.gameengine_adk.Engine.Resource.__Resource;

public class __Engine {

    private Context context;
    private __Resource __resource;

    private Point DEVICESIZE;



    private __ObjManager __objManager = new __ObjManager(null);
    private int __objNum = 1;


    private Camera __camera;








    //-------------------------------------LIFE     CYCLE-----------------------------------------

    public void __Run(Context context){
        this.context = context;
        __resource = new __Resource(context);

        __deviceSize();


        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        __objManager.__stepBefore();
                        __objManager.__spriteIndexing();
                        __objManager.__step();
                        __objManager.__stepAfter();
                        Thread.sleep(100);
                    } catch (Throwable t) {
                    }
                }
            }
        }).start();
    }
    //-------------------------------------LIFE     CYCLE-----------------------------------------


    //----------------------------------------DRAW------------------------------------------------
    public void __draw(Canvas canvas){
        __objManager.__draw(canvas);
    }
    //----------------------------------------DRAW------------------------------------------------



    //-----------map

    private void __deviceSize(){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        DEVICESIZE = new Point(metrics.widthPixels, metrics.heightPixels);
    }


    public Point __getDeviceSize(){
        return DEVICESIZE;
    }

    public void __attachCamera(Camera camera){
        this.__camera = camera;
    }

    public Camera __getCamera() {
        return __camera;
    }

    //-----------map





    //-----------------------------------OBJECT-------------------------------------------------
    public void __addObj(Obj obj){
        __objManager.__add(obj);
    }

    public int __getObjNum(){
        return __objNum++;
    }
    //-----------------------------------OBJECT-------------------------------------------------

    public Context __getContext() {
        return context;
    }

    public __Resource __get_resource() {
        return __resource;
    }

    private static class EngineHolder {
        public static final __Engine engine = new __Engine();
    }

    public static __Engine __getEngine() {
        return EngineHolder.engine;
    }
}
