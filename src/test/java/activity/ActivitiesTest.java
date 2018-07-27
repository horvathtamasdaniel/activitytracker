package activity;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ActivitiesTest {

    Track track = new Track();

    Activities activities = new Activities(Arrays.asList(
            new ActivityWithTrack(track, ActivityType.RUNNING),
            new ActivityWithoutTrack(ActivityType.BASKETBALL),
            new ActivityWithTrack(track, ActivityType.RUNNING)));

    @Test
    public void testNumberOfWithTrack() {

        assertThat(activities.numberOfTrackActivities(), is(2));
    }

    @Test
    public void testNumberOfWithoutTrack() {

        assertThat(activities.numberOfWithoutTrackActivities(), is(1));
    }

    @Test
    public void testGetReportType() {

        List<Report> result = new LinkedList<>();
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        result = activities.distancesByTypes();

        assertThat(result.get(0).getActivityType(), is(ActivityType.BASKETBALL));
        assertThat(result.get(3).getActivityType(), is(ActivityType.RUNNING));
    }

    @Test
    public void testGetReportDistance() {

        List<Report> result = new LinkedList<>();
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        result = activities.distancesByTypes();

        assertThat(result.get(1).getDistance(), is(0.0));
        assertThat(result.get(3).getDistance(), is(2 * track.getDistance()));
        assertThat(result.get(0).getDistance(), is(0.0));
    }
}