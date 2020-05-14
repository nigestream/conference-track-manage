package com.conference.management.io;

import com.conference.management.entity.Conference;

public interface IConferenceOutput {
    void printSchedule(Conference conference, int combination);
}
