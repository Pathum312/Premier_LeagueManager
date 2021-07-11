package app.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import app.entities.FootballClub;
import app.entities.Match;
import app.entities.Date;
import app.entities.Score;
import app.utils.methods;

public class HomeController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    // Sends json data with clubs in descending order of points
    public Result getPoints() {
        methods m = new methods();

        // Returns a arraylist of all the clubs
        ArrayList<FootballClub> clubList = m.getClubList();

        FootballClub temp;

        // Sorts the arraylist in descending order of points
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

        for (FootballClub f1 : clubList) {
            JsonNode Json = play.libs.Json.toJson(f1);
            logger.debug("In FootBallController.getPoints(), result is: {}", Json.toString());
        }

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(clubList, JsonNode.class);
        return ok(jsonData);
    }

    // Sends json data with clubs in descending order of goals
    public Result getGoals() {
        methods m = new methods();

        // Returns a arraylist of all the clubs
        ArrayList<FootballClub> clubList = m.getClubList();

        FootballClub temp;

        // Sorts the arraylist in descending order of goals
        for (int i = 0; i < clubList.size(); i++) {
            for (int j = i + 1; j < clubList.size(); j++) {
                if (clubList.get(j).getGoalsScored() > clubList.get(i).getGoalsScored()) {
                    temp = clubList.get(i);
                    clubList.set(i, clubList.get(j));
                    clubList.set(j, temp);
                } else if (clubList.get(j).getPoints() == clubList.get(i).getPoints()) {
                    if (clubList.get(j).getGoalsRceived() > clubList.get(i).getGoalsRceived()) {
                        temp = clubList.get(i);
                        clubList.set(i, clubList.get(j));
                        clubList.set(j, temp);
                    }
                }
            }
        }

        for (FootballClub f1 : clubList) {
            JsonNode Json = play.libs.Json.toJson(f1);
            logger.debug("In FootBallController.getPoints(), result is: {}", Json.toString());
        }

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(clubList, JsonNode.class);
        return ok(jsonData);
    }

    // Sends json data with clubs in descending order of wins
    public Result getWon() {
        methods m = new methods();

        // Returns a arraylist of all the clubs
        ArrayList<FootballClub> clubList = m.getClubList();

        FootballClub temp;

        // Sorts the arraylist in descending order of points
        for (int i = 0; i < clubList.size(); i++) {
            for (int j = i + 1; j < clubList.size(); j++) {
                if (clubList.get(j).getWon() > clubList.get(i).getWon()) {
                    temp = clubList.get(i);
                    clubList.set(i, clubList.get(j));
                    clubList.set(j, temp);
                } else if (clubList.get(j).getWon() == clubList.get(i).getWon()) {
                    if (clubList.get(j).getLost() < clubList.get(i).getLost()) {
                        temp = clubList.get(i);
                        clubList.set(i, clubList.get(j));
                        clubList.set(j, temp);
                    }
                }
            }
        }

        for (FootballClub f1 : clubList) {
            JsonNode Json = play.libs.Json.toJson(f1);
            logger.debug("In FootBallController.getPoints(), result is: {}", Json.toString());
        }

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(clubList, JsonNode.class);
        return ok(jsonData);
    }

}
