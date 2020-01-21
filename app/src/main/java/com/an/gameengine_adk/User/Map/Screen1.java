package com.an.gameengine_adk.User.Map;

import android.graphics.Rect;
import android.util.Log;

import com.an.gameengine_adk.Engine.Map.Map.Map;
import com.an.gameengine_adk.Engine.Obj.Obj;
import com.an.gameengine_adk.User.Monster1;
import com.an.gameengine_adk.User.Monster3;

public class Screen1 extends Map {


    public Screen1() {
        Obj mon1 = CreateObj(new Monster1());
        mon1.AttachCamera();
        Obj mon3 = new Monster3();
        Log.e("gg", Boolean.toString(new Rect(0, 0, 200, 200).contains(-1, 100)));
    }




}
