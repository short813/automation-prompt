package com.college_screener.classifiers.reject;

import com.college_screener.Application_Statuses;
import model.Candidate;

public class GPAReject {
    public static String status;

    public String GPANegativeCheck(Candidate candidate) {
        Double gpaPercentage = candidate.getGpa().getPercentage();
        if (gpaPercentage < .70) {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
        }

        return status;
    }
}
