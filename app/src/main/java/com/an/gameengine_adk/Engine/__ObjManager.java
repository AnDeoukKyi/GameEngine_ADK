package com.an.gameengine_adk.Engine;

import android.graphics.Canvas;

import com.an.gameengine_adk.Engine.Obj.Obj;

import java.util.ArrayList;

public class __ObjManager {

    private ArrayList<Obj> __child = new ArrayList<>();
    private Obj __parent;

    public __ObjManager(Obj __parent) {
        this.__parent = __parent;
    }





    //--------------------------------DRAW-----------------------------------------------
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
    //--------------------------------DRAW-----------------------------------------------

    //--------------------------------OJBECT---------------------------------------------
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
    }
    //--------------------------------OJBECT---------------------------------------------
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
