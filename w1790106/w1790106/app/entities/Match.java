package app.entities;

import java.io.Serializable;

public class Match implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date date;
    private Score score;

    // This match data with the date and score is saved in match.txt
    public Match(Date date, Score score) {
        this.date = date;
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
