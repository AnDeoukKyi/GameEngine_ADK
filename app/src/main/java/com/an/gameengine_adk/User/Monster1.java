package com.an.gameengine_adk.User;

import android.graphics.Point;
import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Obj;

public class Monster1 extends Obj {

    private int kkk = 10;

    @Override
    protected void Start() {
        super.Start();//최상위 부모만 호출
        int id1 = f_SetChild(new Monster2());
//        f_DrawSprite("pic", "__sprite/tile", 1, 0, new Point(100, 100));
//        f_DrawSprite("pic", "__sprite/tile", 1, 0, new Rect(200, 200, 400, 400));

        f_DrawSprite("pic", "sprite/background1", 1, 0, new Rect(0, 0, 1920, 1080));
//
        int[][]tile = new int[5][5];
        for(int i = 0; i<tile.length; i++){
            for(int j = 0; j<tile[0].length; j++){
                f_DrawSprite("pic", "sprite/tile", 1, 0, new Rect(600+j*100-i*100, j*100+i*100, 600+j*100-i*100+200, j*100+i*100+200));
            }
        }
        f_DrawSprite("pic", "sprite/ch1", 1, 0, new Rect(630, 670, 730, 870));


//        SpriteGroup sg = f_SpriteGroup("","__sprite/mon", "123", 0, 1);

    }
}
