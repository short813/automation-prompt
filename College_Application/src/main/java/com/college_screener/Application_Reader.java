package com.college_screener;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javax.xml.validation.Validator;

public class Application_Reader {
    public String firstName;
    public String lastName;
    public String state;
    public int felonies;
    public int SATScore = 0;
    public int ACTScore = 0;
    public String gpa;
    public String felonyDate = "00-00-0000";
    public String age;
    public JSONObject application;
    public Application_Reader() {
    }


    public void Candidate_Information(JSONObject application) throws IOException, ParseException {
        this.application = application;
        firstName = application.get("FirstName").toString();
        lastName = application.get("LastName").toString();
        state = application.get("State").toString();
        gpa = application.get("GPA").toString();
        age = application.get("Age").toString();
        felonies = Integer.parseInt(application.get("Felonies").toString());
    }

    public void Name_Validator(){

    }
}
