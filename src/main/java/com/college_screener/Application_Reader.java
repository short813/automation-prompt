package com.college_screener;
import java.io.IOException;
import java.time.Year;
import java.util.*;

import model.Candidate;
import model.Felonies;
import model.Residency;
import model.scores.GPA;
import model.scores.StandardTestingScores;
import model.scores.TestType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Application_Reader {
    public JSONObject application;

    public Application_Reader() {
    }


    public Candidate Get_Candidate_Information(JSONObject application) throws IOException, ParseException {
        this.application = application;

        String firstName = application.get("FirstName").toString();
        String lastName = application.get("LastName").toString();
        Residency state = ResidencyObjectCreator();
        int age = Integer.parseInt(application.get("Age").toString());
        ArrayList<Felonies> felonyObject = FeloniesObjectCreator();
        GPA gpa = GPAobjectCreator();
        ArrayList<Felonies> felonies = FeloniesObjectCreator();
        ArrayList<StandardTestingScores> standardScores = StandardTestingScoreObjectCreator();
        Candidate candidate = new Candidate(firstName, lastName, state, gpa, age, felonies, standardScores);
        return candidate;
    }

    public GPA GPAobjectCreator() {
        double gpa = Double.parseDouble(application.get("GPA").toString());
        double gpaScale = Double.parseDouble(application.get("GPA").toString());
        GPA GPAFromJson = new GPA(gpa, gpaScale);
        return GPAFromJson;
    }

    public ArrayList<Felonies> FeloniesObjectCreator() {
        ArrayList<Felonies> feloniesArrayList = new ArrayList<>();
        if (application.get("FelonyDate") != null) {
            JSONArray felonies = (JSONArray) application.get("FelonyDate");

            for (int i = 0; i < felonies.size(); i++) {
                int years = Integer.parseInt(felonies.get(i).toString());
                Felonies felonyDates = new Felonies(Year.of(years));
                feloniesArrayList.add(felonyDates);
            }
        }
        return feloniesArrayList;
    }


    public ArrayList<StandardTestingScores> StandardTestingScoreObjectCreator() {
        JSONArray ACTscores = (JSONArray) application.get("ACT");
        ArrayList<StandardTestingScores> standardTestingScoresArrayList = new ArrayList<>();

        if (application.get("SAT") != null) {
            JSONArray SATscores = (JSONArray) application.get("SAT");

            for (int i = 0; i < SATscores.size(); i++) {
                int SATscore = Integer.parseInt(SATscores.get(i).toString());
                StandardTestingScores SAT = new StandardTestingScores(SATscore, TestType.SAT);
                standardTestingScoresArrayList.add(SAT);
            }
        }
        if (application.get("ACT") != null) {
            for (int i = 0; i < ACTscores.size(); i++) {
                int ACTscore = Integer.parseInt(ACTscores.get(i).toString());
                StandardTestingScores ACT = new StandardTestingScores(ACTscore, TestType.ACT);
                standardTestingScoresArrayList.add(ACT);
            }
        }
        return standardTestingScoresArrayList;
    }

    public Residency ResidencyObjectCreator() {
        String state = application.get("State").toString();
        Residency resident;
        if (state.equalsIgnoreCase(String.valueOf(Residency.CA))) {
            resident = Residency.CA;
        } else {
            resident = Residency.other;
        }
        return resident;
    }
}
