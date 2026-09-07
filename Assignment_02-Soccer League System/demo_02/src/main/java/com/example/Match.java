package com.example;

import java.util.ArrayList;

public class Match {
    private String matchId;
    private Team homeTeam;
    private Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private ArrayList<Goal> goals;

    public Match(String matchId, Team homeTeam, Team awayTeam) {
        this.matchId = matchId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.goals = new ArrayList<>();
    }

    public void addGoal(Player scorer, int minute) {
        Goal goal = new Goal(matchId, scorer, minute);
        goals.add(goal);

        if (homeTeam.getPlayers().contains(scorer)) {
            homeGoals++;
        } else if (awayTeam.getPlayers().contains(scorer)) {
            awayGoals++;
        }
    }

    public void processResult() {
        homeTeam.addGoals(homeGoals);
        awayTeam.addGoals(awayGoals);

        if (homeGoals > awayGoals) {
            homeTeam.addPoints(3);
        } else if (awayGoals > homeGoals) {
            awayTeam.addPoints(3);
        } else {
            homeTeam.addPoints(1);
            awayTeam.addPoints(1);
        }
    }

    public String getMatchId() { return matchId; }
    public Team getHomeTeam() { return homeTeam; }
    public Team getAwayTeam() { return awayTeam; }
    public int getHomeGoals() { return homeGoals; }
    public int getAwayGoals() { return awayGoals; }
    public ArrayList<Goal> getGoals() { return goals; }
}