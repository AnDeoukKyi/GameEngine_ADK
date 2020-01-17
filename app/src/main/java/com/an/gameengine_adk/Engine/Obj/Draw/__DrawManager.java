package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;

import java.util.ArrayList;

public class __DrawManager {

    private int  __drawNum = 1;
    private ArrayList<__Draw> __list_draw = new ArrayList<>();





    public void __draw(Canvas canvas) {
        for(int i = 0; i<__list_draw.size(); i++)
            __list_draw.get(i).__draw(canvas);

    }



    public void __add(__Draw draw){
        __list_draw.add(draw);
        draw.id = __drawNum++;
        //return
    }

    public void __remove(int num){
        __list_draw.remove(num);
    }

    public __Draw __get(int num){
        return __list_draw.get(0);
    }

    public int __size(){
        return __list_draw.size();
    }
}
