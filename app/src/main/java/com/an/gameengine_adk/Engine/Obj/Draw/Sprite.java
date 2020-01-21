package com.an.gameengine_adk.Engine.Obj.Draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.an.gameengine_adk.Engine.__Engine;

import java.io.InputStream;

public class Sprite {

    private Bitmap __sprite;
    private String __path;
    private String __tag;
    private int time = 0;





    public Sprite(String path) {
        __path = path;
        __Engine engine =  __Engine.__getEngine();
        __path = engine.__get_resource().__checkFile(path);
        if(__path == null)
            return;
        __createSprite();
        engine.__get_resource().__registerSprite(__path, this);
    }

    public Sprite(String tag, String path) {
        __tag = tag;
        __Engine engine =  __Engine.__getEngine();
        __path = engine.__get_resource().__checkFile(path);
        if(__path == null)
            return;
        __createSprite();
        engine.__get_resource().__registerSprite(tag, this);
    }

    public Sprite(String path, int nothing) {
        __path = path;
        __Engine engine =  __Engine.__getEngine();
        __path = engine.__get_resource().__checkFile(path);
        if(__path == null)
            return;
        __createSprite();
    }





    //-----------------------------------------M E M O R Y-------------------------------------------
    public void clear(){
        __sprite = null;
    }
    //-----------------------------------------M E M O R Y-------------------------------------------


    //----------------------------------D E C O D E    S P R I T E-------------------------------------------
    public void __createSprite(){
        __Engine engine =  __Engine.__getEngine();
        try {
            InputStream inputStream = engine.__getContext().getAssets().open(__path);
            __sprite =  BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {}
    }
    //----------------------------------D E C O D E    S P R I T E-------------------------------------------


    public String __get_path() {
        return __path;
    }

    public String __get_tag() {
        return __tag;
    }

    public Bitmap __get_sprite() {
        return __sprite;
    }
}
