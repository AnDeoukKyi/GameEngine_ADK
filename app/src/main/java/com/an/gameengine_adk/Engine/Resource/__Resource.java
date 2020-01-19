package com.an.gameengine_adk.Engine.Resource;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Draw.Sprite;
import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;

import java.util.ArrayList;
import java.util.HashMap;

public class __Resource {

    private Context context;
    private AssetManager assetmanager;
    private __RTree __rTree = new __RTree();
    private HashMap<String, SpriteGroup> __spriteGroupHash = new HashMap<>();
    private HashMap<String, Sprite> __spriteHash = new HashMap<>();



    public __Resource(Context context) {
        this.context = context;
        assetmanager = context.getAssets();
        setResource();
    }








    //----------------------------------SPRITE---------------------------------------------------
    public Sprite __registerSprite(String tag, Sprite sprite){
        if(!tag.equals(""))
            __spriteHash.put(tag, sprite);
        return sprite;
    }

    public SpriteGroup __registerSpriteGroup(String tag, SpriteGroup sg){
        if(!tag.equals(""))
            __spriteGroupHash.put(tag, sg);
        return sg;
    }

    public void __loadSprite(String tag){
        if(__spriteHash.containsKey(tag))
            __spriteHash.get(tag).__createSprite();
    }

    public void __loadSpriteGroup(String tag){
        if(__spriteGroupHash.containsKey(tag))
            __spriteGroupHash.get(tag).__load();
    }

    public Sprite __getSprite(String tag){
        if(__spriteHash.containsKey(tag))
            return __spriteHash.get(tag);
        return null;
    }

    public SpriteGroup __getSpriteGroup(String tag){
        if(__spriteGroupHash.containsKey(tag))
            return __spriteGroupHash.get(tag);
        return null;
    }

    public void clear(){
        for (String str: __spriteGroupHash.keySet()){
            __spriteGroupHash.get(str).clear();
        }
    }
    //----------------------------------SPRITE---------------------------------------------------




    //--------------------------------SEARCH   DIR-----------------------------------------------
    public String __checkFile(String path){
        String[] str = path.split("/");
        ArrayList<String> file = __searchRTree(path.substring(0, path.length() - str[str.length - 1].length() - 1), str[str.length - 1], -1 ,-1);
        if(file == null)
            return null;
        else
            return file.get(0);
    }

    public ArrayList<Sprite> __checkFileGroup(String path, String fileName, int startIndex, int endIndex){
        ArrayList<String> file = __searchRTree(path, fileName, startIndex, endIndex);
        if(file == null)
            return null;
        ArrayList<Sprite> listSprite = new ArrayList<>();
        for(String str : file){
            Sprite sprite = new Sprite(path + "/" + str.split("\\.")[0], 0);
            listSprite.add(sprite);
        }
        return listSprite;
    }

    private ArrayList<String> __searchRTree(String path, String fileName, int startIndex, int endIndex){
        //성공시 true반환
        String[] dir = path.split("/");
        __RTree tree = __rTree;
        for(int i = 0; i<dir.length; i++){
            tree = tree.__searchDir(dir[i]);
            if(tree == null){
                Log.e("Resource", path + "디렉토리가 존재하지 않습니다.");
                return null;
            }
        }
        ArrayList<String> file = tree.__searchFile(fileName, startIndex, endIndex);
        if(startIndex == -1)
            file.set(0, path + "/" +file.get(0));
        if(file == null){
            if(startIndex == -1)
                Log.e("Resource", path +"에 " + fileName + "파일이 존재하지 않습니다.");
            else
                Log.e("Resource", path +"에 " + fileName + "+(" + startIndex +"~" + endIndex + ") 사이의 파일이 존재하지 않습니다.");
            return null;
        }
        return file;
    }

    private void setResource(){
        try{
            String[] dir = assetmanager.list("");
            for(String subDir : dir) {
                if(subDir.equals("images") || subDir.equals("sounds") || subDir.equals("webkit"))//필요없는애들 검사안함
                    continue;
                __RTree child = new __RTree(subDir);
                child.__setParent(__rTree);
                __rTree.__addChild(child);
                searchDir(subDir, "", child);
            }
        }
        catch (Exception e){}
    }

    private void searchDir(String target, String path, __RTree rTree){
        try{
            String searchPath = "";
            if(!path.equals(""))
                searchPath = path + "/" + target;
            else
                searchPath = target;
            String[] dir = assetmanager.list(searchPath);
            for(String subDir : dir) {
                if(subDir.contains("."))//확장자있는 파일있음
                    rTree.__addFile(subDir);
                else {//sub디렉토리 검사
                    __RTree child = new __RTree(subDir);
                    child.__setParent(rTree);
                    rTree.__addChild(child);
                    searchDir(subDir, searchPath, child);
                }
            }
        }
        catch (Exception e){}
    }
    //--------------------------------SEARCH   DIR-----------------------------------------------
}
