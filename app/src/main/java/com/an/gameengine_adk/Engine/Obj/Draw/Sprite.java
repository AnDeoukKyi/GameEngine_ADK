package com.an.gameengine_adk.Engine.Obj.Draw;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.an.gameengine_adk.Engine.__Engine;

import java.io.InputStream;

public class Sprite {

    private String __file;
    private double __speed;
    private int __index;
    private Bitmap __sprite;
    private __Engine __engine;


    public Sprite(__Engine engine, String file, double speed, int index) {
        this.__engine = engine;
        this.__file = file;
        this.__speed = speed;
        this.__index = index;
    }


    public void __createSprite(){
        try {
            AssetManager assetManager = __engine.__getContext().getResources().getAssets();
            InputStream inputStream = assetManager.open(__file);
            __sprite = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {}
    }

    public Bitmap __getSprite() {
        return __sprite;
    }
}
