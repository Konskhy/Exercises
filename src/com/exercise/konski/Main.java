package com.exercise.konski;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<HeavenlyBody.Key,HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        Planet temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(),temp);
        temp.addSatellite(tempMoon);
        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars
        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars
        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        Star tempStar = new Star("Sun", 25000000);
        solarSystem.put(tempStar.getKey(),tempStar);

        temp=new Planet("Pluto",488);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        tempStar=new Star("Pluto",1488);
        solarSystem.put(tempStar.getKey(),tempStar);
        planets.add(tempStar);

        System.out.println("Planets: " );
        for (HeavenlyBody planet:planets){
            System.out.println("\t " + planet);
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Jupiter","Planet"));
        System.out.println("Moons of " + body.getKey().getName()+":");
        for (HeavenlyBody jupiterMoon:body.getSatellites()){
            System.out.println("\t"+jupiterMoon.getKey().getName());
        }

        System.out.println("Solar system: ");
        for (HeavenlyBody.Key k:solarSystem.keySet()){
            System.out.println("\t"+solarSystem.get(k));
        }
	}

}
