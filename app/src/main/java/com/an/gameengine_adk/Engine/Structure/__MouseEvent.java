package com.an.gameengine_adk.Engine.Structure;

import android.graphics.Point;

import com.an.gameengine_adk.Engine.Obj.Mask.Mask;
import com.an.gameengine_adk.Engine.Obj.Obj;

import java.util.ArrayList;

public class __MouseEvent {

    private Obj __obj;
    private ArrayList<Mask> __list_mask;




    public void __callClick(Point p, Point click){
        for(int i = 0; i<__list_mask.size(); i++)
            __list_mask.get(i).__checkClick(p, click, __obj);
    }

    public void __callMove(Point p, Point click){
        for(int i = 0; i<__list_mask.size(); i++)
            __list_mask.get(i).__checkMove(p, click, __obj);
    }

    public Obj __get_obj() {
        return __obj;
    }

    public ArrayList<Mask> __get_list_mask() {
        return __list_mask;
    }

    public void __setMouseEvent(Obj obj, ArrayList<Mask> list_mask) {
        __obj = obj;
        __list_mask = list_mask;
    }
}
