package com.college_screener;

import java.util.*;

import static com.college_screener.Application_Judgment.*;

public class Application_Screener {

    public static String verdict;

    public String Screenerv2(HashMap candidate){
        String nameValidation = NameValidator(candidate);
        String ageValidation = AgeValidator(candidate);
        String felonyCheck = FelonyCheck(candidate);
        String gpaCheck = GPACheck(candidate);
        String standardizedTestingCheck = StandardizedTestingCheck(candidate);
        String[] validationArray = new String[]{nameValidation,ageValidation,felonyCheck,gpaCheck,standardizedTestingCheck};
        ArrayList<String> validationList = new ArrayList<>(Arrays.asList(validationArray));
        if(validationList.contains("instant reject")){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
        }
        else if(validationList.contains("instant accept")){
            verdict = InstantAcceptCheck(validationList);
        }
        else{
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();

        }
        return verdict;
    }
    public static String InstantAcceptCheck(ArrayList<String> list){
        int instantAcceptCounter = 0;
        // Parse through results of the validations to see if there is enough instant accepts to be classified as an instant accept
        for (String s : list){

            if(s == "instant accept"){
                instantAcceptCounter++;
            }
        }
        // As there are 4 conditions to instant accept that includes no instant reject
        if (instantAcceptCounter == 3){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
        }
        else{
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        }
        return verdict;
    }
}

