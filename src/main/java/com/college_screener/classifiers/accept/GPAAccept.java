package com.college_screener.classifiers.accept;

import com.college_screener.Application_Statuses;
import model.Candidate;
import com.college_screener.classifiers.reject.GPAReject;

public class GPAAccept {
    public static String status;

    public String GPACheck(Candidate candidate) {
        Double gpaPercentage = candidate.getGpa().getPercentage();
        if (gpaPercentage > .9) {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
        } else if (gpaPercentage >= .71 && gpaPercentage <= .89) {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        } else {
            GPAReject gpaReject = new GPAReject();
            status = gpaReject.GPANegativeCheck(candidate);
        }
        return status;
    }
}
