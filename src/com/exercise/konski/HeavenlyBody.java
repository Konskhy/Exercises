package com.exercise.konski;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final String bodyType;

    public HeavenlyBody(String name, double orbitalPeriod, String bodyType){
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = bodyType;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

//    public boolean addMoon(HeavenlyBody moon){
//        return satellites.add(moon);
//    }
//    public boolean addSatellite(HeavenlyBody satellite){
//        return satellites.add(satellite);
//    }
    public HashSet<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HeavenlyBody body = (HeavenlyBody) o;
        return Objects.equals(getName(), body.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode()+57;
    }
}
