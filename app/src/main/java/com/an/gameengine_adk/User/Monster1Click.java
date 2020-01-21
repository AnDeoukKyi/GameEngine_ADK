package com.an.gameengine_adk.User;

import android.graphics.Point;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Click.Click;

public class Monster1Click extends Click {

    @Override
    public void Move(Object target, Point start) {

        Log.e(target.toString(), "move");
    }

    @Override
    public void MoveEnd(Object target, Point start) {
        Log.e(target.toString(), "moveend");
    }

    @Override
    public void Click(Object target) {
        Log.e(target.toString(), "click");
    }
}
