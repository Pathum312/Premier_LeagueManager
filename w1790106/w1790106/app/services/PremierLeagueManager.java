package app.services;

import java.io.*;
import java.util.*;
import app.entities.FootballClub;
import app.utils.methods;

public class PremierLeagueManager implements LeagueManager {

    public void addClub() {
        Scanner input = new Scanner(System.in);
        methods m = new methods();

        System.out.print("Enter the name of the club: ");
        String clubName = input.nextLine();
        System.out.println();
        String ans = m.checkSameClub(clubName);
        if (ans.equals("true")) {
            System.out.println("Same Club Name!!!!");
            addClub();
        } else if (ans.equals("false")) {
            System.out.print("Enter the location of the club: ");
            String location = input.nextLine();
            System.out.println();
            System.out.print("Enter the number of matches played: ");
            int played = input.nextInt();
            System.out.println();
            System.out.print("Enter the number of matches won: ");
            int won = input.nextInt();
            System.out.println();
            System.out.print("Enter the number of matches lost: ");
            int lost = input.nextInt();
            System.out.println();
            System.out.print("Enter the number of matches drawn: ");
            int drawn = input.nextInt();
            System.out.println();
            System.out.print("Enter the number of goals scored: ");
            int scored = input.nextInt();
            System.out.println();
            System.out.print("Enter the number of goals received: ");
            int received = input.nextInt();
            System.out.println();
            System.out.print("Enter the club points: ");
            int points = input.nextInt();
            System.out.println();

            FootballClub fbc = new FootballClub(clubName, location, played, won, lost, drawn, scored, received, points);

            try {
                FileOutputStream fos = new FileOutputStream(new File("app/database/league.txt"), true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(fbc);
                oos.close();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }

            System.out.println("Successfully added !!!");
            System.out.println();
        }

    }

}
