package com.college_screener;

import java.util.EnumMap;
import java.util.HashMap;
public class Application_Screener {

    public String Verdict;
    public String Screener(HashMap candidate){
        if(NameValidator(candidate) == "instant reject" ){
            Verdict = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
        }
        return Verdict;

    }

   public static String NameValidator(HashMap candidate) {
       String firstName = candidate.get("FirstName").toString();
       String lastName = candidate.get("FirstName").toString();
       char character;
       int i;
       for(i=1;i<firstName.length();i++){
           System.out.println(firstName.charAt(i));
       }
       String status;
       if (1==1) {
           status = Application_Statuses.EnumMapper().get(Application_Statuses.ApplicationStatus.REJECT).toString();
           System.out.println(status);
       }
       return status;
   }






}

