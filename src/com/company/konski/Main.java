package com.company.konski;

public class Main {

    public static void main(String[] args) {

        League <FootballTeam> ekstraklasa = new League("Ekstraklasa");
        League <SpeedwayTeam> plz = new League("Polska Liga Zuzlowa");

        FootballTeam wks = new FootballTeam("Slask Wroclaw");
        FootballTeam legia = new FootballTeam("Legia Warszawa");
        FootballTeam lech = new FootballTeam("Lech Poznan");
        FootballTeam lechia = new FootballTeam("Lechia Gdansk");
        SpeedwayTeam wts = new SpeedwayTeam("Sparta Wroclaw");
        SpeedwayTeam unia = new SpeedwayTeam("Unia Leszno");

        ekstraklasa.addTeam(wks);
        ekstraklasa.addTeam(legia);
        ekstraklasa.addTeam(lech);
        ekstraklasa.addTeam(lechia);

        ekstraklasa.addResult(wks,legia,0,2);
        ekstraklasa.addResult(lech,lechia,1,3);
        ekstraklasa.addResult(lechia,wks,2,2);
        ekstraklasa.addResult(legia,lech,3,0);

        ekstraklasa.printTeams();
        ekstraklasa.printTable();

    }
}
