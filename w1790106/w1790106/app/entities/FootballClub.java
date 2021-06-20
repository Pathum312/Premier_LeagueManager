package app.entities;

// Sub Class
public class FootballClub extends SportsClub {

    private int played;
    private int won;
    private int lost;
    private int drawn;
    private int goalsScored;
    private int goalsReceived;
    private int clubPoints;

    // Sets the statistics for the FootballClub entity
    public FootballClub(String clubName, String location, int played, int won, int lost, int drawn, int goalsScored,
            int goalsReceived, int clubPoints) {
        super(clubName, location);
        this.played = played;
        this.won = won;
        this.lost = lost;
        this.drawn = drawn;
        this.goalsScored = goalsScored;
        this.goalsReceived = goalsReceived;
        this.clubPoints = clubPoints;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getDrawn() {
        return drawn;
    }

    public void setDrawn(int drawn) {
        this.drawn = drawn;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsRceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getPoints() {
        return clubPoints;
    }

    public void setPoints(int points) {
        this.clubPoints = points;
    }

}
