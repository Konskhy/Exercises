package com.exercise.konski;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<Integer,Locations> locations = new HashMap<>();
        exitsVocabulary.put("NORTH","N");
        exitsVocabulary.put("SOUTH","S");
        exitsVocabulary.put("EAST","E");
        exitsVocabulary.put("WEST","W");
        exitsVocabulary.put("QUIT","Q");
        Map<String,Integer> tempExits;
        locations.put(0,new Locations(0,"You are sitting in front of your computer",null));
        tempExits = new HashMap<>();
        tempExits.put("N", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("W", 5);
        locations.put(1,new Locations(1,"You are in the main hall",tempExits));
        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 5);
        locations.put(2,new Locations(2,"You are in the canteen",tempExits));
        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        tempExits.put("S", 4);
        tempExits.put("N", 2);
        locations.put(3,new Locations(3,"You are in the garage ",tempExits));
        tempExits = new HashMap<>();
        tempExits.put("E", 3);
        tempExits.put("N", 1);
        locations.put(4,new Locations(4,"You are in the wood room",tempExits));
        tempExits = new HashMap<>();
        tempExits.put("E", 1);
        tempExits.put("N", 2);
        locations.put(5,new Locations(5,"You are in the office",tempExits));

//        locations.get(1).printExits();
        System.out.println(locations.get(1).getExits());
        Scanner sc = new Scanner(System.in);
        int loc=1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            if (loc==0) break;
            System.out.println("Available exits are: ");
            locations.get(loc).printExits();


            Map <String,Integer> exits = locations.get(loc).getExits();
            String direction = sc.nextLine().toUpperCase();

            if (direction.length()>1) {
                String [] dir = direction.split(" ");
                for (String s : dir) {
                    if (exitsVocabulary.containsKey(s)) {
                        direction = exitsVocabulary.get(s);
                        break;
                    }
                }
            }   if (exits.containsKey(direction)) {
                    loc = exits.get(direction);

                } else System.out.println("You can't go that way");
//
        }
    }
    private static final Map<String,String>exitsVocabulary = new HashMap<>();

}
