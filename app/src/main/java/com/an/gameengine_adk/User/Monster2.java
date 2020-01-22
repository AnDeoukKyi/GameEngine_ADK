package com.an.gameengine_adk.User;

import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Obj.Obj;

public class Monster2 extends Obj {

    private int kkk = 10;


    @Override
    protected void Start() {
//        pos.x = 200;
//        pos.y = 0;
    }

    @Override
    public void Run() {

//        Sprite spr2 = new Sprite("sprite/ch1");
//        DrawSprite("pic", spr2, new Rect(0, 0, 200, 200)).Show();

        DrawSprite("pic", 10, "sprite/ch1", new Rect(0, 100, 200, 300)).Show();
        DrawSprite("pic", 11, "sprite/ch2", new Rect(100, 100, 300, 300)).Show();

        //자식이 부모보다 위에 있을수도 있고 밑에있을 수도 있어야됨.




        //Level로 설정하자
        //Level(0)Root
        //Level(1)그아래오브젝트...
        //같은레벨끼리 경쟁
        /*

        Level(0)기준
        -(아래로)

         */
    }
}
