package com.an.gameengine_adk.Engine;

import android.graphics.Canvas;
import android.graphics.Point;

import com.an.gameengine_adk.Engine.Obj.Obj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class __ObjManager {

    private ArrayList<Obj> __child = new ArrayList<>();
    private Obj __parent;

    public __ObjManager(Obj __parent) {
        this.__parent = __parent;
    }



    public void __setRootPos(){
        for(int i = 0; i< __child.size(); i++){
            __child.get(i).__setRootPos();
        }
    }



    public void __stepBefore(){
        for(int i = 0; i< __child.size(); i++){
            __child.get(i).StepBefore();
        }
    }

    public void __step(){
        for(int i = 0; i< __child.size(); i++){
            __child.get(i).Step();
        }
    }

    public void __stepAfter(){
        for(int i = 0; i< __child.size(); i++){
            __child.get(i).StepAfter();
        }
    }


    //----------------------------------------C L I C K------------------------------------------------

    public boolean __mouse(Point p){
        for(int i = 0; i< __child.size(); i++){
            if(__child.get(i).__mouse(p))
                return true;
        }
        return false;
    }
    //----------------------------------------C L I C K------------------------------------------------
    //--------------------------------D R A W-----------------------------------------------
    public void __spriteIndexing(){
        for(int i = 0; i< __child.size(); i++){
            __child.get(i).__spriteIndexing();
        }
    }

    public void __draw(Canvas canvas){
        for(int i = 0; i< __child.size(); i++){
            __child.get(i).__draw(canvas);
        }
    }

    public Point __getRootPos(){
        if(__parent == null) return new Point(0, 0);
        return __parent.posR;
    }
    //--------------------------------D R A W-----------------------------------------------

    //--------------------------------O J B E C T---------------------------------------------
    public Obj __get_ID(int id){
        for(int i = 0; i< __child.size(); i++){
            if(__child.get(i).id == id)
                return __child.get(i);
        }
        return null;
    }

    public void __add(Obj obj){
        __child.add(obj);
        obj.__set_parent(this);
        __deepSort();
    }

    public void __deepSort(){
        Comparator<Obj> cmpDeep = new Comparator<Obj>() {
            @Override
            public int compare(Obj obj1, Obj obj2) {
                return obj2.f_GetDeep() - obj1.f_GetDeep();
            }
        };
        Collections.sort(__child, cmpDeep);
    }

    //--------------------------------O J B E C T---------------------------------------------
    public void __remove(int num){
        __child.remove(num);
    }

    public Obj __get(int num){
        return __child.get(0);
    }

    public int __size(){
        return __child.size();
    }
}
