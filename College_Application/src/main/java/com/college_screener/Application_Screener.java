package com.college_screener;

import java.util.EnumMap;
import java.util.HashMap;
public class Application_Screener {

    public String verdict;
    public static String status;

    public String Screener(HashMap candidate){
        if(NameValidator(candidate) == "Needs more information" ){
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.CONTINUE).toString();
        }
        else{
            verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
        }


        return verdict;

    }

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
                   status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.CONTINUE).toString();
               }
           }
          // This does not take in the possibility of a candidate with last names that has special characters in their last name or has a second capital letter.
           for (i = 1; i < lastName.length(); i++) {
               character = lastName.charAt(i);
               if (Character.isUpperCase(character)) {
                   status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
               } else {
                   status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.CONTINUE).toString();
               }
           }
       }
       else{
           status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
       }
       return status;
   }






}

