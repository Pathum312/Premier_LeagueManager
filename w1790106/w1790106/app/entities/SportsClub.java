package app.entities;

import java.io.*;

// Parent class
public abstract class SportsClub implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clubName;
    private String location;

    // Sets the club name and location for FootballClub entity
    public SportsClub(String ClubName, String Location) {
        this.clubName = ClubName;
        this.location = Location;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}