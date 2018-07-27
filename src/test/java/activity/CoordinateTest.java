package activity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CoordinateTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void testInvalidLatitude() {
        expectedException.expect(IllegalArgumentException.class);
        Coordinate coordinate = new Coordinate(190.5, -34.789);
    }

    @Test
    public void testInvalidLongitude() {
        expectedException.expect(IllegalArgumentException.class);
        Coordinate coordinate = new Coordinate(30.5, -200.0);
    }

    @Test
    public void testInvalidCoordinate() {
        expectedException.expect(IllegalArgumentException.class);
        Coordinate coordinate = new Coordinate(-91.0, 180.1);
    }

    @Test
    public void testCreateCoordinate() {
        Coordinate coordinate = new Coordinate(12.5, -34.789);
        assertThat(coordinate.getLatitude(), is(12.5));
        assertThat(coordinate.getLongitude(), is(-34.789));
    }
}