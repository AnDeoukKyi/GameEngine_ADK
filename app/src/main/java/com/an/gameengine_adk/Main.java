package com.an.gameengine_adk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.an.gameengine_adk.Engine.__Engine;
import com.an.gameengine_adk.User.Map.Screen1;

import java.io.IOException;
import java.io.InputStream;

public class Main extends AppCompatActivity {

    private __Engine engine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);


        engine = __Engine.__getEngine();
        engine.__Run(this);
        Screen1 s1 = new Screen1();
        engine = engine;



//        try {
//            ImageView iv = (ImageView)findViewById(R.id.iv);
//            AssetManager assetManager = getResources().getAssets();
//            InputStream inputStream = assetManager.open("__sprite/33.jpg");
//            iv.setImageDrawable(Drawable.createFromStream(inputStream, null));
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
