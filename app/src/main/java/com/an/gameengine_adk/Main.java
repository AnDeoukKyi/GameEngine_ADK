package com.an.gameengine_adk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engine.__get_resource().clear();
            }
        });
    }
}
