package com.an.gameengine_adk.User;

import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;
import com.an.gameengine_adk.Engine.Obj.Obj;

public class Monster1 extends Obj {

    private int kkk = 10;

    @Override
    protected void Start() {
        super.Start();//최상위 부모만 호출
        int id1 = f_SetChild(new Monster2());
        f_DrawSprite();

        resource.f_SpriteGroup("","sprite/mon", "123", 0, 1);

    }
}