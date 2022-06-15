package com.college_screener.classifiers.accept;

import com.college_screener.Application_Statuses;
import model.Candidate;
import model.Residency;

public class ResidencyAccept {
    public String status;

    public String ResidencyCheck(Candidate candidate) {
        Residency residency = candidate.getState();
        int age = candidate.getAge();
        if (residency == Residency.CA) {
            if (age >= 17 && age <= 26 || age >= 80) {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
            } else {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
            }
        } else {
            if (age >= 80) {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
            } else {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
            }
        }
        return status;
    }
}
