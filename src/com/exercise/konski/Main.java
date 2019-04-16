package com.exercise.konski;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String,HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Set<Moon> moons = new HashSet<>();
    private static Set<Star> stars = new HashSet<>();
    public static void main(String[] args) {
        Planet temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);
        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);
        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);
        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getName(),temp);
        moons.add(tempMoon);
        temp.addSatellite(tempMoon);
        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars
        moons.add(tempMoon);
        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars
        moons.add(tempMoon);
        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        moons.add(tempMoon);
        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        moons.add(tempMoon);
        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        moons.add(tempMoon);
        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
        moons.add(tempMoon);
        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        Star tempStar = new Star("Sun", 25000000);
        solarSystem.put(tempStar.getName(),tempStar);
        stars.add(tempStar);

        System.out.println("Planets: " );
        for (HeavenlyBody planet:planets){
            System.out.println("\t " + planet.getName());
        }

        System.out.println("Moons: ");
        for (Moon m:moons){
            System.out.println("\t " + m.getName());
        }

        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName()+":");
        for (HeavenlyBody jupiterMoon:body.getSatellites()){
            System.out.println(jupiterMoon.getName());
        }

        System.out.println("Solar system: ");
        for (String h:solarSystem.keySet()){
            System.out.println(solarSystem.get(h).getName()+": " +solarSystem.get(h).getOrbitalPeriod());
        }
	}

}
