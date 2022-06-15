package com.college_screener;
import model.Candidate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Application_Processor();

    }

    public static void Application_Processor() throws IOException, ParseException {
        Object application = new JSONParser().parse(new FileReader("src/main/resources/Richard_Luu_application.json"));
        JSONObject application_json = (JSONObject) application;
        Application_Reader result = new Application_Reader();
        Candidate candidate =  result.Get_Candidate_Information(application_json);
        Application_Screener screen_results = new Application_Screener();
        String results = screen_results.CandidateScreening(candidate);
        System.out.println(results);



    }
}