package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.__Engine;

public class __Draw {

    public int id;
    public String name;

    public int __drawType = 0;
    public Sprite sprite = null;//drawType = 1;



    Point start;
    Rect rect;

    public __Draw(String name) {
        this.name = name;
    }



    public void __setPoint(Point point){
        this.start = point;
    }

    public Sprite __setSprite(__Engine engine, String file, double speed, int index){
        __drawType = 1;
        sprite = new Sprite(engine, file, speed, index);
        return sprite;
    }







    public void __draw(Canvas canvas){
        switch(__drawType){
            case 1:
                if (sprite.__getSprite() == null){
                    //sprite생성해야됨
                }
                canvas.drawBitmap(sprite.sprite, null, new Rect(600, 400, 800, 800), null);
                break;
        }
    }



}
