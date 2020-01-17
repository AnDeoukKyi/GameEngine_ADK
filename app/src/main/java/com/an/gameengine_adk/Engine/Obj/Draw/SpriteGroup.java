package com.an.gameengine_adk.Engine.Obj.Draw;

import com.an.gameengine_adk.Engine.Resource.__Resource;
import com.an.gameengine_adk.Engine.__Engine;

import java.util.ArrayList;

public class SpriteGroup {

    public ArrayList<Sprite> group11 = new ArrayList<>();
    public ArrayList<String> group = new ArrayList<>();
    public __Resource resource;


    private String path;
    private String name;
    private int startInex;
    private int endIndex;

    public SpriteGroup(String path, String name, int startIndex, int endIndex) {
        /*
        경로, 이름, 시작인덱스, 종료인덱스



         */

        resource = __Engine.__getEngine().__get_resource();
        this.path = path;
        this.name = name;
        this.startInex = startIndex;
        this.endIndex = endIndex;

    }



}
