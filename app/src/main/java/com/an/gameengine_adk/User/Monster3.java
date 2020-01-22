package com.an.gameengine_adk.User;

import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Obj.Obj;

public class Monster3 extends Obj {


    @Override
    protected void Start() {
        super.Start();
//        DrawSprite("pic", new Sprite("sprite/ch3"), new Rect(100, 100, 300, 300)).Show();
    }

    @Override
    public void Run() {
        DrawSprite("pic", 0, "sprite/ch1", new Rect(-400, -400, -200, -200)).Show();
    }
}
