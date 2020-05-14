package com.conference.management.entity;

import com.conference.management.service.SessionService;

import java.util.Arrays;
import java.util.List;

public class Track {
    private int trackId;
    private Session morningSession;
    private Session lunchSession;
    private Session afternoonSession;
    private Session networkingSession;

    public Track(int trackId) {
        this.trackId = trackId;
        initSessions();
    }

    public int getTrackId() {
        return trackId;
    }

    private void initSessions() {
        morningSession = SessionService.newMorningSession();
        lunchSession = SessionService.newLunchSession();
        afternoonSession = SessionService.newAfternoonSession();
        networkingSession = SessionService.newNetworkingSession();
    }

    public Session getMorningSession() {
        return morningSession;
    }

    public Session getAfternoonSession() {
        return afternoonSession;
    }

    public Session getLunchSession() {
        return lunchSession;
    }

    public Session getNetworkingSession() {
        return networkingSession;
    }

    public List<Session> getSessions() {
        return Arrays.asList(morningSession, lunchSession, afternoonSession, networkingSession);
    }

    public boolean addTalk(Talk talk) {
        return morningSession.addTalk(talk) || afternoonSession.addTalk(talk);
    }
}
