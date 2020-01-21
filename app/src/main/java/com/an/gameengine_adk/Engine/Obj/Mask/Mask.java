package com.an.gameengine_adk.Engine.Obj.Mask;

import android.graphics.Point;
import android.graphics.Rect;

import com.an.gameengine_adk.Engine.Obj.Click.Click;
import com.an.gameengine_adk.Engine.Obj.Obj;
import com.an.gameengine_adk.Engine.Structure.Circle;

public class Mask {


    private int __maskType = 0;
    private Rect __rect;
    private Circle __circle;
    private Click __clickListener;

    public Mask( Rect rect) {
        __maskType = 0;
        __rect = rect;
        __circle = null;
    }

    public Mask(Circle circle) {
        __maskType = 1;
        __circle = circle;
        __rect = null;
    }

    public boolean __mouse(Point p){
        switch (__maskType){
            case 0://rect
                return __rect.contains(p.x, p.y);
            case 1:
                return __circle.contains(p.x, p.y);
        }
        return false;
    }

    public void __checkClick(Point p, Point click, Obj obj){
        if(__mouse(p)){
            if(Math.sqrt((p.x - click.x) * (p.x - click.x) + (p.y - click.y) * (p.y - click.y)) <= 20)
                __clickListener.Click(obj);
        }
    }

    public void __checkMove(Point p, Point start, Obj obj){
        if(Math.sqrt((p.x - start.x) * (p.x - start.x) + (p.y - start.y) * (p.y - start.y)) > 20)
            __clickListener.Move(obj, start);
    }

    public void __callMoveEnd(Point p, Point click, Obj obj){
        __clickListener.MoveEnd(obj, click);
    }

    public void Click(Click click){
        __clickListener = click;
    }
}
