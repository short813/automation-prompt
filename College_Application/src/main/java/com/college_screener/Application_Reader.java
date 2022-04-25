package com.college_screener;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javax.xml.validation.Validator;

public class Application_Reader {
    public String firstName;
    public String lastName;
    public String state;
    public int felonies;
    public String gpa;
    public String age;
    public JSONObject application;
    public Application_Reader() {
    }


    public void Get_Candidate_Information(JSONObject application) throws IOException, ParseException {
        this.application = application;
        firstName = application.get("FirstName").toString();
        lastName = application.get("LastName").toString();
        state = application.get("State").toString();
        gpa = application.get("GPA").toString();
        age = application.get("Age").toString();
        felonies = Integer.parseInt(application.get("Felonies").toString());
    }

    public HashMap Store_Candidate_Information(){
        HashMap<String,Object> candidate = new HashMap<>();
        candidate.put("FirstName",firstName);
        candidate.put("LastName",lastName);
        candidate.put("State",state);
        candidate.put("GPA",gpa);
        candidate.put("Age",age);
        candidate.put("Felonies",felonies);

        if(application.get("ACT") == null) {
            candidate.put("ACT", null);
        }
        else{
            Long act = (Long) application.get("ACT");
            candidate.put("ACT",act);
        }
        if(application.get("SAT") == null) {
            candidate.put("SAT", null);
        }
        else{
            Long sat = (Long) application.get("SAT");
            candidate.put("SAT",sat);

        }
        if(application.get("FelonyDate") == null) {
            candidate.put("FelonyDate", null);
        }
        else{
            Date felonyDate = (Date) application.get("Felony_Date");
            candidate.put("FelonyDate",felonyDate);
        }
        System.out.println(candidate);

    return candidate;
    }
}
