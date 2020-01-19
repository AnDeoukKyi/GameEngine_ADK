package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Obj;

public class __Draw {

    public int id;
    private Obj __obj;
    public String name;
    private int __drawType = 0;
    private Sprite __sprite;//drawType = 1;
    private SpriteGroup __spriteGroup;//drawType = 2;
    private String __path;
    private String __tag;
    private double speed;
    private double index;

    private Point start;
    private Rect rect;




    public __Draw(String name, Obj obj) {
        this.name = name;
        this.__obj = obj;
    }

    //-----------------------------------POSITION-------------------------------------------
    public void __setRect(Rect rect){
        this.rect = rect;
    }

    public void __setPoint(Point point){
        this.start = point;
    }
    //-----------------------------------POSITION-------------------------------------------





    //-------------------------------SPRITE-----------------------------------------------
    public void __setSprite(String path){
        __drawType = 1;
        __path = path;
        __sprite = new Sprite(path);
    }

    public void __setSprite(Sprite sprite){
        __drawType = 1;
        if(sprite.__get_path() == null)
            __tag = sprite.__get_tag();
        else
            __path = sprite.__get_path();
        __sprite = sprite;
    }

    public void __setSpriteGroup(SpriteGroup sg, double speed, int index){
        __drawType = 2;
        this.speed = speed;
        this.index = index;
        __spriteGroup = sg;
    }
    //-------------------------------SPRITE-----------------------------------------------



    //--------------------------------DRAW------------------------------------------------
    public void __spriteIndexing(){
        if(__spriteGroup != null){
            index++;
            if(index >= __spriteGroup.__size())
                index = 0;
        }
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
                if (__sprite.__get_sprite() == null){
                    String str;
                    if(__tag == null)
                        str = __path;
                    else
                        str = __tag;
//                    __sprite = __obj.__get_engine().__get_resource().__getSprite(str);
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
            case 2:
                if(this.rect == null) {
                    rect.right = rect.left + __spriteGroup.__getSprite((int)index).__get_sprite().getWidth();
                    rect.bottom = rect.top + __spriteGroup.__getSprite((int)index).__get_sprite().getHeight();
                }
                canvas.drawBitmap(__spriteGroup.__getSprite((int)index).__get_sprite(), null, rect, null);
                break;
        }
    }
    //--------------------------------DRAW------------------------------------------------
}
