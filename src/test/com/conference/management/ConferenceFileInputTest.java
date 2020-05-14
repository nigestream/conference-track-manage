package test.com.conference.management;

import com.conference.management.entity.Talk;
import com.conference.management.io.ConferenceFileInput;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class ConferenceFileInputTest {

    private ConferenceFileInput manager = new ConferenceFileInput();

    @Test(expected = FileNotFoundException.class)
    public void testFetchTalksFileNotFound() throws FileNotFoundException {
        manager.fetchTalks("input-test-talks-random-file.txt");
    }


    @Test
    public void testFetchTalksValidFile() throws FileNotFoundException {
        List<Talk> talks = manager.fetchTalks("input-test-two-talks.txt");
        Assert.assertEquals(2, talks.size());
    }


    @Test
    public void testFetchTalksEmptyFile() throws FileNotFoundException {
        List<Talk> talks = manager.fetchTalks("input-test-talks-empty.txt");
        Assert.assertEquals(0, talks.size());
    }


    @Test(expected = NumberFormatException.class)
    public void testFetchTalksInvalidFile() throws FileNotFoundException {
        List<Talk> talks = manager.fetchTalks("input-test-invalid-talks.txt");
    }

}