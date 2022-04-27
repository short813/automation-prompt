package com.college_screener;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Objects;

import static com.college_screener.Application_Judgment.*;

public class Application_Screener {

    public String verdict;

    public String Screener(HashMap candidate){ //test method just to get all validations tested.

        if(Objects.equals(NameValidator(candidate), "further review")){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        }
        else{
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
            return verdict;
        }
        if(Objects.equals(AgeValidator(candidate), "instant accept")){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
        } else if ((Objects.equals(AgeValidator(candidate), "further review"))) {
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        }
        else{
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
            return verdict;

        }
        if(Objects.equals(FelonyCheck(candidate), "further review")){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
    }
        else {
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
            return verdict;

        }
        if(Objects.equals(GPACheck(candidate),"further review")) {
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        }
        else if(Objects.equals(GPACheck(candidate),"instant accept")){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
        }
        else{
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
            return verdict;

        }
        if (Objects.equals(StandardizedTestingCheck(candidate),"further review")){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        }
        else{
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();


        }
        System.out.println(verdict);
        return verdict;

    }
}

