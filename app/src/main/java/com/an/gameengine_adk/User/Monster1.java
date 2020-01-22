package com.an.gameengine_adk.User;

import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Obj.Obj;

public class Monster1 extends Obj {

    public int kkk = 10;

    @Override
    protected void Start() {
        Child(new Monster2());
    }

    @Override
    public void Run() {

//        DrawSprite("pic", "sprite/background1", 1, 0, new Point(0, 0, 1920, 1080));
////
//        int[][]tile = new int[5][5];
//        for(int i = 0; i<tile.length; i++){
//            for(int j = 0; j<tile[0].length; j++){
//                DrawSprite("pic", "sprite/tile", 1, 0, new Point(600+j*100-i*100, j*100+i*100, 600+j*100-i*100+200, j*100+i*100+200));
//            }
//        }
        //character
//
//        Sprite spr = new Sprite("11","sprite/ch2");
//        DrawSprite("pic", "sprite/ch1", 1, 0, new SPoint(630, 670, 730, 870));
//        DrawSprite("pic", GetSprite("11"), 1, 0, new SPoint(300, 300, 500, 500));
//        //path말고 tag로 접근도 가능해야됨
        DrawSprite("pic", 0, "sprite/ch1", new Rect(-400, -400, -200, -200)).Show();
        DrawSprite("pic", 0, "sprite/ch2", new Rect(-200, -400, 0, -200)).Show();
        DrawSprite("pic", 0, "sprite/ch3", new Rect(0, -400, 200, -200)).Show();
        DrawSprite("pic", 0, "sprite/ch4", new Rect(200, -400, 400, -200)).Show();
        DrawSprite("pic", 0, "sprite/ch5", new Rect(400, -400, 600, -200)).Show();




        DrawSprite("pic", 10, "sprite/ch1", new Rect(0, 0, 200, 200)).Show();
        DrawSprite("pic", 11, "sprite/ch2", new Rect(100, 0, 300, 200)).Show();

        //path 항상탐색이아니라 hash에 있는지 확인하는것도 필요함.


//
//
//        //character(group)
//        SpriteGroup sg = new SpriteGroup("123","sprite", "ch", 1, 5);
//
//        SpriteGroup sg1 = new SpriteGroup("sprite", "ch", 1, 3);
//        DrawSprite("pic", sg, 1, 0, new Rect(0, 0, 200, 200)).Show();
//        Mask(new Rect(0, 0, 300, 300)).Click(new Monster1Click());

    }

    @Override
    public void StepBefore() {
    }

    @Override
    public void Step() {
        pos.x+=1;
        pos.y+=0;
    }

    @Override
    public void StepAfter() {
    }
}
