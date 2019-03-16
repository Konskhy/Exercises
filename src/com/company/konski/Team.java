package com.company.konski;

public abstract class Team implements Comparable{
    String name;
    int wins;
    int loses;
    int draws;
    int gamesPlayed;

    public Team(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getWins() {
        return wins;
    }
    public int getLoses() {
        return loses;
    }
    public int getDraws() {
        return draws;
    }
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void result(int i, int j){
        if (i>j) win();
        else if  (i<j) lose();
        else draw();

    }
    private void win () {
            wins++;
            gamesPlayed++;

    }
    private void lose(){
        loses++;
        gamesPlayed++;
    }
    private void draw(){
        draws++;
        gamesPlayed++;
    }


    public int compareTo(Team team) {
        if (Integer.valueOf(this.getName())>Integer.valueOf(team.getName())) return 1;
        else if (Integer.valueOf(this.getName())<Integer.valueOf(team.getName())) return -1;
        else return 0;
    }
}
