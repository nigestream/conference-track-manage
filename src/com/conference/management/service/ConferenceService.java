package com.conference.management.service;

import com.conference.management.entity.*;

import java.util.*;


public class ConferenceService {

    public Conference scheduleTalks(List<Talk> talks) {
        Conference conference = new Conference();
//        Collections.sort(talks);
//        Collections.shuffle(talks);
        int trackCount = 0;

        //init a track for conference
        conference.addTrack(new Track(++trackCount));

        for (Talk talk : talks) {
            boolean isOk = false;
            // create and fill lunch session.
            for (Track track : conference.getTracks()) {
                isOk = track.addTalk(talk);
                if (isOk) break;
            }

            if (!isOk) {
                Track newTrack = new Track(++trackCount);
                newTrack.addTalk(talk);
                conference.addTrack(newTrack);
            }
        }
        return conference;
    }

}
