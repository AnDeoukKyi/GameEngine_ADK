package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

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

    public void setSprite(){
        __drawType = 1;
//        sprite = new Sprite();
    }







    public void __draw(Canvas canvas){
        switch(__drawType){
            case 1:
                canvas.drawBitmap(sprite.sprite, null, new Rect(600, 400, 800, 800), null);
                break;
        }
    }



}
