package com.an.gameengine_adk.Engine.Map.Camera;

import android.graphics.Point;

import com.an.gameengine_adk.Engine.Obj.Obj.Obj;
import com.an.gameengine_adk.Engine.__Engine;

public class Camera {

    public __Engine __engine;
    private boolean __deviceSizeCheck = false;//device크기로 세팅했는지 안했는지 체크
    public int width;//너비
    public int height;//높이
    public int width2;//너비절반
    public int height2;//높이절반

    public Point pos = new Point(0, 0);//현재위치
    public Obj target;//따라갈 오브젝트


    public Camera() {
        if (__engine == null)
            __engine = __Engine.__getEngine();
        __settingSize(__engine.__getDeviceSize());
        __attachCamera();//엔진에 부착
    }

    public void __settingSize(Point p) {
        if(!__deviceSizeCheck){
            width = p.x;
            height = p.y;
            width2 = width / 2;
            height2 = height / 2;
            __deviceSizeCheck = true;
        }
    }


    public void Attach(Obj obj){
        target = obj;
        pos = obj.posR;
    }


    public void __attachCamera(){
        __engine.__attachCamera(this);
    }
}
