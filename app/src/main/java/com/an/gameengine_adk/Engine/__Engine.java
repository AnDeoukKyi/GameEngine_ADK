package com.an.gameengine_adk.Engine;

import android.content.Context;
import android.graphics.Canvas;

import com.an.gameengine_adk.Engine.Obj.Obj;
import com.an.gameengine_adk.Engine.Resource.__Resource;

public class __Engine {


    private Context context;
    private __Resource __resource;




    //
    private __ObjManager __objManager = new __ObjManager(null);
    private int __objNum = 1;
    //





    public void __Run(Context context){
        this.context = context;
        __resource = new __Resource(context);

    }


    public void __draw(Canvas canvas){
        __objManager.__draw(canvas);
    }

    public Context __getContext() {
        return context;
    }

    public __Resource __get_resource() {
        return __resource;
    }

    public void __addObj(Obj obj){
        __objManager.__add(obj);
    }

    public int __getObjNum(){
        return __objNum++;
    }

    private static class EngineHolder {
        public static final __Engine engine = new __Engine();
    }

    public static __Engine __getEngine() {
        return EngineHolder.engine;
    }
}
