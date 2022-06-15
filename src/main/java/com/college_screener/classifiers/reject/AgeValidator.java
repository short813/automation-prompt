package com.college_screener.classifiers.reject;

import com.college_screener.Application_Statuses;
import model.Candidate;

public class AgeValidator {
    String status;

    public String AgeCheck(Candidate candidate) {
        if (candidate.getAge() < 0) {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
            System.out.println("This candidate failed because they inputted their age as less than 0");
        } else {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();

        }
        return status;
    }
}
