package com.an.gameengine_adk.Engine.Obj.Obj;




import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;
import com.an.gameengine_adk.Engine.Obj.Draw.Draw;
import com.an.gameengine_adk.Engine.Obj.Draw.__DrawManager;
import com.an.gameengine_adk.Engine.Obj.Mask.Mask;
import com.an.gameengine_adk.Engine.Obj.Mask.__MaskManager;
import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.Structure.Circle;
import com.an.gameengine_adk.Engine.__Engine;

import java.util.ArrayList;


public class Obj {

    //----------------------------------------
    public int WIDTH;
    public int HEIGHT;
    public Point pos = new Point(0, 0);
    public Point posR = new Point(0, 0);
    //----------------------------------------

    //----------------------------------------
    protected __Engine __engine = __Engine.__getEngine();
    public int id = 0;
    protected __ObjManager __child;
    public Obj parent;
    private __ObjManager __parent;
    protected __DrawManager __drawManager;
    protected __Resource resource;
    //----------------------------------------


    private __MaskManager __maskManager;





    public Obj() {
        resource = __engine.__get_resource();
        Point p = __engine.__getDeviceSize();
        WIDTH = p.x;
        HEIGHT = p.y;
        __engine.__objCreate(this);
        Start();
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
    protected Mask Mask(Rect rect){
        if(__maskManager == null)
            __maskManager = new __MaskManager();
        Mask mask = new Mask(rect);
        __maskManager.__add(mask);
        return mask;
    }
    protected Mask Mask(Circle circle){
        if(__maskManager == null)
            __maskManager = new __MaskManager();
        Mask mask = new Mask(circle);
        __maskManager.__add(mask);
        return mask;
    }
    //-------------------------------------M A S K----------------------------------------------


    //-------------------------------------S P R I T E----------------------------------------------
    public Sprite GetSprite(String tag){
        return resource.__getSprite(tag);
    }


    protected Draw DrawSprite(String name, int deep, SpriteGroup sg, double speed, int index, Rect rect){
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        Draw draw = new Draw(this, name, deep);
        draw.__setSpriteGroup(sg, speed, index);
        draw.__setRect(rect);
        __drawManager.__add(draw);
        return draw;
    }

    protected Draw DrawSprite(String name, int deep, String path, Rect rect){
        String _path = resource.__checkFile(path);//return String
        if (_path == null)
            return null;
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        Draw draw = new Draw(this, name, deep);
        draw.__setSprite(path);
        draw.__setRect(rect);

        __drawManager.__add(draw);
        return draw;
    }

    protected Draw DrawSprite(String name, int deep, Sprite sprite, Rect rect){
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        Draw draw = new Draw(this, name, deep);
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
        posR.x = 0;
        posR.y = 0;
        Point rootP = __parent.__getRootPos();
        posR.x += pos.x + rootP.x;
        posR.y += pos.y + rootP.y;
        if(__child != null)
            __child.__setRootPos();
    }

    public __DrawManager __get_drawManager() {
        return __drawManager;
    }
    //-----------------------------------------D R A W------------------------------------------------







    protected void Start(){
    }

    //-------------------------------------------------O B J E C T--------------------------------------

    public Obj Child(Obj childObj){
        childObj.parent = this;
        if (__child == null)
            __child = new __ObjManager(this);
        __child.__add(childObj);
        return childObj;
    }
    //-------------------------------------------------O B J E C T--------------------------------------

    public void __set_parent(__ObjManager __parent) {
        this.__parent = __parent;
    }
    public __Engine __get_engine() {
        return __engine;
    }
}
