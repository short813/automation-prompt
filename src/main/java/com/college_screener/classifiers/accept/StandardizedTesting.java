package com.college_screener.classifiers.accept;

import com.college_screener.Application_Statuses;
import model.Candidate;
import model.scores.StandardTestingScores;
import model.scores.TestType;

import java.util.List;

public class StandardizedTesting {
    String status;

    public String StandardizedTestingCheck(Candidate candidate){
        List<StandardTestingScores> standardized_testing = candidate.getScore();
        // if testType is == SAT and score > 1920
        // else if testType is == ACT and score > 27
        // else return review
        for(int i=0;i<standardized_testing.size();i++){
            if(standardized_testing.get(i).getTestType() == TestType.SAT && standardized_testing.get(i).getScore() >1920)
            {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
            }
            else if((standardized_testing.get(i).getTestType() == TestType.ACT && standardized_testing.get(i).getScore() > 27))
            {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
            }
            else
            {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
            }
        }
        // if testType is == SAT and score > 1920
        // else if testType is == ACT and score > 27
        // else return review
        return status;

    }
}
