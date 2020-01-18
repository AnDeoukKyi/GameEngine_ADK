package com.an.gameengine_adk.Engine.Obj.Draw;

import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.__Engine;

import java.util.ArrayList;

public class SpriteGroup {

    public ArrayList<String> spriteName = new ArrayList<>();
    private  __Resource resource;

    private String path;
    private String name;
    private int startInex;
    private int endIndex;


    public SpriteGroup(String path, String name, int startIndex, int endIndex) {
        this.path = path;
        this.name = name;
        this.startInex = startIndex;
        this.endIndex = endIndex;
    }

    public void __setSpriteName(ArrayList<String> spriteName) {
        this.spriteName = spriteName;
    }

    public void __setResource(__Resource resource) {
        this.resource = resource;
    }
}
