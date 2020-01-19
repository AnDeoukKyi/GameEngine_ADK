package com.an.gameengine_adk.Engine.Obj;




import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;
import com.an.gameengine_adk.Engine.Obj.Draw.__Draw;
import com.an.gameengine_adk.Engine.Obj.Draw.__DrawManager;
import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.__Engine;
import com.an.gameengine_adk.Engine.__ObjManager;



public class Obj {



    //
    public double x = 0;
    public double y = 0;
    public int deep = 0;
    //

    //
    protected __Engine __engine = __Engine.__getEngine();
    //
    public int id = 0;
    protected __ObjManager __child;
    public Obj parent;
    public __ObjManager __parent;
    protected boolean __root = false;
    //






    //------------------------------------
    protected __DrawManager __drawManager;
    protected __Resource resource;


    //-------------------------------------


    public Obj() {
        resource = __engine.__get_resource();
        __getObjNum();
        Start();
        __addObj();
    }
    //







    protected __Draw f_DrawSprite(String name, SpriteGroup sg, double speed, int index, Rect rect){
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        __Draw draw = new __Draw(name, this);
        draw.__setSpriteGroup(sg, speed, index);
        draw.__setRect(rect);

        __drawManager.__add(draw);
        return draw;
    }


    //1. String path를 주는경우와
    //2. 아예 Sprite를 만들어서 주는경우가 있음

    protected __Draw f_DrawSprite(String name, String path, double speed, int index, Rect rect){
        String _path = resource.__checkFile(path);//return String
        if (_path == null)
            return null;
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        __Draw draw = new __Draw(name, this);
        draw.__setSprite(path, speed, index);
        draw.__setRect(rect);

        __drawManager.__add(draw);
        return draw;
    }

    //2.
    protected __Draw f_DrawSprite(String name, Sprite sprite, double speed, int index, Rect rect){
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        __Draw draw = new __Draw(name, this);
        draw.__setSprite(sprite, speed, index);
        draw.__setRect(rect);

        __drawManager.__add(draw);
        return draw;
    }



//    protected __Draw f_DrawSprite(String name, String path, double speed, int index, Point point){
//        String file = resource.__checkFile(path);//return String
//        if (file == null)
//            return null;
//        if (__drawManager == null)
//            __drawManager = new __DrawManager();
//
//        __Draw draw = new __Draw(name, this);
//        draw.__setSprite(__engine, file, speed, index);
//        draw.__setPoint(point);
//
//        __drawManager.__add(draw);
//        return draw;
//    }




    public void __spriteIndexing(){
        if (__child != null)
            __child.__spriteIndexing();
        if(__drawManager != null)
            __drawManager.__spriteIndexing();
    }


    public Sprite f_GetSprite(String tag){
        return resource.__getSprite(tag);
    }


    public void __draw(Canvas canvas){
        if (__child != null)
            __child.__draw(canvas);
        if(__drawManager != null)
            __drawManager.__draw(canvas);
    }

    public __Engine __get_engine() {
        return __engine;
    }


//

    protected void __getObjNum(){
        id = __engine.__getObjNum();
    }

    protected void Start(){
        __root = true;
        Log.e("Object", "최상위Object가 생성되었습니다." + this.getClass().toString());
    }

    protected void __addObj(){
        if(__root)
            __engine.__addObj(this);
    }

    public void __set_parent(__ObjManager __parent) {
        this.__parent = __parent;
    }

    public Obj f_GetChild(int id){
        return __child.__get_ID(id);
    }

    public int f_SetChild(Obj childObj){
        childObj.parent = this;
        if (__child == null)
            __child = new __ObjManager(this);
        __child.__add(childObj);
        return childObj.id;
    }
}
