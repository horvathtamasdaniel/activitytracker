package activity;

public class TrackPoint {

    private Coordinate coordinate;
    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }

    public double getDistanceFrom(TrackPoint trackPoint) {
        double elevationSquared = Math.pow(this.elevation - trackPoint.getElevation(),2);
        double partialresult2 = Math.sqrt(elevationSquared + coordinateDistanceSquared(trackPoint.getCoordinate()));
        return Math.round(partialresult2 * 100.0) / 100.0;
    }

    private double coordinateDistanceSquared(Coordinate coordinate2) {
        double asquared = Math.pow(this.coordinate.getLatitude() - coordinate2.getLatitude(), 2);
        double bsquared = Math.pow(this.coordinate.getLongitude() - coordinate2.getLongitude(), 2);
        double partailresult = asquared + bsquared;
        return partailresult;
    }
}
