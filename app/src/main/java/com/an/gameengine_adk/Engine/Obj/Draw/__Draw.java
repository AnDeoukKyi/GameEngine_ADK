package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Obj;

public class __Draw {

    public int id;
    public String name;

    public int __drawType = 0;
    public Sprite __sprite = null;//drawType = 1;



    Point start;
    Rect rect;


    private Obj __obj;
    private String path;
    private double speed;
    private int index;
    private String tag = "";



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



//1
    public Sprite __setSprite(String path, double speed, int index){
        __drawType = 1;
        this.path = path;
        this.speed = speed;
        this.index = index;
        __sprite = new Sprite(path);
        return __sprite;
    }
//2
    public Sprite __setSprite(Sprite sprite, double speed, int index){
        __drawType = 1;
        this.speed = speed;
        this.index = index;
        path = sprite.__get_path();
        __sprite = sprite;
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
                    __sprite = __obj.__get_engine().__get_resource().__getSprite(tag, path);
                }
                if(this.rect == null) {
                    rect.right = rect.left + __sprite.__get_sprite().getWidth();
                    rect.bottom = rect.top + __sprite.__get_sprite().getHeight();
                }
                if(__sprite.__get_sprite() == null){
                    Log.e("Draw", "그릴려는 Sprite가 없습니다.");
                    return;
                }
                canvas.drawBitmap(__sprite.__get_sprite(), null, rect, null);
                break;
        }
    }



}
