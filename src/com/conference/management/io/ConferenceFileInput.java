package com.conference.management.io;

import com.conference.management.configs.ConferenceConfig;
import com.conference.management.entity.Talk;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ConferenceFileInput implements IConferenceInput {

    @Override
    public List<Talk> fetchTalks(String fileName) throws FileNotFoundException{
        FileInputStream fstream;
        List<Talk> talkList = new ArrayList<>();

        try {
            fstream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Input file specified not found : " + ConferenceConfig.TALKS_INPUT_FILE + ". Make sure the file exists");
            throw e;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        int intMinutes;

        // Read Input File Line By Line
        try {
            while ((strLine = br.readLine()) != null) {
                // handle comments or empty lines.
                if(strLine.contains("//") || strLine.isEmpty())
                    continue;

                String title = strLine.substring(0, strLine.lastIndexOf(" "));
                String minutesString = strLine.substring(strLine.lastIndexOf(" ") + 1);
                // get only the integers as string from the line.
                String minutes = strLine.replaceAll("\\D+", "");
                if (ConferenceConfig.LIGHTNING_TALK.equals(minutesString)) {
                    intMinutes = ConferenceConfig.LIGHTNING_TALK_DURATION_MINUTES;
                } else {
                    try {
                        intMinutes = Integer.parseInt(minutes);
                    } catch (NumberFormatException e) {
                        System.err.println("Could not parse the line : " + strLine);
                        throw e;
                    }
                }
                Talk singleTalk = new Talk(title, intMinutes);
                talkList.add(singleTalk);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fstream.close();
                br.close();
            } catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
        return talkList;
    }

}
