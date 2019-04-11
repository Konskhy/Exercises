package com.exercise.konski;

import java.util.HashMap;
import java.util.Map;

public final class Locations {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;



    public Locations(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits==null) this.exits = new HashMap<>();
        else this.exits = new HashMap<>(exits);
        this.exits.put("Q",0);

    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String,Integer> getExits(){
        return new HashMap<>(exits);
    }

    public void printExits(){
        Map <String,Integer> exitsCopy = new HashMap<>(exits);
        for (String s:exitsCopy.keySet()) System.out.print(s+",");
        System.out.println();

    }
//    public void addExit(String dir, int loc){
//        exits.put(dir,loc);
//    }

}