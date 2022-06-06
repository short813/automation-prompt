package com.college_screener;
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
        result.Get_Candidate_Information(application_json);
        HashMap candidate_information = result.Store_Candidate_Information();
        Application_Screener screen_results = new Application_Screener();
        String results = screen_results.Screenerv2(candidate_information);
        System.out.println(results);



    }
}