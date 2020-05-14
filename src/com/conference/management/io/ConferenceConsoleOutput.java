package com.conference.management.io;

import com.conference.management.configs.ConferenceConfig;
import com.conference.management.entity.*;
import com.conference.management.entity.Event;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConferenceConsoleOutput implements IConferenceOutput {

    @Override
    public void printSchedule (Conference conference, int combination) {

        SimpleDateFormat sdf = ConferenceConfig.DATE_FORMAT;
//        System.out.println("=====================");
        System.out.println("Output: Conference Schedule " + combination + ":");
        System.out.println("--------------------------------------------------------");
        for(Track track : conference.getTracks()){
            System.out.println("Track " + track.getTrackId());
            List<Session> sessions = track.getSessions();
            System.out.println("");

            for (Session session : sessions) {
                for (Event event : session.getEvents()) {
                    System.out.println(sdf.format(event.getStartTime().getTime()) + " " + event.getTitle() + " " + event.getDurationInMinutes());
                }
            }
            System.out.println("--------------------------------------------------------");
        }
    }

}
