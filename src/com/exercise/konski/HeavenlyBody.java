package com.exercise.konski;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
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

    public boolean addSatellite(HeavenlyBody satellite){
        return satellites.add(satellite);
    }

    public String getBodyType() {
        return bodyType;
    }

    public HashSet<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof HeavenlyBody)) return false;
        HeavenlyBody body = (HeavenlyBody) o;
        if (body.bodyType.equals(((HeavenlyBody) o).bodyType)){
        return Objects.equals(getName(), body.getName());}
        else return false;
    }

    @Override
    public final int hashCode() {
        return this.getName().hashCode()+this.bodyType.hashCode()+57;
    }

    @Override
    public String toString() {
        return  getName()+(" (")+getBodyType()+"): " + getOrbitalPeriod();
    }
}
