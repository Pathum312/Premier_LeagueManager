package app.services;

public interface LeagueManager {

    // Add the club to the database
    void addClub();

    // Prints the entire database
    void printLeague();

    // Deletes a specific club in the database
    void deleteClub();

    // Edits changes to an club after it was added
    void updateClub();

}
