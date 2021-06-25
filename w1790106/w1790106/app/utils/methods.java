package app.utils;

import java.io.*;
import java.util.*;

import app.entities.FootballClub;

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

    // Prints an empty space if there is room left
    // Like a = 8 and b = 2, it will print 6 spaces
    public void gap(int a, int b) {
        for (int i = b; i <= a; i++) {
            System.out.print(" ");
        }
    }
}
