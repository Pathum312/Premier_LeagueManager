package app.services;

import java.io.*;
import java.util.*;
import app.entities.FootballClub;
import app.utils.methods;

public class PremierLeagueManager implements LeagueManager {

    public void addClub() {
        Scanner input = new Scanner(System.in);
        methods m = new methods();

        // Getting the club name
        System.out.print("Enter the name of the club: ");
        String clubName = input.nextLine();
        System.out.println();

        // Sends the club name to get checked if it's already used
        String ans = m.checkSameClub(clubName);

        // It sends back a verification of true of false
        if (ans.equals("true")) {

            // If the same name is entered then the user is prompted to enter an new name
            System.out.println("Same Club Name!!!!");
            addClub();

        } else if (ans.equals("false")) {

            // Getting the club location
            System.out.print("Enter the location of the club: ");
            String location = input.nextLine();
            System.out.println();

            // Getting the no. of matches played by the club
            System.out.print("Enter the number of matches played: ");
            int played = input.nextInt();
            System.out.println();

            // Getting the no. of matches won by the club
            System.out.print("Enter the number of matches won: ");
            int won = input.nextInt();
            System.out.println();

            // Getting the no. of matches lost by the club
            System.out.print("Enter the number of matches lost: ");
            int lost = input.nextInt();
            System.out.println();

            // Getting the no. of matches drawn by the club
            System.out.print("Enter the number of matches drawn: ");
            int drawn = input.nextInt();
            System.out.println();

            // Getting the no. of goals scored by the club
            System.out.print("Enter the number of goals scored: ");
            int scored = input.nextInt();
            System.out.println();

            // Getting the no. of goals received by the club
            System.out.print("Enter the number of goals received: ");
            int received = input.nextInt();
            System.out.println();

            // Getting the club's total points
            System.out.print("Enter the club points: ");
            int points = input.nextInt();
            System.out.println();

            // Making the FootballClub object for a specific club being added
            FootballClub fbc = new FootballClub(clubName, location, played, won, lost, drawn, scored, received, points);

            // Adds the club to the file league.txt
            try {
                FileOutputStream fos = new FileOutputStream(new File("app/database/league.txt"), true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(fbc);
                oos.close();
            } catch (Exception e) {
                e.getStackTrace();
            }

            System.out.println("Successfully added to league.txt !!!");
            System.out.println();
        }

    }

    public void printLeague() {

    }

}
