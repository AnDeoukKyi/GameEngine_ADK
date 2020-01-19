package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Obj;
import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.__Engine;

public class __Draw {

    public int id;
    public String name;

    public int __drawType = 0;
    public Sprite __sprite = null;//drawType = 1;



    Point start;
    Rect rect;


    private Obj __obj;
    private String file;
    private double speed;
    private int index;



    public __Draw(String name, Obj obj) {
        this.name = name;
        this.__obj = obj;
    }


    public void __setRect(Rect rect){
        this.rect = rect;
    }

    public void __setPoint(Point point){
        this.start = point;
    }




    public Sprite __setSprite(String file, double speed, int index){
        __drawType = 1;
        this.file = file;
        this.speed = speed;
        this.index = index;
        __sprite = __obj.__get_engine().__get_resource().__createSprite();
        return __sprite;
    }


//    public Sprite __setSprite(__Engine engine, SpriteGroup sg, double speed, int index){
//        __drawType = 1;
//        __sprite = new Sprite(engine, sg.getPath() + "/" + sg.__getSpriteName().get(0), speed, index);
//        return __sprite;
//    }





    public void __draw(Canvas canvas){
        Rect rect;
        if(this.rect == null){
            rect = new Rect();
            rect.left = this.start.x;
            rect.top = this.start.y;
        }
        else
            rect = this.rect;
        switch(__drawType){
            case 1:
                if (__sprite == null){
                    //sprite생성해야됨
                    __sprite = __obj.__get_engine().__get_resource().__createSprite();
                }
                if(this.rect == null) {
                    rect.right = rect.left + __sprite.__get_sprite().getWidth();
                    rect.bottom = rect.top + __sprite.__get_sprite().getHeight();
                }
//                if(__sprite.__getSprite() == null){
//                    Log.e("Draw", "그릴려는 Sprite가 없습니다.");
//                    return;
//                }
                canvas.drawBitmap(__sprite.__get_sprite(), null, rect, null);
                break;
        }
    }



}
