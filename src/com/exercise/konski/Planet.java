package com.exercise.konski;

import java.util.HashSet;
import java.util.Set;

public class Planet extends HeavenlyBody{

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "Planet");
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getBodyType().equals("Moon"))
        return super.addSatellite(satellite);
        else return false;
    }
}
