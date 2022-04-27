package com.college_screener;

import java.util.HashMap;
import java.time.LocalDate;
public class Application_Judgment {
    public static String status;
   public static LocalDate current_date = LocalDate.now();

    public static String NameValidator(HashMap candidate) {
        char character;
        int i;
        String firstName = candidate.get("FirstName").toString();
        String lastName = candidate.get("FirstName").toString();
        char firstNameCharacter = firstName.charAt(0);
        char lastNameCharacter = lastName.charAt(0);
        if(Character.isUpperCase(firstNameCharacter) && Character.isUpperCase(lastNameCharacter)) {

            for (i = 1; i < firstName.length(); i++) {
                character = firstName.charAt(i);
                if (Character.isUpperCase(character)) {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
                } else {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
                }
            }
            // This does not take in the possibility of a candidate with last names that has special characters in their last name or has a second capital letter.
            for (i = 1; i < lastName.length(); i++) {
                character = lastName.charAt(i);
                if (Character.isUpperCase(character)) {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
                } else {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
                }
            }
        }
        else{
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
        }
        return status;
    }

    public static String AgeValidator(HashMap candidate){
        String state = candidate.get("State").toString();
        int age =  Integer.parseInt(candidate.get("Age").toString());
        if (age >= 0) {
            if (state.equalsIgnoreCase("CA")) {
                if (age >= 17 && age <= 26) { // You are a california resident and you fall within this age group Instant Accept
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
                }
            } else if( age >= 80) { // You live anywhere and you are over 80 you are instant accept
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
            }
            else { // You live anywhere but california and your age is between 1 and 80, further review
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();

            }
        }
        else{ // your age is less than 0 instant reject
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();

        }
        return status;
    }

    public static String FelonyCheck(HashMap candidate){
        int felonyDate = Integer.parseInt(candidate.get("FelonyDate").toString());
        int current_Year = current_date.getYear();
        int felonyDateDifference =current_Year-felonyDate;
        if (felonyDateDifference <= 5){
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
        }
        else{
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
        }
        return status;
    }

    public static String GPACheck(HashMap candidate) {
        Double gpaScale = Double.parseDouble(candidate.get("GPAScale").toString());
        double gpa = Double.parseDouble(candidate.get("GPA").toString());
        if(gpaScale.equals(4.0)) {
            if (gpa >= 3.6) {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
            } else if (gpa >= 2.8 && gpa <= 3.59) {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
            } else {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();

            }
        }
        else if(gpaScale.equals(5.0)){
            if (gpa >= 4.5) {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();
            } else if (gpa >= 3.5 && gpa <= 4.49) {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
            } else {
                status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();

            }
        }
        return status;
    }

    public static String StandardizedTestingCheck(HashMap candidate){
       int sat;
       int act;
        if (candidate.get("SAT")== null){
            sat =0;
        }
        else{
            sat = Integer.parseInt(candidate.get("SAT").toString());
            System.out.println(sat);
        }
        if(candidate.get("ACT") == null){
            act =0;
        }
        else{
            act = Integer.parseInt(candidate.get("ACT").toString());
        }
        if (sat > 1920 || act > 27)
        {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.ACCEPT).toString();

        }
        else {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();

        }
    return status;
    }
}
