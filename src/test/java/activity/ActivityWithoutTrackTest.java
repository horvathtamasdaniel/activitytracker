package activity;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ActivityWithoutTrackTest {

    ActivityWithoutTrack activityWithoutTrack = new ActivityWithoutTrack(ActivityType.BASKETBALL);

    @Test
    public void testGetDistance() {
        assertThat(activityWithoutTrack.getDistance(), is(0.0));
    }

    @Test
    public void testGetType() {
        assertThat(activityWithoutTrack.getType(), is(ActivityType.BASKETBALL));
    }


}