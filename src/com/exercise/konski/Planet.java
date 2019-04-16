package com.exercise.konski;

import java.util.HashSet;
import java.util.Set;

public class Planet extends HeavenlyBody{
    private final Set<Moon> satellites;
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "Planet");
       this.satellites = new HashSet<>();
    }


    public boolean addSatellite(Moon satellite) {
        return satellites.add(satellite);
    }
    public HashSet<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }
}
