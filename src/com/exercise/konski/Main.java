package com.exercise.konski;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer,Locations> locations = new HashMap<>();
        locations.put(0,new Locations(0,"You are sitting in front of your computer"));
        locations.put(1,new Locations(1,"You are in the main hall"));
        locations.put(2,new Locations(1,"You are in the main hall"));
        locations.put(3,new Locations(1,"You are in the main hall"));
        locations.put(4,new Locations(1,"You are in the main hall"));
        locations.put(5,new Locations(1,"You are in the main hall"));
        locations.get(1).addExit("N", 2);
        locations.get(1).printExits();
        System.out.println(locations.get(1).getExits());

    }
}
