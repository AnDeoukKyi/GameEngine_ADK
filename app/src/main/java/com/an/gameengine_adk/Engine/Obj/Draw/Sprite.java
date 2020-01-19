package com.an.gameengine_adk.Engine.Obj.Draw;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

public class Sprite {


    private Bitmap __sprite;
    private int time = 0;
    private String __file;


    public Sprite(AssetManager assetManager, String file) {
        try {
            InputStream inputStream = assetManager.open(file);
            __sprite = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            __file = file;
        } catch (Exception e) {}
    }

    public Bitmap __get_sprite() {
        return __sprite;
    }
}
