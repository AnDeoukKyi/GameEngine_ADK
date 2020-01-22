package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class __DrawManager {

    private int  __drawNum = 1;
    private ArrayList<Draw> __list_draw = new ArrayList<>();



    public void __draw(Canvas canvas) {
        for(int i = 0; i<__list_draw.size(); i++)
            __list_draw.get(i).__draw(canvas);
    }


    //-----------------------------------D R A W--------------------------------------------------
    public void __spriteIndexing(){
        for(int i = 0; i<__list_draw.size(); i++)
            __list_draw.get(i).__spriteIndexing();
    }
    //-----------------------------------D R A W--------------------------------------------------

    public void __add(Draw draw){
        __list_draw.add(draw);
        draw.id = __drawNum++;
    }

    public ArrayList<Draw> __get_list_draw() {
        return __list_draw;
    }

    public void __remove(int num){
        __list_draw.remove(num);
    }

    public Draw __get(int num){
        return __list_draw.get(0);
    }

    public int __size(){
        return __list_draw.size();
    }
}
