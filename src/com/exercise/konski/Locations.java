package com.exercise.konski;

import java.util.HashMap;
import java.util.Map;

public class Locations {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Locations(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String,Integer>();

    }
    public Map<String,Integer> getExits(){
        return new HashMap<>(exits);
    }
    public void printExits(){
        Map <String,Integer> exitsCopy = new HashMap<>(exits);
        for (String s:exitsCopy.keySet()) System.out.println(s+",");

    }
    public void addExit(String dir, int loc){
        exits.put(dir,loc);
    }

}