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

        final int R = 6371;

        double latDistance = Math.toRadians(trackPoint.getCoordinate().getLatitude() - this.coordinate.getLatitude());
        double lonDistance = Math.toRadians(trackPoint.getCoordinate().getLongitude() - this.coordinate.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(this.coordinate.getLatitude())) * Math.cos(Math.toRadians(trackPoint.getCoordinate().getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = elevation - trackPoint.getElevation();

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }


}
