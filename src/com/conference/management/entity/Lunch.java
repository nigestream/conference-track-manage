package com.conference.management.entity;

import com.conference.management.configs.ConferenceConfig;

public class Lunch extends Event {
    public Lunch() {
        super(ConferenceConfig.LUNCH_START_TIME, "Lunch", ConferenceConfig.LUNCH_DURATION_MINUTES);
    }
}
