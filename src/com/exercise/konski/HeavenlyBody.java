package com.exercise.konski;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;


    public HeavenlyBody(String name, double orbitalPeriod, String bodyType){
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite){
        return satellites.add(satellite);
    }

    public HashSet<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    public static  Key makeKey(String name, String bodyType){
        return new Key(name,bodyType);

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeavenlyBody)) return false;
        HeavenlyBody body = (HeavenlyBody) o;

        return this.key.equals(body.getKey());

    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return  this.key.getName()+(" (")+key.getBodyType()+"): " + getOrbitalPeriod();
    }

    public static final class Key{
        private final String name;
        private final String bodyType;

        public Key(String name, String bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public String getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(getName(), key.getName()) &&
                    Objects.equals(getBodyType(), key.getBodyType());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getBodyType());
        }
    }
}
