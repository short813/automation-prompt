package com.college_screener.classifiers.reject;

import com.college_screener.Application_Statuses;
import model.Candidate;
import model.Felonies;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class FelonyValidator {
    String status;
    public String FelonyCheck(Candidate candidate) {
        List<Felonies> feloniesList = candidate.getFelonies();
        if(feloniesList.size() == 0)
        {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        }
        else
        {
            for(int i=0;i<feloniesList.size();i++) {
                if(Year.now().compareTo(feloniesList.get(i).getConvictionDate()) <= 5)
                {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
                    System.out.println("This candidate failed because they had one or more felonies within the last 5 years");
                }
                else
                {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
                }
            }
        }
    return status;
    }
}
