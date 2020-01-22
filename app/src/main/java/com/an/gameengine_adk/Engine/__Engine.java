package com.an.gameengine_adk.Engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.an.gameengine_adk.Engine.Map.Camera.Camera;
import com.an.gameengine_adk.Engine.Obj.Draw.Draw;
import com.an.gameengine_adk.Engine.Obj.Mask.Mask;
import com.an.gameengine_adk.Engine.Obj.Obj.Obj;
import com.an.gameengine_adk.Engine.Obj.Obj.__ObjManager;
import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.Structure.__MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class __Engine {

    private Context context;
    private __Resource __resource;

    private Point DEVICESIZE;



    private __ObjManager __objManager = new __ObjManager(null);
    private HashMap<Integer, Obj> __hash_obj = new HashMap<>();
    private ArrayList<Draw> __list_draw = new ArrayList<>();
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
                        __objManager.__setRootPos();
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
        __list_draw.clear();
        for(int id : __hash_obj.keySet()){
            Obj obj = __hash_obj.get(id);
            if(obj.__get_drawManager() != null){
                for(Draw draw : obj.__get_drawManager().__get_list_draw()){
                    __list_draw.add(draw);
                }
            }
        }
        Collections.sort(__list_draw, cmpDeep);
        for(int i = 0; i<__list_draw.size(); i++){
            __list_draw.get(i).__draw(canvas);
        }
    }

    private Comparator<Draw> cmpDeep = new Comparator<Draw>() {
        @Override
        public int compare(Draw draw1, Draw draw2) {
            return draw1.__get_deep() - draw2.__get_deep();
        }
    };
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
    public void __objCreateFinish(Obj obj){
        __objManager.__add(obj);
    }

    public void __objCreate(Obj obj){
        __hash_obj.put(__objNum, obj);
        obj.id = ++__objNum;
    }
    //-----------------------------------O B J E C T-------------------------------------------------


    public __ObjManager __get_objManager() {
        return __objManager;
    }

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
