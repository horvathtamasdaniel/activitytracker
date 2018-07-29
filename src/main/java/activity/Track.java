package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        if (trackPoint == null) {
            throw new IllegalArgumentException("Trackpoint must not be null!");
        }
        trackPoints.add(trackPoint);
    }

    public double getDistance() {
        if (isInvalidList(trackPoints)) {
            throw new IllegalArgumentException("List must not be null or empty!");
        }
        if (trackPoints.size() == 1) {
            return 0.0;
        }
        double sum = 0.0;

        for (int i = 0; i < (trackPoints.size() - 1); i++) {
            sum += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
        }
        return sum;
    }

    public double getFullDecrease() {
        if (isInvalidList(trackPoints)) {
            throw new IllegalArgumentException("List must not be null or empty!");
        }
        double sum = 0.0;

        for (int i = 0; i < (trackPoints.size() - 1); i++) {
            if (trackPoints.get(i + 1).getElevation() < trackPoints.get(i).getElevation()) {
                sum += (trackPoints.get(i).getElevation() - trackPoints.get(i + 1).getElevation());
            }
        }
        return sum;
    }

    public double getFullElevation() {
        if (isInvalidList(trackPoints)) {
            throw new IllegalArgumentException("List must not be null or empty!");
        }
        double sum = 0.0;

        for (int i = 0; i < (trackPoints.size() - 1); i++) {
            if (trackPoints.get(i + 1).getElevation() > trackPoints.get(i).getElevation()) {
                sum += (trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation());
            }
        }
        return sum;
    }

    public Coordinate findMaximumCoordinate() {
        if (isInvalidList(trackPoints)) {
            throw new IllegalArgumentException("List must not be null or empty!");
        }
        double maxLat = trackPoints.get(0).getCoordinate().getLatitude();

        double maxLong = trackPoints.get(0).getCoordinate().getLongitude();

        for (TrackPoint tp: trackPoints) {
            if (tp.getCoordinate().getLatitude() > maxLat) {
                maxLat = tp.getCoordinate().getLatitude();
            }
            if (tp.getCoordinate().getLongitude() > maxLong) {
                maxLong = tp.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLat, maxLong);
    }

    public Coordinate findMinimumCoordinate() {
        if (isInvalidList(trackPoints)) {
            throw new IllegalArgumentException("List must not be null or empty!");
        }
        double minLat = trackPoints.get(0).getCoordinate().getLatitude();

        double minLong = trackPoints.get(0).getCoordinate().getLongitude();

        for (TrackPoint tp: trackPoints) {
            if (tp.getCoordinate().getLatitude() < minLat) {
                minLat = tp.getCoordinate().getLatitude();
            }
            if (tp.getCoordinate().getLongitude() < minLong) {
                minLong = tp.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat, minLong);
    }

    public double getRectangleArea() {
        double a = (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude());

        double b = (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());

        return (a * b);
    }

    private boolean isInvalidList(List list) {
        if ((list == null) || (list.size() == 0)) {
            return true;
        }
        return false;
    }
}