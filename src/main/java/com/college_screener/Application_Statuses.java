package com.college_screener;

import java.util.EnumMap;

public class Application_Statuses {
    public enum ApplicationStatus {
        ACCEPT, REJECT, REVIEW, CONTINUE;
    }

    public static EnumMap EnumMapper() {
        EnumMap<ApplicationStatus, String> statusMap = new EnumMap<ApplicationStatus, String>(ApplicationStatus.class);
        statusMap.put(ApplicationStatus.ACCEPT, "instant accept");
        statusMap.put(ApplicationStatus.REJECT, "instant reject");
        statusMap.put(ApplicationStatus.REVIEW, "further review");
        return statusMap;
    }
}
