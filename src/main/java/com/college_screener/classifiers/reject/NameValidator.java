package com.college_screener.classifiers.reject;

import com.college_screener.Application_Statuses;
import model.Candidate;

public class NameValidator {
    public String status;

    public String NameValidator(Candidate candidate) {
        char character;
        String firstName = candidate.getFirstName();
        String lastName = candidate.getLastName();
        char firstNameCharacter = firstName.charAt(0);
        char lastNameCharacter = lastName.charAt(0);
        if (Character.isUpperCase(firstNameCharacter) && Character.isUpperCase(lastNameCharacter)) {

            for (int i = 1; i < firstName.length(); i++) {
                character = firstName.charAt(i);
                if (Character.isUpperCase(character)) {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
                    System.out.println("This candidate failed because their name did not following the name convention");
                    return status;
                } else {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
                }
            }
            // This does not take in the possibility of a candidate with last names that has special characters in their last name or has a second capital letter.
            for (int i = 1; i < lastName.length(); i++) {
                character = lastName.charAt(i);
                if (Character.isUpperCase(character)) {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
                    System.out.println("This candidate failed because their name did not following the name convention");
                    return status;
                } else {
                    status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REVIEW).toString();
                }
            }
        } else {
            status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
        }
        return status;
    }
}
