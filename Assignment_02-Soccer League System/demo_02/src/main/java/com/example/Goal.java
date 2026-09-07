package com.example;

public class Goal {
    private String matchId;
    private Player scorer; 
    private int minute;

    public Goal(String matchId, Player scorer, int minute) {
        this.matchId = matchId;
        this.scorer = scorer;
        this.minute = minute;
    }

    public String getMatchId() { return matchId; }
    public void setMatchId(String matchId) { this.matchId = matchId; }

    public Player getScorer() { return scorer; }
    public void setScorer(Player scorer) { this.scorer = scorer; }

    public int getMinute() { return minute; }
    public void setMinute(int minute) { this.minute = minute; }
}