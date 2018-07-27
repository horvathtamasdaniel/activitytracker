package activity;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class TrackTest {

    public Track track = new Track();

    @Test
    public void testAddItemGetPoinsts() {
        assertThat(track.getTrackPoints().size(), is(0));
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        assertThat(track.getTrackPoints().size(), is(1));
        assertThat(track.getTrackPoints().get(0).getCoordinate().getLongitude(), is(34.89));
    }

    @Test
    public void testFullElevation() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 200));

        assertThat(track.getFullElevation(), is(201.0));
    }

    @Test
    public void testFullDecrese() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 200));

        assertThat(track.getFullDecrease(), is(124.0));
    }

    @Test
    public void testGetDistance() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        assertThat(track.getDistance(), closeTo(13611579.62, 0.05));
    }

    @Test
    public void testFindMinimumCoordinate() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        assertThat(track.findMinimumCoordinate().getLatitude(), is(-12.5));
        assertThat(track.findMinimumCoordinate().getLongitude(), is(-42.789));
    }

    @Test
    public void testFindMaximumCoordinate() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        assertThat(track.findMaximumCoordinate().getLatitude(), is(13.7));
        assertThat(track.findMaximumCoordinate().getLongitude(), is(45.7));
    }

    @Test
    public void testGetRectangleArea() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        assertThat(track.getRectangleArea(), is(2318.4118));
    }
}