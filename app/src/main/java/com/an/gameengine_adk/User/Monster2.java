package com.an.gameengine_adk.User;

import android.graphics.Point;
import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Obj;

public class Monster2 extends Obj {

    private int kkk = 10;


    @Override
    protected void Start() {
        pos.x = 200;
        pos.y = 0;
    }

    @Override
    public void Run() {

        Sprite spr2 = new Sprite("sprite/ch1");
        f_DrawSprite("pic", spr2, new Rect(0, 0, 200, 200)).Show();
    }
}
