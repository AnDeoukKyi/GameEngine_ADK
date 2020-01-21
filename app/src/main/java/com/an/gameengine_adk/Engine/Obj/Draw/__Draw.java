package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Map.Camera.Camera;
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
    private boolean __visible = false;
    private boolean __fixed = false;

    private Point start;
    private Rect rect;




    public __Draw(String name, Obj obj) {
        this.name = name;
        this.__obj = obj;
    }

    //-----------------------------------P O S I T I O N-------------------------------------------
    public void __setRect(Rect rect){
        this.rect = rect;
    }

    public void __setPoint(Point point){
        this.start = point;
    }
    //-----------------------------------P O S I T I O N-------------------------------------------





    //-------------------------------S P R I T E-----------------------------------------------
    public void __setSprite(String path){
        __drawType = 1;
        __path = path;
        __sprite = new Sprite(path, 0);
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
        __tag = sg.__get_tag();
        this.speed = speed;
        this.index = index;
        __spriteGroup = sg;
    }
    //-------------------------------S P R I T E-----------------------------------------------



    //--------------------------------S H O W------------------------------------------------
    public __Draw Fixed(){
        __fixed = true;
        return this;
    }

    public __Draw Show(){
        __visible = true;
        return this;
    }

    public void f_Show(boolean visible) {
        __visible = visible;
    }
    //--------------------------------S H O W------------------------------------------------

    //--------------------------------D R A W------------------------------------------------
    public void __spriteIndexing(){
        if(__spriteGroup != null){
            index++;
            if(index >= __spriteGroup.__size())
                index = 0;
        }
    }

    public void __draw(Canvas canvas){
        if (!__visible) return;//visible설정
        Rect printRect = __setPrintRect();
        switch(__drawType){
            case 1:
                if (__sprite.__get_sprite() == null){
                    String str;
                    if(__tag == null)
                        str = __path;
                    else
                        str = __tag;
                    __obj.__get_engine().__get_resource().__loadSprite(str);
                }
                if(this.rect == null) {
                    printRect.right = printRect.left + __sprite.__get_sprite().getWidth();
                    printRect.bottom = printRect.top + __sprite.__get_sprite().getHeight();
                }
                canvas.drawBitmap(__sprite.__get_sprite(), null, printRect, null);
                break;
            case 2:
                if (__spriteGroup.__getSprite((int)index).__get_sprite() == null) {
                    __obj.__get_engine().__get_resource().__loadSpriteGroup(__tag);
                }
                if(this.rect == null) {
                    printRect.right = printRect.left + __spriteGroup.__getSprite((int)index).__get_sprite().getWidth();
                    printRect.bottom = printRect.top + __spriteGroup.__getSprite((int)index).__get_sprite().getHeight();
                }
                canvas.drawBitmap(__spriteGroup.__getSprite((int)index).__get_sprite(), null, printRect, null);
                break;
        }
    }

    private Rect __setPrintRect(){
        Rect rect = new Rect();
        Camera camera = __obj.__get_engine().__getCamera();
        if(__fixed){//고정부분임
            rect = new Rect(this.rect);
        }
        else{
            int relX = __obj.posR.x + camera.width2;
            int relY = __obj.posR.y + camera.height2;
            if(camera.target != null){
                relX -= camera.pos.x;
                relY -= camera.pos.y;
            }
            if(this.rect == null){//시작좌표->높이길이는 알아서설정됨
                rect.left = (int)(start.x + relX);
                rect.top = (int)(start.y + relY);
            }
            else{//시작좌표, 끝좌표 다설정해야됨
                rect = new Rect(this.rect);
                rect.left = (int)(rect.left + relX);
                rect.top = (int)(rect.top + relY);
                rect.right = (int)(rect.right + relX);
                rect.bottom = (int)(rect.bottom + relY);
            }
        }
        return rect;
    }

    //--------------------------------D R A W------------------------------------------------



}
