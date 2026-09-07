package com.example;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;
    private int goals;
    private int points;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.goals = 0;
        this.points = 0;
    }

    public void addPlayer(Player player) { players.add(player); }
    public void addGoals(int g) { this.goals += g; }
    public void addPoints(int p) { this.points += p; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<Player> getPlayers() { return players; }
    public int getGoals() { return goals; }
    public int getPoints() { return points; }
}
