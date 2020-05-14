package com.conference.management.io;

import com.conference.management.entity.Talk;

import java.util.List;

public interface IConferenceInput {
    List<Talk> fetchTalks(String fileName) throws Exception;
}
