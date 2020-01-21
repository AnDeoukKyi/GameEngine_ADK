package com.an.gameengine_adk.Engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.an.gameengine_adk.Engine.Map.Camera.Camera;
import com.an.gameengine_adk.Engine.Obj.Mask.Mask;
import com.an.gameengine_adk.Engine.Obj.Obj;
import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.Structure.__MouseEvent;
import java.util.ArrayList;

public class __Engine {

    private Context context;
    private __Resource __resource;

    private Point DEVICESIZE;



    private __ObjManager __objManager = new __ObjManager(null);
    private int __objNum = 1;


    private Camera __camera;

    private __MouseEvent __mouseEvent;
    private Point mouse = new Point(0, 0);
    private Point __mouseClick = new Point(0, 0);
    private boolean __mouseDrag = false;





    //-------------------------------------L I F E     C Y C L E-----------------------------------------

    public void __Run(Context context){
        this.context = context;
        __resource = new __Resource(context);

        __deviceSize();
        __mouseEvent = new __MouseEvent();

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
    //-------------------------------------L I F E     C Y C L E-----------------------------------------


    //----------------------------------------D R A W------------------------------------------------
    public void __draw(Canvas canvas){
        __objManager.__draw(canvas);
    }
    //----------------------------------------D R A W------------------------------------------------

    //----------------------------------------C L I C K------------------------------------------------
    public void __mouse(int type, Point p){
        switch(type){
            case 1:
                __mouseDrag = false;
                mouse = p;
                __objManager.__mouse(p);
                __mouseClick = p;
                break;
            case 2:
                if(!__mouseDrag){
                    if(Math.sqrt((p.x - __mouseClick.x) * (p.x - __mouseClick.x) + (p.y - __mouseClick.y) * (p.y - __mouseClick.y)) <= 20)
                        __mouseDrag = true;
                    else
                        return;
                }
                mouse = p;
                if(__mouseEvent.__get_list_mask() != null)
                    __mouseEvent.__callMove(p, __mouseClick);
                break;
            case 3:
                mouse = p;
                if(__mouseDrag){
                    if(__mouseEvent.__get_list_mask() != null)
                        __mouseEvent.__callMoveEnd(p, __mouseClick);
                }
                else{
                    if(__mouseEvent.__get_list_mask() != null)
                        __mouseEvent.__callClick(p, __mouseClick);
                }
                __mouseEvent.__setMouseEvent(null, null);
                __mouseClick = p;
                break;
        }
    }

    public void __mouseEvent(Obj obj, ArrayList<Mask> list_mask){
        __mouseEvent.__setMouseEvent(obj, list_mask);
    }

    public Point __getMouse() {
        return mouse;
    }
    //----------------------------------------C L I C K------------------------------------------------


    //----------------------------------------M A P------------------------------------------------

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

    //----------------------------------------M A P------------------------------------------------





    //-----------------------------------O B J E C T-------------------------------------------------
    public void __addObj(Obj obj){
        __objManager.__add(obj);
    }

    public int __getObjNum(){
        return __objNum++;
    }
    //-----------------------------------O B J E C T-------------------------------------------------

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
