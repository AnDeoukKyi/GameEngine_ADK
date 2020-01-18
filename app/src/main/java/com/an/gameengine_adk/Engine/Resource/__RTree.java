package com.an.gameengine_adk.Engine.Resource;

import java.util.ArrayList;

public class __RTree {
    private String __name;
    private ArrayList<__RTree> __child;
    private __RTree __parent;
    private ArrayList<String> __file;

    public __RTree() {
    }

    public __RTree(String __name) {
        this.__name = __name;
    }





    public ArrayList<String> __searchFile(String fileName, int startIndex, int endIndex){
        ArrayList<String> f = null;
        for(int i = 0; i<__file.size(); i++){
            String[] str = __file.get(i).split("\\.");
            if(startIndex == -1){
                if(str[0].equals(fileName)){
                    f = new ArrayList<>();
                    f.add(__file.get(i));
                    return f;
                }
            }
            else if((str[0].substring(0, fileName.length())).equals(fileName)){
                //앞부분은 일치함
                //뒷부분이 문자일수도있고 숫자일수도있음
                try{
                    int index = Integer.parseInt(str[0].substring(fileName.length()));
                    if( index >= startIndex && index <= endIndex){
                        if (f == null)
                            f = new ArrayList<>();
                        f.add(__file.get(i));
                    }
                }
                catch(Exception e){}
            }
        }
        return f;
    }


    public __RTree __searchDir(String name){
        for(int i = 0; i<__child.size(); i++){
            if(__child.get(i).__name.equals(name)){
                return __child.get(i);
            }
        }
        return null;
    }



    public void __addChild(__RTree childTree){
        if(__child == null)
            __child = new ArrayList<>();
        __child.add(childTree);
    }

    public void __addFile(String fileName){
        if(__file == null)
            __file = new ArrayList<>();
        __file.add(fileName);
    }

    public void __setParent(__RTree parent) {
        this.__parent = parent;
    }
}
