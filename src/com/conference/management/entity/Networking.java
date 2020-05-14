package com.conference.management.entity;

import com.conference.management.configs.ConferenceConfig;

public class Networking extends Event {

    public Networking () {
        super(ConferenceConfig.NETWORKING_START_TIME, "Networking Event", 0);
    }
}
