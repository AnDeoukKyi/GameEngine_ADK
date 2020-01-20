package com.an.gameengine_adk.User;

import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;
import com.an.gameengine_adk.Engine.Obj.Obj;

public class Monster3 extends Obj {


    @Override
    protected void Start() {
        super.Start();
        f_DrawSprite("pic", new Sprite("sprite/ch3"), new Rect(100, 100, 300, 300)).Show();

    }
}
