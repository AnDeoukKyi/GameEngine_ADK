package com.an.gameengine_adk.Engine.Obj;




import android.graphics.Canvas;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Draw.__DrawManager;
import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.__Engine;
import com.an.gameengine_adk.Engine.__ObjManager;



public class Obj {



    //
    public double x = 0;
    public double y = 0;
    protected int deep = 0;
    //

    //
    protected __Engine __engine = __Engine.__getEngine();
    //
    public int id = 0;
    protected __ObjManager __childManager;
    public Obj parent;
    protected boolean __root = false;
    //



    //------------------------------------
    protected __DrawManager __drawManager;
    protected __Resource resource;


    //-------------------------------------


    public Obj() {
        resource = __engine.__get_resource();
        __getObjNum();
        Start();
        __addObj();
    }
    //













    public Sprite spr;



    protected void f_DrawSprite(){
    //String name, int image, double speed, int index, Point point
        if (__drawManager == null)
            __drawManager = new __DrawManager();

//        __Draw draw = new __Draw(name);

//        Bitmap b = null;
//        try {
//            AssetManager assetManager = __engine.context.getResources().getAssets();
//            InputStream inputStream = assetManager.open("sprite/33.jpg");
//            b = BitmapFactory.decodeStream(inputStream);
//            spr = new Sprite(b);
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        __drawManager.__add(__draw);


        /*
        name, sprite, speed, index, rect(width, height)비율로 줄임
        name, sprite, speed, index, point(x, y) (width, height)고정임

        (x, y, width, height), sprite, name, speed, index(시작)
        =>rect클래스

         */

    }



    public void __draw(Canvas canvas){
        if (__childManager != null)
            __childManager.__draw(canvas);
        if(__drawManager != null)
            __drawManager.__draw(canvas);
    }







    //

    protected void __getObjNum(){
        id = __engine.__getObjNum();
    }

    protected void Start(){
        __root = true;
        Log.e("Object", "최상위Object가 생성되었습니다." + this.getClass().toString());
    }

    protected void __addObj(){
        if(__root)
            __engine.__addObj(this);
    }

    public Obj f_GetChild(int id){
        return __childManager.__get_ID(id);
    }

    public int f_SetChild(Obj obj){
        obj.parent = this;
        if (__childManager == null)
            __childManager = new __ObjManager();
        __childManager.__add(obj);
        return obj.id;
    }
}
