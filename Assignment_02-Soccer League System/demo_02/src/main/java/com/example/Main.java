package com.example;

public class Main {
    public static void main(String[] args) {
        Team reds = new Team("The Reds");
        Team blacks = new Team("The Blacks");

        Player p1 = new Player("Saad Ali", 10, PlayerRole.FORWARD);
        Player p2 = new Player("Amr Arafa", 8, PlayerRole.MIDFIELDER);
        Player p3 = new Player("Mahmoud Anas", 9, PlayerRole.FORWARD);
        Player p4 = new Player("Zain Yaser", 4, PlayerRole.DEFENDER);
        Player p5 = new Player("Khaled Anwer", 1, PlayerRole.GOALKEEPER);

        reds.addPlayer(p1);
        reds.addPlayer(p3);
        reds.addPlayer(p4);

        blacks.addPlayer(p2);
        blacks.addPlayer(p5);

        Schedule schedule = new Schedule();
        schedule.addTeam(reds);
        schedule.addTeam(blacks);

        Match match1 = new Match("MATCH_01", blacks, reds);

        match1.addGoal(p1, 7);
        match1.addGoal(p2, 21);
        match1.addGoal(p1, 41);
        match1.addGoal(p3, 46);
        match1.addGoal(p4, 76);
        match1.addGoal(p5, 83);

        schedule.addMatch(match1);

        schedule.displayTable();
        schedule.displayMatchDetails("MATCH_01");
    }
}