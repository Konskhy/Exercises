package com.company.konski;

import java.util.ArrayList;

public class League<T extends Team> implements Comparable<T> {
    private String name;
    private ArrayList<T> leagueTable = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getLeagueTable() {
        return leagueTable;
    }
    public void addTeam( T team){
        leagueTable.add(team);
    }
    public void addResult(T homeTeam, T awayTeam, int homeScore, int awayScore){
        if (leagueTable.contains(homeTeam) && leagueTable.contains(awayTeam)) {
            homeTeam.result(homeScore,awayScore);
            awayTeam.result(homeScore,awayScore);
        }
    }

    @Override
    public int compareTo(T team) {
        return 0;
    }
}
