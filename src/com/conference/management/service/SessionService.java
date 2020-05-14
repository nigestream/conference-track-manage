package com.conference.management.service;

import com.conference.management.configs.ConferenceConfig;
import com.conference.management.entity.Lunch;
import com.conference.management.entity.Networking;
import com.conference.management.entity.Session;

public class SessionService {
    public static Session newMorningSession() {
        return new Session(ConferenceConfig.MORNING_SESSION_DURATION_MINUTES, ConferenceConfig.TRACK_START_TIME);
    }

    public static Session newAfternoonSession() {
        return new Session(ConferenceConfig.AFTERNOON_SESSION_DURATION_MINUTES, ConferenceConfig.AFTERNOON_SESSION_START_TIME);
    }

    public static Session newLunchSession() {
        Session lunchSession = new Session(ConferenceConfig.LUNCH_DURATION_MINUTES, ConferenceConfig.LUNCH_START_TIME);
        lunchSession.addEvent(new Lunch());
        return lunchSession;
    }

    public static Session newNetworkingSession() {
        Session networkingSession = new Session(ConferenceConfig.LUNCH_DURATION_MINUTES, ConferenceConfig.LUNCH_START_TIME);
        networkingSession.addEvent(new Networking());
        return networkingSession;
    }
}
