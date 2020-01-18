package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.an.gameengine_adk.Engine.__Engine;

public class __Draw {

    public int id;
    public String name;

    public int __drawType = 0;
    public Sprite __sprite = null;//drawType = 1;



    Point start;
    Rect rect;




    public __Draw(String name) {
        this.name = name;
    }


    public void __setRect(Rect rect){
        this.rect = rect;
    }

    public void __setPoint(Point point){
        this.start = point;
    }

    public Sprite __setSprite(__Engine engine, String file, double speed, int index){
        __drawType = 1;
        __sprite = new Sprite(engine, file, speed, index);
        return __sprite;
    }







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
                if (__sprite.__getSprite() == null){
                    //sprite생성해야됨
                    __sprite.__createSprite();
                }
                if(this.rect == null) {
                    rect.right = rect.left + __sprite.__getSprite().getWidth();
                    rect.bottom = rect.top + __sprite.__getSprite().getHeight();
                }
                canvas.drawBitmap(__sprite.__getSprite(), null, rect, null);
                break;
        }
    }



}
