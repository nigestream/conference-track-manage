package com.conference.management;

import com.conference.management.configs.ConferenceConfig;
import com.conference.management.entity.Conference;
import com.conference.management.entity.Talk;
import com.conference.management.enums.DataOutputEnum;
import com.conference.management.enums.DataInputEnum;
import com.conference.management.exceptions.UnsupportedDestinationException;
import com.conference.management.exceptions.UnsupportedSourceException;
import com.conference.management.service.ConferenceService;
import com.conference.management.util.ConferenceUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        ConferenceConfig.setNetworkingStartTime(getNetworkingTime());

        ConferenceService conferenceService = new ConferenceService();
        List<Talk> talkList = null;
        // Fetch the input talk list.
        try {
            talkList = ConferenceUtils.fetchTalksListFromSource(DataInputEnum.FILE);
        } catch (UnsupportedSourceException e){
            System.err.println(e.getMessage());
        }

        if(talkList == null || talkList.size() == 0)
            throw new RuntimeException("task list is empty");

        // Print talks.
        ConferenceUtils.printTalks(talkList);

        // schedule talks into events and sessions.
        //shuffle talkList and get more possibles
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(talkList);
            Conference conference = conferenceService.scheduleTalks(talkList);
            // Output the conference events.
            try {
                ConferenceUtils.outputSchedule(conference, i + 1, DataOutputEnum.CONSOLE);
            } catch (UnsupportedDestinationException e){
                System.err.println(e.getMessage());
            }
        }
    }

    private static Calendar getNetworkingTime() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int hour, minute;
        System.out.println("Please input the networking start time between 16:00 and 17:00");
        while (true) {
            String startTimeString = scanner.nextLine();
            String[] sts = startTimeString.split(":");
            if (sts.length != 2) {
                System.out.println("networking start time invalid");
                continue;
            }
            try {
                hour = Integer.valueOf(sts[0]);
                minute = Integer.valueOf(sts[1]);
            } catch (RuntimeException e) {
                System.out.println("networking start time invalid: " + e.getMessage());
                continue;
            }

            if (hour > 17 || hour < 16 || minute < 0 || minute >= 60 || (hour == 17 && minute != 0)) {
                System.out.println("networking start time invalid");
                continue;
            }
            break;
        }

        return ConferenceUtils.getCalendarTime(hour, minute);
    }


}
