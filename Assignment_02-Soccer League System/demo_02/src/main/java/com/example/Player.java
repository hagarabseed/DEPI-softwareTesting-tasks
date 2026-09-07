package com.example;

public class Player {
    private String name;
    private int playerNum;
    private PlayerRole role;

    public Player(String name, int playerNum, PlayerRole role) {
        this.name = name;
        this.playerNum = playerNum;
        this.role = role;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPlayerNum() { return playerNum; }
    public void setPlayerNum(int playerNum) { this.playerNum = playerNum; }

    public PlayerRole getRole() { return role; }
    public void setRole(PlayerRole role) { this.role = role; }
}