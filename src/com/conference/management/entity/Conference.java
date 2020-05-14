package com.conference.management.entity;

import java.util.*;

public class Conference {
    List<Track> tracks;

    public List<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    public Conference(){
        this.tracks = new ArrayList<>();
    }
}


