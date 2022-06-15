package com.college_screener;

import model.Candidate;

import java.util.*;

import com.college_screener.classifiers.reject.FelonyValidator;
import com.college_screener.classifiers.reject.NameValidator;
import com.college_screener.classifiers.reject.AgeValidator;
import com.college_screener.classifiers.reject.GPAReject;
import com.college_screener.classifiers.accept.GPAAccept;
import com.college_screener.classifiers.accept.ResidencyAccept;
import com.college_screener.classifiers.accept.StandardizedTesting;

public class Application_Screener {

    public static String verdict;
    NameValidator nameValidator = new NameValidator();
    AgeValidator ageValidator = new AgeValidator();
    FelonyValidator felonyValidator = new FelonyValidator();
    GPAAccept gpaAccept = new GPAAccept();
    StandardizedTesting standardizedTesting = new StandardizedTesting();
    ResidencyAccept residencyAccept = new ResidencyAccept();

    public String CandidateScreening(Candidate candidate){
      String nameValidation = nameValidator.NameValidator(candidate);
      String ageValidation = ageValidator.AgeCheck(candidate);
      String felonyValidation = felonyValidator.FelonyCheck(candidate);
      String GPAValidation = gpaAccept.GPACheck(candidate);
      String standardizedTestingValidation = standardizedTesting.StandardizedTestingCheck(candidate);
      String residencyValidation = residencyAccept.ResidencyCheck(candidate);
      verdict = resultJudgement(nameValidation,ageValidation,residencyValidation,felonyValidation,GPAValidation,standardizedTestingValidation);
      return verdict;
    }

    private String resultJudgement(String nameValidation, String ageValidation,String residencyValidation, String felonyValidation, String gpaValidation, String standardizedTestingValidation) {
        String[] validationArray = new String[]{nameValidation,ageValidation,residencyValidation,felonyValidation,gpaValidation,standardizedTestingValidation};
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
        for (String s : list){

            if(s == "instant accept"){
                instantAcceptCounter++;
            }
        }
        if (instantAcceptCounter == 3){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
        }
        else{
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        }
        return verdict;
    }
}

