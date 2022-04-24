package com.college_screener;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Application_Import();

    }

    public static void Application_Import() throws IOException, ParseException {
        Object application = new JSONParser().parse(new FileReader("src/main/resources/John_Smith_application.json"));
        JSONObject application_json = (JSONObject) application;
        Application_Reader result = new Application_Reader();
        result.Candidate_Information(application_json);

    }
}