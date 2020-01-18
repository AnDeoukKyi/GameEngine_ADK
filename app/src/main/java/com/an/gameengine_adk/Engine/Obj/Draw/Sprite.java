package com.an.gameengine_adk.Engine.Obj.Draw;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.an.gameengine_adk.Engine.__Engine;

import java.io.InputStream;

public class Sprite {

    private String file;
    private double speed;
    private int index;
    public Bitmap sprite;
    private __Engine __engine;


    public Sprite(__Engine __engine, String file, double speed, int index) {
        this.__engine = __engine;
        this.file = file;
        this.speed = speed;
        this.index = index;
    }


    public void createSprite(){

        try {
            AssetManager assetManager = __engine.__getContext().getResources().getAssets();
            InputStream inputStream = assetManager.open(file);
            sprite = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {}
    }

    public Bitmap __getSprite() {
        return sprite;
    }
}
