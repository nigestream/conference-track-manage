package test.com.conference.management;

import com.conference.management.entity.Session;
import com.conference.management.entity.Talk;
import com.conference.management.util.ConferenceUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;


public class SessionTest {

    @Test
    public void testHasRoomForTalk(){

        Calendar sessionStartTime = ConferenceUtils.getCalendarTime(9, 00);
        Session session = new Session(50, sessionStartTime);

        Talk talk1 = new Talk("Valid Talk", 45);
        Assert.assertTrue(session.hasRoomFor(talk1));

        Talk talk2 = new Talk("InValid Talk", 60);
        Assert.assertFalse(session.hasRoomFor(talk2));

    }
}
