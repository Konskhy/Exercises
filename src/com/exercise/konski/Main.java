package com.exercise.konski;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<Integer,Locations> locations = new HashMap<>();
        locations.put(0,new Locations(0,"You are sitting in front of your computer"));
        locations.put(1,new Locations(1,"You are in the main hall"));
        locations.put(2,new Locations(2,"You are in the canteen"));
        locations.put(3,new Locations(3,"You are in the garage "));
        locations.put(4,new Locations(4,"You are in the wood room"));
        locations.put(5,new Locations(5,"You are in the office"));
        locations.get(1).addExit("N", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("W", 5);
        locations.get(2).addExit("S", 1);
        locations.get(2).addExit("W", 5);
        locations.get(3).addExit("W", 1);
        locations.get(3).addExit("S", 4);
        locations.get(3).addExit("N", 2);
        locations.get(4).addExit("E", 3);
        locations.get(4).addExit("N", 1);
        locations.get(5).addExit("E", 1);
        locations.get(5).addExit("N", 2);
//        locations.get(1).printExits();
        System.out.println(locations.get(1).getExits());
        Scanner sc = new Scanner(System.in);
        int loc=1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            System.out.println("Available exits are: ");
            locations.get(loc).printExits();
            String direction = sc.nextLine();
            if (locations.get(loc).getExits().containsKey(direction.toUpperCase())) {
                loc = locations.get(loc).getExits().get(direction.toUpperCase());
                if (loc==0) break;
            }else System.out.println("You can't go that way");
        }


    }
}
