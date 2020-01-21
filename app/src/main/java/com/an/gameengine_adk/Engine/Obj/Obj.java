package com.an.gameengine_adk.Engine.Obj;




import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;
import com.an.gameengine_adk.Engine.Obj.Draw.__Draw;
import com.an.gameengine_adk.Engine.Obj.Draw.__DrawManager;
import com.an.gameengine_adk.Engine.Obj.Mask.Mask;
import com.an.gameengine_adk.Engine.Obj.Mask.__MaskManager;
import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.Structure.Circle;
import com.an.gameengine_adk.Engine.__Engine;
import com.an.gameengine_adk.Engine.__ObjManager;

import java.util.ArrayList;


public class Obj {

    //----------------------------------------
    public int WIDTH;
    public int HEIGHT;
    public Point pos = new Point(0, 0);
    public Point posR = new Point(0, 0);
    private int __deep = 0;
    //----------------------------------------

    //----------------------------------------
    protected __Engine __engine = __Engine.__getEngine();
    public int id = 0;
    protected __ObjManager __child;
    public Obj parent;
    private __ObjManager __parent;
    protected boolean __root = false;
    protected __DrawManager __drawManager;
    protected __Resource resource;
    //----------------------------------------


    private __MaskManager __maskManager;





    public Obj() {
        resource = __engine.__get_resource();
        Point p = __engine.__getDeviceSize();
        WIDTH = p.x;
        HEIGHT = p.y;
        __getObjNum();
        Start();
        __addObj();
        Run();
    }

    public void Run(){

    }






    //-------------------------------------C A M E R A----------------------------------------------
    public void AttachCamera(){
        __engine.__getCamera().Attach(this);
    }
    //-------------------------------------C A M E R A----------------------------------------------


    //-------------------------------------S T E P----------------------------------------------


    public void StepBefore(){

    }
    public void Step(){

    }
    public void StepAfter(){

    }
    //-------------------------------------S T E P----------------------------------------------



    //-------------------------------------C L I C K----------------------------------------------
    public boolean __mouse(Point p){
        ArrayList<Mask> list_mask = null;
        if(__maskManager != null){
            list_mask = __maskManager.__mouse(p);
            if(list_mask != null){
                __engine.__mouseEvent(this, list_mask);
                return true;
            }
        }
        if (__child != null)
            if(__child.__mouse(p)){
                return true;
            }
        return false;
    }
    //-------------------------------------C L I C K----------------------------------------------



    //-------------------------------------M A S K----------------------------------------------
    protected Mask f_Mask(Rect rect){
        if(__maskManager == null)
            __maskManager = new __MaskManager();
        Mask mask = new Mask(rect);
        __maskManager.__add(mask);
        return mask;
    }
    protected Mask f_Mask(Circle circle){
        if(__maskManager == null)
            __maskManager = new __MaskManager();
        Mask mask = new Mask(circle);
        __maskManager.__add(mask);
        return mask;
    }
    //-------------------------------------M A S K----------------------------------------------


    //-------------------------------------S P R I T E----------------------------------------------
    public Sprite f_GetSprite(String tag){
        return resource.__getSprite(tag);
    }

    protected __Draw f_DrawSprite(String name, SpriteGroup sg, double speed, int index, Rect rect){
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        __Draw draw = new __Draw(name, this);
        draw.__setSpriteGroup(sg, speed, index);
        draw.__setRect(rect);
        __drawManager.__add(draw);
        return draw;
    }

    protected __Draw f_DrawSprite(String name, String path, Rect rect){
        String _path = resource.__checkFile(path);//return String
        if (_path == null)
            return null;
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        __Draw draw = new __Draw(name, this);
        draw.__setSprite(path);
        draw.__setRect(rect);

        __drawManager.__add(draw);
        return draw;
    }

    protected __Draw f_DrawSprite(String name, Sprite sprite, Rect rect){
            if (__drawManager == null)
                __drawManager = new __DrawManager();

        __Draw draw = new __Draw(name, this);
        draw.__setSprite(sprite);
        draw.__setRect(rect);

        __drawManager.__add(draw);
        return draw;
    }
    //-------------------------------------S P R I T E----------------------------------------------









    //-----------------------------------------D R A W------------------------------------------------
    public void __spriteIndexing(){
        if (__child != null)
            __child.__spriteIndexing();
        if(__drawManager != null)
            __drawManager.__spriteIndexing();
    }

    public void __draw(Canvas canvas){
        if (__child != null)
            __child.__draw(canvas);
        if(__drawManager != null)
            __drawManager.__draw(canvas);
    }

    public void __setRootPos(){
        posR = new Point(__parent.__getRootPos());
        posR.x += pos.x;
        posR.y += pos.y;
        if(__child != null)
            __child.__setRootPos();
    }



    //-----------------------------------------D R A W------------------------------------------------





    protected void __getObjNum(){
        id = __engine.__getObjNum();
    }

    protected void Start(){
        __root = true;
        Log.e("Object", "최상위Object가 생성되었습니다." + this.getClass().toString());
    }

    //-------------------------------------------------O B J E C T--------------------------------------
    protected void __addObj(){
        if(__root)
            __engine.__addObj(this);
    }

    protected void f_SetDeep(int deep){
        __deep = deep;
        __parent.__deepSort();
    }

    public int f_GetDeep(){
        return __deep;
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
    //-------------------------------------------------O B J E C T--------------------------------------

    public void __set_parent(__ObjManager __parent) {
        this.__parent = __parent;
    }
    public __Engine __get_engine() {
        return __engine;
    }
}
