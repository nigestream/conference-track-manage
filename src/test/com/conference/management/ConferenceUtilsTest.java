package test.com.conference.management;

import com.conference.management.entity.Event;
import com.conference.management.util.ConferenceUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class ConferenceUtilsTest {


    @Test
    public void testGetCalendarTime() {

        Calendar cal1 = ConferenceUtils.getCalendarTime(5, 50);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, 5);
        cal2.set(Calendar.MINUTE, 50);
        Assert.assertEquals(cal1.get(Calendar.HOUR_OF_DAY), cal2.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(cal1.get(Calendar.MINUTE), cal2.get(Calendar.MINUTE));

        cal1 = ConferenceUtils.getCalendarTime(5, 70);
        cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, 5);
        cal2.set(Calendar.MINUTE, 70);

        Assert.assertEquals(cal1.get(Calendar.HOUR_OF_DAY), cal2.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(cal1.get(Calendar.MINUTE), cal2.get(Calendar.MINUTE));

    }

    @Test
    public void testGetNextStartTime() {
        Calendar currentStartTime = ConferenceUtils.getCalendarTime(5, 50);
        Event preEvent = new Event(currentStartTime, "Pre Talk Event", 50);

        Calendar nextStartTimeManual = ConferenceUtils.getCalendarTime(6, 40);
        Calendar nextStartTimeCalculated = ConferenceUtils.getNextStartTime(preEvent);

        Assert.assertEquals(nextStartTimeManual.get(Calendar.HOUR_OF_DAY), nextStartTimeCalculated.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(nextStartTimeManual.get(Calendar.MINUTE), nextStartTimeCalculated.get(Calendar.MINUTE));
    }
}
