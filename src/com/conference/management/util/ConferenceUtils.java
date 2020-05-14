package com.conference.management.util;

import com.conference.management.configs.ConferenceConfig;
import com.conference.management.entity.*;
import com.conference.management.enums.DataInputEnum;
import com.conference.management.enums.DataOutputEnum;
import com.conference.management.exceptions.UnsupportedDestinationException;
import com.conference.management.exceptions.UnsupportedSourceException;
import com.conference.management.io.ConferenceFileInput;
import com.conference.management.io.ConferenceConsoleOutput;
import com.conference.management.io.IConferenceInput;
import com.conference.management.io.IConferenceOutput;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.List;

public class ConferenceUtils {

    public static Calendar getCalendarTime(int hours, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        return cal;
    }

    public static Calendar getNextStartTime(Event event) {
        Calendar newTime = Calendar.getInstance();
        newTime.set(Calendar.HOUR_OF_DAY, event.getStartTime().get(Calendar.HOUR_OF_DAY));
        newTime.set(Calendar.MINUTE, event.getStartTime().get(Calendar.MINUTE));
        newTime.add(Calendar.MINUTE, event.getDurationInMinutes());
        return newTime;
    }

    public static List<Talk> fetchTalksListFromSource(DataInputEnum dataInputEnum) throws UnsupportedSourceException {
        // Not exactly a factory. This will create an instance of the required SourceManager
        if (dataInputEnum.equals(DataInputEnum.FILE)) {
            IConferenceInput sourceManager = new ConferenceFileInput();
            try {
                return sourceManager.fetchTalks(ConferenceConfig.TALKS_INPUT_FILE);
            } catch (Exception e) {
                return null;
            }
        } else {
            throw new UnsupportedSourceException("Source type not valid");
        }
    }

    public static void outputSchedule(Conference conference, int combination, DataOutputEnum dataOutputEnum) throws UnsupportedDestinationException {
        // Not exactly a factory. This will create an instance of the required OutputManager
        if (dataOutputEnum.equals(DataOutputEnum.CONSOLE)) {
            IConferenceOutput outputManager = new ConferenceConsoleOutput();
            outputManager.printSchedule(conference, combination);
        } else {
            throw new UnsupportedDestinationException("Destination not valid.");
        }
    }


    public static void printTalks(List<Talk> talkList) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Input talks:");
        for (Talk talk : talkList) {
            // Print the prepared talk's title for this Track
            System.out.println(talk.getTitle() + " " + talk.getDurationInMinutes());
        }
        System.out.println("--------------------------------------------------------");
    }
}
