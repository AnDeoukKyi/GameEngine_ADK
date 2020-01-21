package com.an.gameengine_adk.Engine.Obj.Mask;

import android.graphics.Point;

import java.util.ArrayList;

public class __MaskManager {
    private ArrayList<Mask> __list_mask = new ArrayList<>();




    public ArrayList<Mask> __mouse(Point p){
        ArrayList<Mask> list_mask = null;
        for(int i = 0; i<__list_mask.size(); i++){
            if(__list_mask.get(i).__mouse(p)){
                if(list_mask == null) list_mask = new ArrayList<>();
                list_mask.add(__list_mask.get(i));
            }
        }
        return list_mask;
    }


    public void __add(Mask mask){
        __list_mask.add(mask);
    }

    public void __remove(int num){
        __list_mask.remove(num);
    }

    public Mask __get(int num){
        return __list_mask.get(0);
    }

    public int __size(){
        return __list_mask.size();
    }
}
