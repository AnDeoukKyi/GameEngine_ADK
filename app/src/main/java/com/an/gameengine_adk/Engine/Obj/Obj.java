package com.an.gameengine_adk.Engine.Obj;




import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;
import com.an.gameengine_adk.Engine.Obj.Draw.__Draw;
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

//    Bitmap b = null;
//        try {
//            AssetManager assetManager = __engine.context.getResources().getAssets();
//            InputStream inputStream = assetManager.open("__sprite/33.jpg");
//            b = BitmapFactory.decodeStream(inputStream);
//            spr = new Sprite(b);
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }





    protected __Draw f_DrawSprite(String tag, String path, double speed, int index, Rect rect){
        String file = resource.__createSprite(path);//return String
        if (file == null)
            return null;
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        __Draw draw = new __Draw(tag);
        draw.__setSprite(__engine, file, speed, index);
        draw.__setRect(rect);

        __drawManager.__add(draw);
        return draw;
    }


    protected __Draw f_DrawSprite(String tag, String path, double speed, int index, Point point){
        String file = resource.__createSprite(path);//return String
        if (file == null)
            return null;
        if (__drawManager == null)
            __drawManager = new __DrawManager();

        __Draw draw = new __Draw(tag);
        draw.__setSprite(__engine, file, speed, index);
        draw.__setPoint(point);

        __drawManager.__add(draw);
        return draw;
    }



    public SpriteGroup f_SpriteGroup(String tag, String path, String fileName, int startIndex, int endIndex){
        return resource.__createSpriteGroup(tag, path, fileName, startIndex, endIndex);
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
