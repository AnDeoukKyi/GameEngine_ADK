package com.an.gameengine_adk.User.Map;

import com.an.gameengine_adk.Engine.Map.Map.Map;
import com.an.gameengine_adk.Engine.Obj.Obj.Obj;
import com.an.gameengine_adk.User.Monster1;
import com.an.gameengine_adk.User.Monster3;

public class Screen1 extends Map {


    public Screen1() {
        Obj mon1 = CreateObj(new Monster1());
        mon1.AttachCamera();
        Obj mon3 = CreateObj(new Monster3());
    }




}
