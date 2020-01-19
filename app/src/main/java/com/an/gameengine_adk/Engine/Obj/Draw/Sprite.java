package com.an.gameengine_adk.Engine.Obj.Draw;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.__Engine;

import java.io.InputStream;

public class Sprite {


    private Bitmap __sprite;
    private int time = 0;
    private String __path;
    private String __tag;






    /*
    tag없이 path만으로 Sprite생성(Obj에서)
    hash에는 path:Sprite로 등록
     */
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

    //path에 맞춰서 sprite(Bitmap)대입
    public void __createSprite(){
        __Engine engine =  __Engine.__getEngine();
        try {
            InputStream inputStream = engine.__getContext().getAssets().open(__path);
            __sprite =  BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {}
    }



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
