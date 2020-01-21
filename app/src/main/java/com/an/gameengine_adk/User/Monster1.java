package com.an.gameengine_adk.User;

import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Obj;

public class Monster1 extends Obj {


    @Override
    protected void Start() {
        super.Start();//최상위 부모만 호출
        int id1 = f_SetChild(new Monster2());
    }

    @Override
    public void Run() {
        f_SetDeep(10);

//        f_DrawSprite("pic", "sprite/background1", 1, 0, new SPoint(0, 0, 1920, 1080));
////
//        int[][]tile = new int[5][5];
//        for(int i = 0; i<tile.length; i++){
//            for(int j = 0; j<tile[0].length; j++){
//                f_DrawSprite("pic", "sprite/tile", 1, 0, new SPoint(600+j*100-i*100, j*100+i*100, 600+j*100-i*100+200, j*100+i*100+200));
//            }
//        }
        //character
//
//        Sprite spr = new Sprite("11","sprite/ch2");
//        f_DrawSprite("pic", "sprite/ch1", 1, 0, new SPoint(630, 670, 730, 870));
//        f_DrawSprite("pic", f_GetSprite("11"), 1, 0, new SPoint(300, 300, 500, 500));
//        //path말고 tag로 접근도 가능해야됨
        Sprite spr2 = new Sprite("sprite/ch3");
        f_DrawSprite("pic", spr2, new Rect(0, 0, 200, 200)).Show();
//
//
//        //character(group)
//        SpriteGroup sg = new SpriteGroup("123","sprite", "ch", 1, 5);
//
//        SpriteGroup sg1 = new SpriteGroup("sprite", "ch", 1, 3);
//        f_DrawSprite("pic", sg, 1, 0, new Rect(0, 0, 200, 200)).Show();
//        f_Mask(new Rect(0, 0, 300, 300)).Click(new Monster1Click());
//        new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    try {
//                        pos.x+=10;
//                        Thread.sleep(100);
//                    } catch (Throwable t) {
//                    }
//                }
//            }
//        }).start();
        pos.x = 100;
        pos.y = 0;
    }

    @Override
    public void StepBefore() {
    }

    @Override
    public void Step() {
    }

    @Override
    public void StepAfter() {
    }
}
