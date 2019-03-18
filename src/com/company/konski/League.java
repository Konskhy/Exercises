package com.company.konski;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class League<T extends Team> {
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
    public void addTeam(T team){
        leagueTable.add(team);
    }
    public void addResult(T homeTeam, T awayTeam, int homeScore, int awayScore){
        if (leagueTable.contains(homeTeam) && leagueTable.contains(awayTeam)) {
            homeTeam.result(homeScore,awayScore);
            awayTeam.result(awayScore,homeScore);
        }else System.out.println("Team is not a part of " + getName());
    }
    public void printTable(){
        Comparator<T> comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1.wins>o2.wins) return -1;
                else if (o1.wins<o2.wins) return 1;
                else return 0;
            }
        };
        leagueTable.sort(comp);
        for (T team : leagueTable){
            System.out.println(team.getName()+ " Played: "+team.getGamesPlayed()+" Wins: " + team.getWins() + ", Draws: " + team.getDraws() + ", Loses: "+ team.getLoses());
        }
    }
    public void printTeams(){
        Collections.sort(leagueTable);
        for (T team : leagueTable) System.out.println(team.getName());
    }

}
