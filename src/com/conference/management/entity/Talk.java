package com.conference.management.entity;


public class Talk implements Comparable<Talk> {

    private int durationInMinutes;
    private String title;

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public Talk(String title, int durationInMinutes)
    {
        this.durationInMinutes = durationInMinutes;
        this.title = title;
    }

    @Override
    public int compareTo(Talk talk) {
        return this.getDurationInMinutes() - talk.getDurationInMinutes();
    }
}
