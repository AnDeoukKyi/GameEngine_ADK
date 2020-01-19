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


//    public Sprite(String tag){
//        if (!tag.equals(""))
//            return;
//        //찾아서주면됨tag맞춰서
//    }

    public Sprite(String path) {
        __Engine engine =  __Engine.__getEngine();
        __path = engine.__get_resource().__checkFile(path);
        if(__path == null)
            return;
        try {
            InputStream inputStream = engine.__getContext().getAssets().open(__path);
            __sprite =  BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {}
    }


    public Sprite(String tag, String path) {
        this.__tag = tag;
        __Engine engine =  __Engine.__getEngine();
        __path = engine.__get_resource().__checkFile(path);
        if(__path == null)
            return;
        try {
            InputStream inputStream = engine.__getContext().getAssets().open(__path);
            __sprite =  BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {}
        engine.__get_resource().__registerSprite(tag, this);
    }

//    public Sprite(AssetManager assetManager, String file) {
//        try {
//            InputStream inputStream = assetManager.open(file);
//            __sprite = BitmapFactory.decodeStream(inputStream);
//            inputStream.close();
//            __file = file;
//        } catch (Exception e) {}
//    }


    public String __get_path() {
        return __path;
    }

    public Bitmap __get_sprite() {
        return __sprite;
    }

    public void __set_tag(String __tag) {
        this.__tag = __tag;
    }
}
