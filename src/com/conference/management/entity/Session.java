package com.conference.management.entity;

import com.conference.management.util.ConferenceUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Session {

    private List<Event> events;
    private int remainingDuration;
    private Calendar startTime;

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
        this.remainingDuration -= event.getDurationInMinutes();
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Session(int duration, Calendar startTime) {
        events = new ArrayList<>();
        this.remainingDuration = duration;
        this.startTime = startTime;
    }

    // check if the talk can be accommodated in the current session.
    public boolean hasRoomFor(Talk talk) {
        return remainingDuration >= talk.getDurationInMinutes();
    }

    public boolean addTalk(Talk talk) {
        if (! hasRoomFor(talk)) {
            return false;
        }

        Calendar currentStartTime = startTime;
        if (events.size() > 0) {
            Event event = events.get(events.size() - 1);
            currentStartTime = ConferenceUtils.getNextStartTime(event);
        }
        addEvent(new Event(currentStartTime, talk.getTitle(), talk.getDurationInMinutes()));
        return true;
    }
}
