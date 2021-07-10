package app.utils;

import java.io.*;
import java.util.*;

import app.entities.FootballClub;
import app.entities.Match;

public class methods {

    // Checks if the club name passed is present in the league.txt file
    public String checkSameClub(String name) {
        FootballClub fbc;
        String ans = "";
        try {
            FileInputStream fis = new FileInputStream("app/database/league.txt");
            Scanner scan = new Scanner("app/database/league.txt");

            // Iterating through each object in the league.txt file
            while (scan.hasNext()) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                fbc = (FootballClub) ois.readObject();
                if (name.equals(fbc.getClubName())) {
                    ans = "true";
                    break;
                } else {
                    ans = "false";
                }

            }
            scan.close();
            fis.close();
        } catch (Exception e) {
            ans = "false";
            e.getStackTrace();
        }
        return ans;
    }

    // Returns an arraylist of club in the league.txt
    public ArrayList<FootballClub> getClubList() {
        FootballClub fbc;
        ArrayList<FootballClub> clubList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("app/database/league.txt");
            Scanner scan = new Scanner("app/database/league.txt");

            // Iterating through each object in the league.txt file
            // And saves it in the returning arraylist
            while (scan.hasNext()) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                fbc = (FootballClub) ois.readObject();
                clubList.add(fbc);
            }
            scan.close();
            fis.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return clubList;
    }

    // When name of the club is passed an arraylist without said name is returned
    public ArrayList<FootballClub> removeClub(String name) {
        FootballClub fbc;
        ArrayList<FootballClub> clubList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("app/database/league.txt");
            Scanner scan = new Scanner("app/database/league.txt");

            // Iterating through each object in the league.txt file
            while (scan.hasNext()) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                fbc = (FootballClub) ois.readObject();
                if (name.equals(fbc.getClubName())) {
                    System.out.println("Successfully deleted !!!");
                } else {
                    clubList.add(fbc);
                }
            }
            scan.close();
            fis.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return clubList;
    }

    public ArrayList<Match> getMatchList() {
        Match fbc;
        ArrayList<Match> clubList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("app/database/match.txt");
            Scanner scan = new Scanner("app/database/match.txt");

            // Iterating through each object in the league.txt file
            // And saves it in the returning arraylist
            while (scan.hasNext()) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                fbc = (Match) ois.readObject();
                clubList.add(fbc);
            }
            scan.close();
            fis.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return clubList;
    }

    public void updateClubAfterMatch(int teamOneScore, int teamTwoScore, String teamOneName, String teamTwoName) {

        ArrayList<FootballClub> list = getClubList();

        ArrayList<FootballClub> tempList = new ArrayList<FootballClub>();

        int count = 0;

        if (teamOneScore > teamTwoScore) {
            for (FootballClub i : list) {
                if (teamOneName.equals(i.getClubName())) {
                    i.setPlayed(i.getPlayed() + 1);
                    i.setWon(i.getWon() + 1);
                    i.setGoalsScored(i.getGoalsScored() + teamOneScore);
                    i.setGoalsReceived(i.getGoalsRceived() + teamTwoScore);
                    i.setPoints(i.getPoints() + 5);
                    tempList.add(i);
                } else if (teamTwoName.equals(i.getClubName())) {
                    i.setPlayed(i.getPlayed() + 1);
                    i.setLost(i.getLost() + 1);
                    i.setGoalsScored(i.getGoalsScored() + teamTwoScore);
                    i.setGoalsReceived(i.getGoalsRceived() + teamOneScore);
                    i.setPoints(i.getPoints() - 5);
                    tempList.add(i);
                } else {
                    tempList.add(i);
                }
            }
        } else if (teamOneScore == teamTwoScore) {
            for (FootballClub i : list) {
                if (teamOneName.equals(i.getClubName())) {
                    i.setPlayed(i.getPlayed() + 1);
                    i.setDrawn(i.getDrawn() + 1);
                    i.setGoalsScored(i.getGoalsScored() + teamOneScore);
                    i.setGoalsReceived(i.getGoalsRceived() + teamTwoScore);
                    tempList.add(i);
                } else if (teamTwoName.equals(i.getClubName())) {
                    i.setPlayed(i.getPlayed() + 1);
                    i.setDrawn(i.getDrawn() + 1);
                    i.setGoalsScored(i.getGoalsScored() + teamTwoScore);
                    i.setGoalsReceived(i.getGoalsRceived() + teamOneScore);
                    tempList.add(i);
                } else {
                    tempList.add(i);
                }
            }
        } else if (teamOneScore < teamTwoScore) {
            for (FootballClub i : list) {
                if (teamOneName.equals(i.getClubName())) {
                    i.setPlayed(i.getPlayed() + 1);
                    i.setLost(i.getLost() + 1);
                    i.setGoalsScored(i.getGoalsScored() + teamOneScore);
                    i.setGoalsReceived(i.getGoalsRceived() + teamTwoScore);
                    i.setPoints(i.getPoints() - 5);
                    tempList.add(i);
                } else if (teamTwoName.equals(i.getClubName())) {
                    i.setPlayed(i.getPlayed() + 1);
                    i.setWon(i.getWon() + 1);
                    i.setGoalsScored(i.getGoalsScored() + teamTwoScore);
                    i.setGoalsReceived(i.getGoalsRceived() + teamOneScore);
                    i.setPoints(i.getPoints() + 5);
                    tempList.add(i);
                } else {
                    tempList.add(i);
                }
            }

        }

        try {

            for (FootballClub f1 : tempList) {
                count++;
                if (count == 1) {
                    FileOutputStream fos = new FileOutputStream(new File("app/database/league.txt"));
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(f1);
                    oos.close();
                } else if (count > 1) {
                    FileOutputStream fos = new FileOutputStream(new File("app/database/league.txt"), true);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(f1);
                    oos.close();
                }
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    // Prints an empty space if there is room left
    // Like a = 8 and b = 2, it will print 6 spaces
    public void gap(int a, int b) {
        for (int i = b; i <= a; i++) {
            System.out.print(" ");
        }
    }
}
