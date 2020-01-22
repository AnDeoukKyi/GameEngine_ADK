package com.an.gameengine_adk.Engine.Map.Map;


import com.an.gameengine_adk.Engine.Map.Camera.Camera;
import com.an.gameengine_adk.Engine.Obj.Obj.Obj;
import com.an.gameengine_adk.Engine.__Engine;

public class Map {

    protected Camera camera = new Camera();

    private __Engine __engine = __Engine.__getEngine();

    public Map() {

    }



    public Obj CreateObj(Obj obj){
        obj.__get_engine().__objCreateFinish(obj);
        return obj;
    }





}
