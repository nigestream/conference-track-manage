package com.conference.management.configs;

import com.conference.management.util.ConferenceUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConferenceConfig {
    public static final String TALKS_INPUT_FILE = "input-talks.txt";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm a");

    public static final String LIGHTNING_TALK = "lightning";

    public static final int MORNING_SESSION_DURATION_MINUTES = 180;
    public static final int LIGHTNING_TALK_DURATION_MINUTES = 5;

    public static int AFTERNOON_SESSION_DURATION_MINUTES = 240;

    public static Calendar TRACK_START_TIME = ConferenceUtils.getCalendarTime(9, 0);;
    public static Calendar LUNCH_START_TIME = ConferenceUtils.getCalendarTime(12, 0);
    public static Calendar AFTERNOON_SESSION_START_TIME = ConferenceUtils.getCalendarTime(13, 0);
    public static Calendar NETWORKING_START_TIME = ConferenceUtils.getCalendarTime(17, 0);


    public static final int LUNCH_DURATION_MINUTES = 60;
    public static final int NETWORKING_DURATION_MINUTES = 60;

    //for customer input diy
    public static void setNetworkingStartTime(Calendar startTime) {
        NETWORKING_START_TIME = startTime;
        AFTERNOON_SESSION_DURATION_MINUTES = (int) (NETWORKING_START_TIME.getTimeInMillis() - AFTERNOON_SESSION_START_TIME.getTimeInMillis())/(1000 * 60);
    }
}
