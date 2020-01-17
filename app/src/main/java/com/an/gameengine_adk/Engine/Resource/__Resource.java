package com.an.gameengine_adk.Engine.Resource;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.an.gameengine_adk.Engine.Obj.Draw.SpriteGroup;

import java.util.ArrayList;
import java.util.HashMap;

public class __Resource {

    private Context context;
    private AssetManager assetmanager;
    private __RTree __rTree = new __RTree();



    private HashMap<String, SpriteGroup> hash = new HashMap<>();



    public __Resource(Context context) {
        this.context = context;
        assetmanager = context.getAssets();
        setResource();
    }




    public void f_SpriteGroup(String tag, String path, String fileName, int startIndex, int endIndex){
        SpriteGroup sg = new SpriteGroup(path, fileName, startIndex, endIndex);
        sg.resource = this;
        if (tag.equals(""))
            tag = path + "/" + fileName+ "/"  + startIndex+ "/"  + endIndex;
        ArrayList<String> file = searchRTree(path, fileName, startIndex, endIndex);
        if (file == null){
            Log.e("Resource", "파일을 찾지못해 " + tag + "SpriteGroup을 생성하지 못했습니다.");
            return;
        }



        if(hash.containsKey(tag))
            Log.e("Resource", tag + "이름의 " + "SpriteGroup이 있습니다.");

        hash.put(tag, sg);
    }


    private ArrayList<String> searchRTree(String path, String fileName, int startIndex, int endIndex){
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
        if(file == null){
            Log.e("Resource", path +"에 " + fileName + startIndex +"와 " +fileName + endIndex + "사이의 파일이 존재하지 않습니다.");
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
}
