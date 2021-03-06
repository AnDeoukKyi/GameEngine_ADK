package com.an.gameengine_adk.Engine.Obj.Draw;

import com.an.gameengine_adk.Engine.__Engine;

import java.util.ArrayList;

public class SpriteGroup {

    private String __tag;
    private String __fileName;
    private int __startInex;
    private int __endIndex;
    private ArrayList<Sprite> __listSprite;
    private int time = 0;



    public SpriteGroup(String tag, String path, String fileName, int startIndex, int endIndex) {
        __tag = tag;
        __fileName = fileName;
        __startInex = startIndex;
        __endIndex = endIndex;
        __Engine engine =  __Engine.__getEngine();
        __listSprite = engine.__get_resource().__checkFileGroup(path, fileName, startIndex, endIndex);
        if(__listSprite == null)
            return;
        engine.__get_resource().__registerSpriteGroup(__tag, this);
    }

    public SpriteGroup(String path, String fileName, int startIndex, int endIndex) {
        __tag = path + "/" + fileName + "/" +startIndex + "/" + endIndex;
        __fileName = fileName;
        __startInex = startIndex;
        __endIndex = endIndex;
        __Engine engine =  __Engine.__getEngine();
        __listSprite = engine.__get_resource().__checkFileGroup(path, fileName, startIndex, endIndex);
        if(__listSprite == null)
            return;
        engine.__get_resource().__registerSpriteGroup(__tag, this);
    }


    public void clear(){
        for(Sprite spr: __listSprite){
            spr.clear();
        }
    }

    public void __load(){
        for(Sprite spr: __listSprite){
            spr.__createSprite();
        }
    }


    public String __get_tag() {
        return __tag;
    }

    public Sprite __getSprite(int index){
        return __listSprite.get(index);
    }

    public int __size(){
        return __listSprite.size();
    }
}
