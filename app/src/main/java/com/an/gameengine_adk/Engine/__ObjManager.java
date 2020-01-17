package com.an.gameengine_adk.Engine;

import android.graphics.Canvas;

import com.an.gameengine_adk.Engine.Obj.Obj;

import java.util.ArrayList;

public class __ObjManager {

    private ArrayList<Obj> __list_obj = new ArrayList<>();








    public void __draw(Canvas canvas){
        for(int i = 0;  i<__list_obj.size(); i++){
            __list_obj.get(i).__draw(canvas);
        }
    }






    public Obj __get_ID(int id){
        for(int i = 0; i<__list_obj.size(); i++){
            if(__list_obj.get(i).id == id)
                return __list_obj.get(i);
        }
        return null;
    }

    public void __add(Obj obj){
        __list_obj.add(obj);
    }

    public void __remove(int num){
        __list_obj.remove(num);
    }

    public Obj __get(int num){
        return __list_obj.get(0);
    }

    public int __size(){
        return __list_obj.size();
    }
}
