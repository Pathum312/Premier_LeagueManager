package app.services;

import java.io.*;
import java.util.*;
import app.entities.FootballClub;
import app.entities.Match;
import app.entities.Date;
import app.entities.Score;
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

    // Deletes a club in league.txt
    public void deleteClub() {
        methods m = new methods();
        int count = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the club: ");
        String clubName = input.nextLine();
        System.out.println();

        // Returns a arraylist of all the clubs
        ArrayList<FootballClub> clubList = m.removeClub(clubName);

        for (FootballClub i : clubList) {
            System.out.println(i.getClubName());
        }

        try {

            for (FootballClub f1 : clubList) {
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

    // Updates the stats of a club in league.txt
    public void updateClub() {
        methods m = new methods();

        int count = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the club: ");
        String clubName = input.nextLine();
        System.out.println();

        // Returns a arraylist of all the clubs
        ArrayList<FootballClub> clubList = m.getClubList();

        ArrayList<FootballClub> tempList = new ArrayList<FootballClub>();

        for (FootballClub i : clubList) {
            if (clubName.equals(i.getClubName())) {

                // Getting the club location
                System.out.print("Enter the location of the club: ");
                String location = input.nextLine();
                System.out.println();
                i.setLocation(location);

                // Getting the no. of matches played by the club
                System.out.print("Enter the number of matches played: ");
                int played = input.nextInt();
                System.out.println();
                i.setPlayed(played);

                // Getting the no. of matches won by the club
                System.out.print("Enter the number of matches won: ");
                int won = input.nextInt();
                System.out.println();
                i.setWon(won);

                // Getting the no. of matches lost by the club
                System.out.print("Enter the number of matches lost: ");
                int lost = input.nextInt();
                System.out.println();
                i.setLost(lost);

                // Getting the no. of matches drawn by the club
                System.out.print("Enter the number of matches drawn: ");
                int drawn = input.nextInt();
                System.out.println();
                i.setDrawn(drawn);

                // Getting the no. of goals scored by the club
                System.out.print("Enter the number of goals scored: ");
                int scored = input.nextInt();
                System.out.println();
                i.setGoalsScored(scored);

                // Getting the no. of goals received by the club
                System.out.print("Enter the number of goals received: ");
                int received = input.nextInt();
                System.out.println();
                i.setGoalsReceived(received);

                // Getting the club's total points
                System.out.print("Enter the club points: ");
                int points = input.nextInt();
                System.out.println();
                i.setPoints(points);

                tempList.add(i);

                System.out.println("Successfully updated " + i.getClubName() + " in league.txt !!!");
            } else {
                tempList.add(i);
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

    // Prints a table with a club in the league.txt
    public void printLeague() {
        methods m = new methods();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the club: ");
        String clubName = input.nextLine();
        System.out.println();

        // Returns a arraylist of all the clubs
        ArrayList<FootballClub> clubList = m.getClubList();

        System.out.print("+-----------+----------+--------+-----+------+-------+-------+----------+--------+");
        System.out.println();
        System.out.print("| Club Name | Location | Played | Won | Lost | Drawn | Goals | Received | Points |");
        System.out.println();
        System.out.print("+-----------+----------+--------+-----+------+-------+-------+----------+--------+");
        System.out.println();
        for (FootballClub i : clubList) {

            if (clubName.equals(i.getClubName())) {
                System.out.print("| " + i.getClubName());
                m.gap(9, i.getClubName().length());
                System.out.print("| " + i.getLocation());
                m.gap(8, i.getLocation().length());
                System.out.print("| " + i.getPlayed());
                m.gap(6, String.valueOf(i.getPlayed()).length());
                System.out.print("| " + i.getWon());
                m.gap(3, String.valueOf(i.getWon()).length());
                System.out.print("| " + i.getLost());
                m.gap(4, String.valueOf(i.getLost()).length());
                System.out.print("| " + i.getDrawn());
                m.gap(5, String.valueOf(i.getDrawn()).length());
                System.out.print("| " + i.getGoalsScored());
                m.gap(5, String.valueOf(i.getGoalsScored()).length());
                System.out.print("| " + i.getGoalsRceived());
                m.gap(8, String.valueOf(i.getGoalsRceived()).length());
                System.out.print("| " + i.getPoints());
                m.gap(6, String.valueOf(i.getPoints()).length());
                System.out.print("|");
                System.out.println();
                System.out.print("+-----------+----------+--------+-----+------+-------+-------+----------+--------+");
                System.out.println();
            }
        }

    }

    public void printDescendingLeague() {
        methods m = new methods();

        // Returns a arraylist of all the clubs
        ArrayList<FootballClub> clubList = m.getClubList();

        FootballClub temp;

        // Sorts the arraylist in descending order
        for (int i = 0; i < clubList.size(); i++) {
            for (int j = i + 1; j < clubList.size(); j++) {
                if (clubList.get(j).getPoints() > clubList.get(i).getPoints()) {
                    temp = clubList.get(i);
                    clubList.set(i, clubList.get(j));
                    clubList.set(j, temp);
                } else if (clubList.get(j).getPoints() == clubList.get(i).getPoints()) {
                    if (clubList.get(j).getGoalsScored() > clubList.get(i).getGoalsScored()) {
                        temp = clubList.get(i);
                        clubList.set(i, clubList.get(j));
                        clubList.set(j, temp);
                    }
                }
            }
        }

        System.out.print("+-----------+----------+--------+-----+------+-------+-------+----------+--------+");
        System.out.println();
        System.out.print("| Club Name | Location | Played | Won | Lost | Drawn | Goals | Received | Points |");
        System.out.println();
        System.out.print("+-----------+----------+--------+-----+------+-------+-------+----------+--------+");
        System.out.println();
        for (FootballClub i : clubList) {

            System.out.print("| " + i.getClubName());
            m.gap(9, i.getClubName().length());
            System.out.print("| " + i.getLocation());
            m.gap(8, i.getLocation().length());
            System.out.print("| " + i.getPlayed());
            m.gap(6, String.valueOf(i.getPlayed()).length());
            System.out.print("| " + i.getWon());
            m.gap(3, String.valueOf(i.getWon()).length());
            System.out.print("| " + i.getLost());
            m.gap(4, String.valueOf(i.getLost()).length());
            System.out.print("| " + i.getDrawn());
            m.gap(5, String.valueOf(i.getDrawn()).length());
            System.out.print("| " + i.getGoalsScored());
            m.gap(5, String.valueOf(i.getGoalsScored()).length());
            System.out.print("| " + i.getGoalsRceived());
            m.gap(8, String.valueOf(i.getGoalsRceived()).length());
            System.out.print("| " + i.getPoints());
            m.gap(6, String.valueOf(i.getPoints()).length());
            System.out.print("|");
            System.out.println();
            System.out.print("+-----------+----------+--------+-----+------+-------+-------+----------+--------+");
            System.out.println();

        }
    }

    // Add a match to match.txt and update the clubs details in league.txt
    public void addMatch() {
        methods m = new methods();

        Scanner input = new Scanner(System.in);

        // Getting the first club's name
        System.out.print("Enter the name of the frist club: ");
        String clubNameOne = input.nextLine();
        System.out.println();

        // Getting the second club's name
        System.out.print("Enter the name of the second club: ");
        String clubNameTwo = input.nextLine();
        System.out.println();

        // Getting the first club's score
        System.out.print("Enter the first club's score: ");
        int clubNameOneScore = input.nextInt();
        System.out.println();

        // Getting the second club's score
        System.out.print("Enter the second club's score: ");
        int clubNameTwoScore = input.nextInt();
        System.out.println();

        // Getting the day
        System.out.print("Enter the day: ");
        int day = input.nextInt();
        System.out.println();

        // Getting the month
        System.out.print("Enter the month: ");
        int month = input.nextInt();
        System.out.println();

        // Getting the year
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        System.out.println();

        Match match = new Match(new Date(day, month, year),
                new Score(clubNameOneScore, clubNameTwoScore, clubNameOne, clubNameTwo));

        // Adding match to match.txt
        try {
            FileOutputStream fos = new FileOutputStream(new File("app/database/match.txt"), true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(match);
            oos.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        // Updates the clubs details after match is added
        m.updateClubAfterMatch(clubNameOneScore, clubNameTwoScore, clubNameOne, clubNameTwo);

        System.out.println("Successfully added to match.txt !!!");
        System.out.println();

    }

    // Runs the angular ui directly from the command-line program
    public void runGUI() {
        try {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \" sbt run\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
