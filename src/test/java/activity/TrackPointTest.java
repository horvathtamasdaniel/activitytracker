package activity;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;


public class TrackPointTest {


    TrackPoint trackPoint = new TrackPoint(new Coordinate(12.5, 34.89), 123);
    TrackPoint trackPoint2 = new TrackPoint(new Coordinate(12.6, 34.123), 200);

    @Test
    public void testCreateTrackPoint() {

        assertThat(trackPoint.getCoordinate().getLongitude(), is(34.89));
        assertThat(trackPoint.getCoordinate().getLatitude(), is(12.5));
        assertThat(trackPoint.getElevation(), is(123.0));

    }

    @Test
    public void testGetDistance() {
        assertThat(trackPoint.getDistanceFrom(trackPoint2), closeTo(83988.06, 0.05));
    }
}