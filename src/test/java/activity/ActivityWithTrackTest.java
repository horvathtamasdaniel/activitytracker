package activity;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;


public class ActivityWithTrackTest {


    Track track = new Track();
    Activity activityWithTrack = new ActivityWithTrack(
            track, ActivityType.RUNNING
    );

    @Test
    public void testGetDistance() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        System.out.println(activityWithTrack.getDistance());
        assertThat(activityWithTrack.getDistance(), closeTo(13611579.62, 0.05));
    }


    @Test
    public void testGetType() {
        assertThat(activityWithTrack.getType(), is(ActivityType.RUNNING));
    }
}