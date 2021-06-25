package app.utils;

import java.util.Scanner;
import app.services.PremierLeagueManager;

public class runTimeMenu {

    // Command-line interface
    public void menu() {
        Scanner input = new Scanner(System.in);
        PremierLeagueManager plm = new PremierLeagueManager();

        System.out.println();
        System.out.println("------Welcome to Premier League------");
        System.out.println();
        System.out.println("Here's what you can do:-");
        System.out.println("1. Add a club");
        System.out.println("2. Delete a club");
        System.out.println("3. Update a club");
        System.out.println("4. Print the league table");
        System.out.println("5. Print the league table in descending order");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("What is your choice? ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println();
                plm.addClub();
                menu();
                break;
            case 2:
                System.out.println();
                plm.deleteClub();
                menu();
                break;
            case 3:
                System.out.println();
                plm.updateClub();
                menu();
                break;
            case 4:
                System.out.println();
                plm.printLeague();
                menu();
                break;
            case 5:
                System.out.println();
                System.out.println("Print descending");
                menu();
                break;
            case 6:
                System.out.println();
                System.out.println("Thank you for using Premier league.");
                System.out.println("Goodbye !!!");
                break;
        }

        input.close();

    }

}
