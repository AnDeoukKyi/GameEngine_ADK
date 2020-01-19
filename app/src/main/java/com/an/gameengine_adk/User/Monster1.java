package com.an.gameengine_adk.User;

import android.graphics.Point;
import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;
import com.an.gameengine_adk.Engine.Obj.Obj;

public class Monster1 extends Obj {

    private int kkk = 10;

    @Override
    protected void Start() {
        super.Start();//최상위 부모만 호출
        int id1 = f_SetChild(new Monster2());

//        f_DrawSprite("pic", "sprite/background1", 1, 0, new Rect(0, 0, 1920, 1080));
////
//        int[][]tile = new int[5][5];
//        for(int i = 0; i<tile.length; i++){
//            for(int j = 0; j<tile[0].length; j++){
//                f_DrawSprite("pic", "sprite/tile", 1, 0, new Rect(600+j*100-i*100, j*100+i*100, 600+j*100-i*100+200, j*100+i*100+200));
//            }
//        }
        //character


//        Sprite spr2 = new Sprite("sprite/ch3");
//        /*
//        Sprite->path등록
//        path기반으로 Sprite의 sprite(Bitmap)등록
//        Resource에 path : Sprite로 등록
//         */
//        Sprite spr = new Sprite("11","sprite/ch2");
//        /*
//        Sprite->path등록
//        path기반으로 Sprite의 sprite(Bitmap)등록
//        Resource에 tag : Sprite로 등록
//         */
//        f_DrawSprite("pic", "sprite/ch1", 1, 0, new Rect(630, 670, 730, 870));
//        /*
//        ->tag없어야됨
//
//         */
//        f_DrawSprite("pic", f_GetSprite("11"), 1, 0, new Rect(300, 300, 500, 500));
//        //path말고 tag로 접근도 가능해야됨
//        f_DrawSprite("pic", spr, 1, 0, new Rect(100, 100, 300, 300));
//
//
//        //character(group)
        SpriteGroup sg = new SpriteGroup("123","sprite", "ch", 1, 5);

        SpriteGroup sg1 = new SpriteGroup("sprite", "ch", 1, 3);
        f_DrawSprite("pic", sg, 1, 0, new Rect(100, 100, 300, 300));
        int k = 10;

    }
}
