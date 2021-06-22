package app.entities;

public class Score {

    private int TeamOneScore;
    private int TeamTwoScore;
    private String Teams;

    // This gets the scores of boths teams
    public Score(int teamOneScore, int teamTwoScore, String teamOneName, String teamTwoName) {
        this.TeamOneScore = teamOneScore;
        this.TeamTwoScore = teamTwoScore;
        this.Teams = teamOneName + " vs " + teamTwoName;
    }

    public String getTeams() {
        return Teams;
    }

    // The name converts into this format "nameOne vs nameTwo"
    public void setTeams(String teamOneName, String teamTwoName) {
        Teams = teamOneName + " vs " + teamTwoName;
    }

    public int getTeamOneScore() {
        return TeamOneScore;
    }

    public void setTeamOneScore(int teamOneScore) {
        this.TeamOneScore = teamOneScore;
    }

    public int getTeamTwoScore() {
        return TeamTwoScore;
    }

    public void setTeamTwoScore(int teamTwoScore) {
        this.TeamTwoScore = teamTwoScore;
    }

}
