package app.utils;

import java.io.*;
import java.util.*;

import app.entities.FootballClub;

public class methods {

    public String checkSameClub(String name) {
        FootballClub fbc;
        String ans = "";
        try {
            FileInputStream fis = new FileInputStream("app/database/league.txt");
            Scanner scan = new Scanner("app/database/league.txt");

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
        } catch (Exception e) {
            e.getStackTrace();
        }
        return ans;
    }
}
