package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Schedule {
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    public Schedule() {
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public void addTeam(Team team) { teams.add(team); }
    
    public void addMatch(Match match) { 
        matches.add(match);
        match.processResult();
    }

    public void rankTeams() {
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                if (t1.getPoints() != t2.getPoints()) {
                    return Integer.compare(t2.getPoints(), t1.getPoints());
                }
                return Integer.compare(t2.getGoals(), t1.getGoals());
            }
        });
    }

    public void displayTable() {
        rankTeams();
        System.out.println("==================== SOCCER TABLE ====================");
        System.out.printf("%-18s | %-10s | %-10s\n", "Team Name", "Goals", "Points");
        System.out.println("-------------------------------------------------------------");
        for (Team t : teams) {
            System.out.printf("%-18s | %-10d | %-10d\n", t.getName(), t.getGoals(), t.getPoints());
        }
        System.out.println("=============================================================\n");
    }

    public void displayMatchDetails(String matchId) {
        Match targetMatch = null;
        for (Match m : matches) {
            if (m.getMatchId().equalsIgnoreCase(matchId)) {
                targetMatch = m;
                break;
            }
        }

        if (targetMatch == null) {
            System.out.println("Match with ID " + matchId + " not found!");
            return;
        }

        System.out.println("--- Match Details for ID: " + matchId + " ---");
        System.out.println(targetMatch.getHomeTeam().getName() + " (" + targetMatch.getHomeGoals() + ") vs " +
                           targetMatch.getAwayTeam().getName() + " (" + targetMatch.getAwayGoals() + ")");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-18s | %-12s | %-10s\n", "Player", "Role", "Minute");
        System.out.println("------------------------------------------------------------------");
        for (Goal g : targetMatch.getGoals()) {
            System.out.printf("%-18s | %-12s | %-10d\n", 
                              g.getScorer().getName(), 
                              g.getScorer().getRole().getRoleName(), 
                              g.getMinute());
        }
        System.out.println("------------------------------------------------------------------\n");
    }
}